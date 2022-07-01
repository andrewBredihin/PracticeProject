package com.company.var3.screen.employee;

import com.company.var3.app.EmployeeService;
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

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (employeeService.checkForUser(getEditedEntity().getUser().getId())) {
            dialogs.createOptionDialog()
                    .withCaption("Message")
                    .withMessage("Этот пользователь уже выбран")
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