package com.company.var3.screen.initiator;

import com.company.var3.entity.Request;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.var3.entity.Initiator;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Initiator.browse")
@UiDescriptor("initiator-browse.xml")
@LookupComponent("initiatorsTable")
public class InitiatorBrowse extends StandardLookup<Initiator> {

    @Autowired
    private CollectionLoader<Initiator> initiatorsDl;

    @Autowired
    private CollectionLoader<Request> requestsDl;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        initiatorsDl.load();
    }

    @Subscribe(id = "initiatorsDc", target = Target.DATA_CONTAINER)
    public void onInitiatorsDcItemChange(InstanceContainer.ItemChangeEvent<Initiator> event) {
        requestsDl.setParameter("initiator", event.getItem());
        requestsDl.load();
    }
}