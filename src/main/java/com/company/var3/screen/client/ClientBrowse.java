package com.company.var3.screen.client;

import com.company.var3.entity.Request;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.var3.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Client.browse")
@UiDescriptor("client-browse.xml")
@LookupComponent("clientsTable")
public class ClientBrowse extends StandardLookup<Client> {

    @Autowired
    private CollectionLoader<Client> clientsDl;

    @Autowired
    private CollectionLoader<Request> requestsDl;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        clientsDl.load();
    }

    @Subscribe(id = "clientsDc", target = Target.DATA_CONTAINER)
    public void onInitiatorsDcItemChange(InstanceContainer.ItemChangeEvent<Client> event) {
        requestsDl.setParameter("initiator", event.getItem());
        requestsDl.load();
    }
}