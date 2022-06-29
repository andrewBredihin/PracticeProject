package com.company.var3.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum JobTitles implements EnumClass<String> {

    NEW_VALUE("Title 1"),
    NEW_VALUE1("Title 2");

    private String id;

    JobTitles(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static JobTitles fromId(String id) {
        for (JobTitles at : JobTitles.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}