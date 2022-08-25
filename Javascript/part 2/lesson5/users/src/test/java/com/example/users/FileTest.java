package com.example.users;


import com.example.users.service.FileService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class FileTest {

    @Test
    public void checkPath(){
        FileService fileService=new FileService();

//        String userDir=Paths.get("").toAbsolutePath().toString();
//        System.out.println(userDir);
//        Path curPath=Paths.get(userDir);
//        System.out.println(curPath);
//        Path parent=curPath.getParent();
//        System.out.println(parent);



    }
}
