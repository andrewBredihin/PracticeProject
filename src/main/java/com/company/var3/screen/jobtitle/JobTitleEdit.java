package com.company.var3.screen.jobtitle;

import io.jmix.ui.screen.*;
import com.company.var3.entity.JobTitle;

@UiController("JobTitle.edit")
@UiDescriptor("job-title-edit.xml")
@EditedEntityContainer("jobTitleDc")
public class JobTitleEdit extends StandardEditor<JobTitle> {
}