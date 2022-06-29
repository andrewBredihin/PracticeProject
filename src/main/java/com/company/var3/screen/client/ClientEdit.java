package com.company.var3.screen.client;

import io.jmix.ui.screen.*;
import com.company.var3.entity.Client;

@UiController("Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
public class ClientEdit extends StandardEditor<Client> {
}