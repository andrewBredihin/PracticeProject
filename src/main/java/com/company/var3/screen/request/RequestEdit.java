package com.company.var3.screen.request;

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
    private CurrentAuthentication currentAuthentication;


    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {

        Request request = getEditedEntity();
        User user = (User) currentAuthentication.getUser();

        if (requestService.checkRequestInDB(request.getId())){
            //Необходимо заменить циклом либо изменить доступ пользователей
            getWindow().getComponent("executorField").setEnabled(false);
            getWindow().getComponent("initiatorField").setEnabled(false);
            getWindow().getComponent("descriptionField").setEnabled(false);
            getWindow().getComponent("startDateField").setEnabled(false);
            getWindow().getComponent("endDateField").setEnabled(false);

            if (request.getInitiator().getClass().equals(Client.class)){
                if (!request.getExecutor().getUser().equals(user))
                    getWindow().getComponent("statusField").setEnabled(false);
            }
            else {
                if (!request.getInitiator().equals(user.getEmployee()))
                    getWindow().getComponent("statusField").setEnabled(false);
            }
        }
    }
}