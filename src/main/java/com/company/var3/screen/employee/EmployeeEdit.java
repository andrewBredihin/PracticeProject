package com.company.var3.screen.employee;

import com.company.var3.app.EmployeeService;
import com.company.var3.entity.User;
import io.jmix.core.EntityStates;
import io.jmix.ui.Dialogs;
import io.jmix.ui.action.DialogAction;
import io.jmix.ui.screen.*;
import com.company.var3.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
public class EmployeeEdit extends StandardEditor<Employee> {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private Dialogs dialogs;

    @Autowired
    private EntityStates entityStates;

    private User firstUser;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        //Проверка на нового Employee либо изменение старого
        if (entityStates.isNew(getEditedEntity()) || firstUser != getEditedEntity().getUser()){
            if (employeeService.checkForUser(getEditedEntity().getUser().getId())) {
                dialogs.createOptionDialog()
                        .withCaption("Message")
                        .withMessage("Этот пользователь уже выбран ")
                        .withActions(
                                new DialogAction(DialogAction.Type.OK).withHandler(e -> {
                                    getWindow().setFocusComponent("userField");
                                    event.preventCommit();
                                })
                        )
                        .show();

                event.preventCommit();
            }
        }
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        //Получить изначально выбранного User у Employee
        firstUser = getEditedEntity().getUser();
    }
}