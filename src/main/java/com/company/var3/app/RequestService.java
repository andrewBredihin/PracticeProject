package com.company.var3.app;

import com.company.var3.entity.Request;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RequestService {

    @Autowired
    private DataManager dataManager;

    public boolean checkRequestInDB(UUID id){
        Request request = dataManager.loadValues("select r from Request r " +
                        "where r.id = '" + id.toString() + "\'")
                .properties("request")
                .list()
                .stream().map(e -> e.<Request>getValue("request"))
                .findFirst()
                .orElse(null);
        if (request != null)
            return true;
        return false;
    }
}