package com.company.var3.screen.jobtitle;

import io.jmix.ui.screen.*;
import com.company.var3.entity.JobTitle;

@UiController("JobTitle.browse")
@UiDescriptor("job-title-browse.xml")
@LookupComponent("jobTitlesTable")
public class JobTitleBrowse extends StandardLookup<JobTitle> {
}