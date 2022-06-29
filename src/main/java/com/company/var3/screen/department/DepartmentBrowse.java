package com.company.var3.screen.department;

import io.jmix.ui.screen.*;
import com.company.var3.entity.Department;

@UiController("Department.browse")
@UiDescriptor("department-browse.xml")
@LookupComponent("departmentsTable")
public class DepartmentBrowse extends StandardLookup<Department> {
}