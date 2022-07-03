package com.company.var3.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Table(name = "CLIENT")
@JmixEntity
@Entity
@PrimaryKeyJoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
public class Client extends Initiator {
    @Email
    @Column(name = "MAIL")
    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}