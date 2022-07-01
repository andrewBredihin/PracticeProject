package com.company.var3.app;

import com.company.var3.entity.User;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private DataManager dataManager;

    public boolean checkForUser(UUID id){
        User user = dataManager.loadValues("select u " +
                "from Employee e inner join User u " +
                "on e.user = u " +
                "where u.id = '" + id.toString() + "\'")
                .properties("user")
                .list()
                .stream().map(e -> e.<User>getValue("user"))
                .findFirst()
                .orElse(null);
        if (user != null)
            return true;
        return false;
    }
}