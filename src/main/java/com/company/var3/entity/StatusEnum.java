package com.company.var3.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum StatusEnum implements EnumClass<String> {

    OPEN("Открыта"),
    CLOSED("Закрыта"),
    PENDING("На рассмотрении"),
    AGREEMENT("На согласованнии"),
    APPROVAL("На утверждении");

    private String id;

    StatusEnum(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static StatusEnum fromId(String id) {
        for (StatusEnum at : StatusEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}