package com.company.var3.screen.department;

import io.jmix.ui.screen.*;
import com.company.var3.entity.Department;

@UiController("Department.edit")
@UiDescriptor("department-edit.xml")
@EditedEntityContainer("departmentDc")
public class DepartmentEdit extends StandardEditor<Department> {
}