package com.example.thymleafdemo.service;

import com.example.thymleafdemo.model.Student;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class StudentService {
    public ConcurrentHashMap<String, Student> getAllStudent(){
        ConcurrentHashMap<String, Student> students=new ConcurrentHashMap<>();
        String id1= UUID.randomUUID().toString();
        students.put(id1,new Student(id1,"Trần Văn Phong","12A1", LocalDate.of(2002,07,15),"nam"));
        String id2= UUID.randomUUID().toString();
        students.put(id2,new Student(id2,"Trần Huyền Trang","12A3", LocalDate.of(2002,01,25),"nữ"));
        String id3= UUID.randomUUID().toString();
        students.put(id3,new Student(id3,"Trần Thanh Hùng","12A2", LocalDate.of(2002,12,10),"nam"));
        return students;
    }
}
