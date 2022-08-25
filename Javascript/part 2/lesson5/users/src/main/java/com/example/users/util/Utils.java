package com.example.users.util;

import java.util.Arrays;
import java.util.List;

public class Utils {
//    Lấy extension file
//    image.png,avatar.jpg
    public static String getExtensionFile(String fileName){
        int lastIndexOf=fileName.lastIndexOf(".");
        if (lastIndexOf==-1){
            return "";
        }
        return fileName.substring(lastIndexOf+1);
    }


//        Kiểm tra extension có nằm trong danh sách được upload không
    public static boolean checkFileExtension(String fileExtension){
        List<String> extensions= Arrays.asList("png","jpg","jpeg");
        return extensions.contains(fileExtension);
    }
}
