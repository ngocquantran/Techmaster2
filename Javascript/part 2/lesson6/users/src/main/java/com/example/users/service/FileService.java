package com.example.users.service;

import com.example.users.exception.BadRequestException;
import com.example.users.util.Utils;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {

    //    Path folder để upload file
    private final Path rootPath = Paths.get("uploads");

    public FileService() {
        createFolder(rootPath.toString());
    }

    //    Tạo folder
    public void createFolder(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public String uploadFile(int id, MultipartFile file) {
//B1: Tạo folder tương ứng user id
        Path userDir = Paths.get("uploads").resolve(String.valueOf(id));
        createFolder(userDir.toString());

//        B2: Validate File
        validate(file);

//        B3:Tạo path tương ứng vs file upload
        String generateFileId = String.valueOf(Instant.now().getEpochSecond());
        File fileServer = new File(userDir + "/" + generateFileId);

        try {
//            Sử dụng buffer để lưu dữ liệu từ file
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileServer));
            stream.write(file.getBytes());
            stream.close();
            return "/api/v1/users/" + id + "/files/" + generateFileId;


        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi upload");
        }
    }

    public void validate(MultipartFile file) {
//        Kiểm tra tên file
        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.equals("")) {
            throw new BadRequestException("Tên file không hợp lệ");
        }

//        Kiểm tra đuôi file(định dạng)
        String fileExtension = Utils.getExtensionFile(fileName);
        if (!Utils.checkFileExtension(fileExtension)) {
            throw new BadRequestException("File không hợp lệ");
        }

//        Kiểm tra size file(upload dưới 2MB)
        if ((double) file.getSize() / 1_000_000L > 2) {
            throw new BadRequestException("File không được vượt quá 2MB");
        }

    }

    //    Xem file
    public byte[] readFile(int id, String fileId) {
//        Lấy đường dẫn file tương ứng
        Path userPath = rootPath.resolve(String.valueOf(id));

//        Kiểm tra userPath có toofnt ại không
        if (!Files.exists(userPath)) {
            throw new RuntimeException(("Lỗi khi đọc file" + fileId));
        }

        try {
            Path file = userPath.resolve(fileId);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                InputStream inputStream=resource.getInputStream();
                byte[] byArr=StreamUtils.copyToByteArray(inputStream);
                inputStream.close();
                return byArr;
            } else {
                throw new RuntimeException("Lỗi khi đọc file" + fileId);
            }

        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi đọc file" + fileId);
        }
    }

    //    Xóa file
    public void deleteFile(int id, String fileId) {
        Path userPath = rootPath.resolve(String.valueOf(id));
        if (!Files.exists(userPath)) {
            throw new RuntimeException(("Lỗi khi đọc file" + fileId));
        }

        Path file = userPath.resolve(fileId);
        if (!file.toFile().exists()) {
            throw new RuntimeException("file " + fileId + " không tồn tại");
        }
        file.toFile().delete();
        System.out.println("Xóa thành công");
    }

//    Lấy danh sách file

    public List<String> getFiles(int id) {
        Path userPath = rootPath.resolve(String.valueOf(id));
        if (!Files.exists(userPath)) {
           return new ArrayList<>();
        }

//       Lấy danh sách file của user


       File[] files= userPath.toFile().listFiles();
        return Arrays.stream(files)
                .map(file -> file.getName())
                .sorted((f1,f2)->f2.compareTo(f1))
                .map(f -> "api/v1/users/"+id+"/files/"+f)
                .collect(Collectors.toList());
    }

}
