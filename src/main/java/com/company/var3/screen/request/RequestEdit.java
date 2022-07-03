package com.company.var3.screen.request;

import com.company.var3.app.EmployeeService;
import com.company.var3.app.RequestService;
import com.company.var3.entity.*;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Request.edit")
@UiDescriptor("request-edit.xml")
@EditedEntityContainer("requestDc")
public class RequestEdit extends StandardEditor<Request> {

    @Autowired
    private RequestService requestService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CurrentAuthentication currentAuthentication;


    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {

        Request request = getEditedEntity();
        //Авторизированный пользователь
        User user = (User) currentAuthentication.getUser();

        //Заблокировать все поля кроме поля со статусом заявки
        if (requestService.checkRequestInDB(request.getId())){
            //Необходимо заменить циклом либо изменить доступ пользователей
            getWindow().getComponent("executorField").setEnabled(false);
            getWindow().getComponent("initiatorField").setEnabled(false);
            getWindow().getComponent("descriptionField").setEnabled(false);
            getWindow().getComponent("startDateField").setEnabled(false);
            getWindow().getComponent("endDateField").setEnabled(false);

            if (request.getInitiator().getClass().equals(Client.class)){
                if (!request.getExecutor().getUser().equals(user))
                    //Заблокировать поле изменения статуса заявки, если:
                    //инициатор - внешний клиент
                    //авторизированный пользователь - не является исполнителем данной заявки
                    getWindow().getComponent("statusField").setEnabled(false);
            }
            else {
                User initiator = employeeService.getUserByEmployeeId(request.getInitiator().getId());
                if (!initiator.equals(user))
                    //Заблокировать поле изменения статуса заявки, если:
                    //инициатор - пользователь системы User
                    //авторизрованный пользователь - не является инициатором данной заявки
                    getWindow().getComponent("statusField").setEnabled(false);
            }
        }
    }
}