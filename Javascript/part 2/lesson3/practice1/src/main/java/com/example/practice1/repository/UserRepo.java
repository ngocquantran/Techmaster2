package com.example.practice1.repository;

import com.example.practice1.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepo {
    private ConcurrentHashMap<Integer, User> users;
    private ConcurrentHashMap<String,Integer> mapUserNames;

    public UserRepo() {
        users=new ConcurrentHashMap<>();
        mapUserNames=new ConcurrentHashMap<>();
        users.put(1000, new User(1000, "ngocquan", "quan@gmail.com", "ngocquan1234", "asset/avt1.jpg"));
        mapUserNames.put("ngocquan",1000);
        users.put(1001, new User(1001, "thanhhuyen", "huyen@gmail.com", "huyen1234", "asset/avt2.png"));
        mapUserNames.put("thanhhuyen",1001);
    }

    public ConcurrentHashMap<Integer, User> getAllUsers(){
        return users;
    }

    public ConcurrentHashMap<String,Integer> getIdByUserName(){
        return mapUserNames;
    }


}
