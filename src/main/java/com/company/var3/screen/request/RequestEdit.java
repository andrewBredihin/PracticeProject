package com.company.var3.screen.request;

import io.jmix.ui.screen.*;
import com.company.var3.entity.Request;

@UiController("Request.edit")
@UiDescriptor("request-edit.xml")
@EditedEntityContainer("requestDc")
public class RequestEdit extends StandardEditor<Request> {
}