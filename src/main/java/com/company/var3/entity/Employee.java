package com.company.var3.entity;

import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "EMPLOYEE", indexes = {
        @Index(name = "IDX_EMPLOYEE", columnList = "DEPARTMENT_ID, USER_ID")
})
@JmixEntity
@Entity
@PrimaryKeyJoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
public class Employee extends Initiator {

    @JoinColumn(name = "JOB_TITLE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private JobTitle jobTitle;

    @JoinColumn(name = "DEPARTMENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @JoinColumn(name = "USER_ID", nullable = false, unique = true)
    @Composition
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}