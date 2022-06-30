package com.company.var3.screen.employee;

import io.jmix.ui.screen.*;
import com.company.var3.entity.Employee;

@UiController("Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
public class EmployeeEdit extends StandardEditor<Employee> {
}