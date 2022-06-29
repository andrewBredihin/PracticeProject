package com.company.var3.screen.request;

import io.jmix.ui.screen.*;
import com.company.var3.entity.Request;

@UiController("Request.browse")
@UiDescriptor("request-browse.xml")
@LookupComponent("requestsTable")
public class RequestBrowse extends StandardLookup<Request> {
}