package com.company.var3.screen.employee;

import com.company.var3.entity.Request;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.var3.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
public class EmployeeBrowse extends StandardLookup<Employee> {

    @Autowired
    private CollectionLoader<Employee> employeesDl;

    @Autowired
    private CollectionLoader<Request> requestsDl;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        employeesDl.load();
    }

    @Subscribe(id = "employeesDc", target = Target.DATA_CONTAINER)
    public void onInitiatorsDcItemChange(InstanceContainer.ItemChangeEvent<Employee> event) {
        requestsDl.setParameter("employee", event.getItem());
        requestsDl.load();
    }
}