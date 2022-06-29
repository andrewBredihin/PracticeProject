package com.company.var3.screen.initiator;

import io.jmix.ui.screen.*;
import com.company.var3.entity.Initiator;

@UiController("Initiator.browse")
@UiDescriptor("initiator-browse.xml")
@LookupComponent("initiatorsTable")
public class InitiatorBrowse extends StandardLookup<Initiator> {
}