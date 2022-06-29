package com.company.var3.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum StatusEnum implements EnumClass<String> {

    NEW_VALUE("Open"),
    NEW_VALUE1("Closed");

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