package com.company.var3.screen.employee;

import com.company.var3.app.EmployeeService;
import com.company.var3.entity.User;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.*;
import com.company.var3.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
public class EmployeeEdit extends StandardEditor<Employee> {

    @Autowired
    private EmployeeService employeeService;

    @Subscribe("userField")
    public void onUserFieldValueChange(HasValue.ValueChangeEvent<User> event) {
        /*if (employeeService.checkForUser(event.getValue().getId()))
        {
            event.getComponent().setValue(null);
        }*/
    }
}