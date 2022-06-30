package com.company.var3.screen.employee;

import io.jmix.ui.screen.*;
import com.company.var3.entity.Employee;

@UiController("Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
public class EmployeeBrowse extends StandardLookup<Employee> {
}