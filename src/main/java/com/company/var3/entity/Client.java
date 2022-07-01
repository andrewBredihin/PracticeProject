package com.company.var3.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;

@JmixEntity
@Entity
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