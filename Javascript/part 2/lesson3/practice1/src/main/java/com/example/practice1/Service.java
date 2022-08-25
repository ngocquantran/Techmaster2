package com.example.practice1;


import com.example.practice1.model.User;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@org.springframework.stereotype.Service
public class Service {

    public String getRandomColorName(){
        String[] arr={"red","green","blue","yellow","orange"};
        Random rd=new Random();
        int index= rd.nextInt(arr.length-1);
        return arr[index];
    }

    public String getRandomColorHex(){
        StringBuilder sb=new StringBuilder("#");
        String str="0123456789abcdef";
        for (int i=1;i<=6;i++){
            Random rd=new Random();
            int index= rd.nextInt(str.length()-1);
            sb.append(str.charAt(index));
        }
        return sb.toString();

    }

    public String getRandomColorRGB(){
        StringBuilder sb=new StringBuilder("rgb(");
        Random rd=new Random();
        for (int i=1;i<=3;i++){
            int index= rd.nextInt(255);
            sb.append(index);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        return sb.toString();

    }

    public double bmiCalculate(double height,double weight){
        double bmi= (double) Math.round(weight/Math.pow(height,2)*100)/100;
        return bmi;
    }

    public User getUser(ConcurrentHashMap<Integer, User> users,ConcurrentHashMap<String,Integer> mapUserNames,String username, String password){
        if (!mapUserNames.containsKey(username)){
            return null;
        }
        User user=users.get(mapUserNames.get(username));
        if (user.getPassword().equals(password)){
            return user;
        }else {
            return null;
        }

    }



}
