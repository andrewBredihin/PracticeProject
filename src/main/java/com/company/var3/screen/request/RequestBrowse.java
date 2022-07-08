package com.company.var3.screen.request;

import io.jmix.ui.component.HasValue;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.DataComponents;
import io.jmix.ui.screen.*;
import com.company.var3.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Request.browse")
@UiDescriptor("request-browse.xml")
@LookupComponent("requestsTable")
public class RequestBrowse extends StandardLookup<Request> {

    @Autowired
    private CollectionLoader<Request> requestsDl;

    @Subscribe("initiatorNameField")
    public void onInitiatorNameFieldValueChange(HasValue.ValueChangeEvent event) {
        if (event.getValue() != null) {
            requestsDl.setParameter("name", "(?i)%" + event.getValue() + "%");
        } else {
            requestsDl.removeParameter("name");
        }
        requestsDl.load();
    }
}