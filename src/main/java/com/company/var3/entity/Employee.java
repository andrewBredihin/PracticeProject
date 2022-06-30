package com.company.var3.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;

@JmixEntity
@Entity
public class Employee extends Initiator {
    @JoinColumn(name = "DEPARTMENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @JoinColumn(name = "USER_ID", unique = true)
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JobTitles getJobTitle() {
        return jobTitle == null ? null : JobTitles.fromId(jobTitle);
    }

    public void setJobTitle(JobTitles jobTitle) {
        this.jobTitle = jobTitle == null ? null : jobTitle.getId();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}