package com.example.users.service;

import com.example.users.dto.UserDto;
import com.example.users.exception.BadRequestException;
import com.example.users.exception.NotFoundException;
import com.example.users.mapper.UserMapper;
import com.example.users.model.User;
import com.example.users.request.CreateUserRequest;
import com.example.users.request.UpdatePasswordRequest;
import com.example.users.request.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired private FileService fileService;
    private List<User> users;

    public UserService() {
        initData();
    }

    public void initData() {
        users = new ArrayList<>();
        users.add(new User(1, "Nguyễn Văn A", "a@gmail.com", "0123456789", "Tỉnh Thái Bình", null, "111"));
        users.add(new User(2, "Trần Văn B", "b@gmail.com", "0123456789", "Tỉnh Nam Định", null, "222"));
        users.add(new User(3, "Ngô Thị C", "c@gmail.com", "0123456789", "Tỉnh Hưng Yên", null, "333"));
    }

    public List<UserDto> getUsers() {
        return users.stream()
                .map(user -> UserMapper.toUserDto(user))
                .collect(Collectors.toList());
    }

    public List<UserDto> searchUsers(String name) {
        return users.stream()
                .filter(user -> user.getName().toLowerCase().trim().contains(name.toLowerCase().trim()))
                .map(user -> UserMapper.toUserDto(user))
                .collect(Collectors.toList());
    }

    public void deleteUser(int id) {
        if (findUser(id).isEmpty()) {
            throw new NotFoundException("Không có user có id= " + id);
        }
        users.removeIf(user -> user.getId() == id);


    }


    //    Create User
    public UserDto createUser(CreateUserRequest request) {
        if (findUser(request.getEmail()).isPresent()) {
            throw new BadRequestException("Email đã được sử dụng: " + request.getEmail());
        }

        Random rd = new Random();
        User user = new User();
        user.setId(rd.nextInt(100 - 4 + 1) + 4);
        user.setName(request.getName());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        users.add(user);
        return UserMapper.toUserDto(user);

    }

    //    Lấy thông tin user theo id
    public UserDto getUserById(int id) {
        Optional<User> user = findUser(id);
        if (user.isEmpty()) {
            throw new NotFoundException("Không tồn tại user có id=" + id);
        }
        return UserMapper.toUserDto(user.get());
    }

    public UserDto updateUser(int id, UpdateUserRequest request) {
        Optional<User> user = findUser(id);
        if (user.isEmpty()) {
            throw new NotFoundException("Không tồn tại user có id=" + id);
        }
        User updatedUser = user.get();
        updatedUser.setName(request.getName());
        updatedUser.setAddress(request.getAddress());
        updatedUser.setPhone(request.getPhone());
        return UserMapper.toUserDto(updatedUser);

    }

    public void updatePassword(int id, UpdatePasswordRequest request){
        Optional<User> optionalUseruser = findUser(id);
        if (optionalUseruser.isEmpty()) {
            throw new NotFoundException("Không tồn tại user có id=" + id);
        }
        User user = optionalUseruser.get();

//        Kiểm tra mk cũ đúng không
        if (!user.getPassword().equals(request.getOldPassword())){
            throw new BadRequestException("Mật khẩu cũ không chính xác");
        }

//        Kiểm tra mk cũ có trùng mk mới không
        if (request.getOldPassword().equals(request.getNewPassword())){
            throw new BadRequestException("Mật khẩu mới và mật khẩu cũ không được trùng nhau");
        }

        user.setPassword(request.getNewPassword());
    }

//    Forgot password
    public String forgotPassword(int id){
        Optional<User> optionalUser = findUser(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("Không tồn tại user có id=" + id);
        }
        User user = optionalUser.get();
//        tạo mk mới
        Random rd=new Random();
        String password=String.valueOf(rd.nextInt(1000-100)+100) ;
        user.setPassword(password);
        return password;
    }


//    Upload file
    public String uploadFile(int id, MultipartFile file){
        Optional<User> optionalUser = findUser(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("Không tồn tại user có id=" + id);
        }
        return fileService.uploadFile(id,file);
    }

//    Xem file

    public byte[] readFile(int id,String fileId){
        return fileService.readFile(id,fileId);

    }

    public void deleteFile(int id,String fileId){
        fileService.deleteFile(id,fileId);
    }

    public List<String> getFiles(int id){
        Optional<User> optionalUser = findUser(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("Không tồn tại user có id=" + id);
        }
        return fileService.getFiles(id);
    }

    public void updateAvt(int id, String path){
        Optional<User> optionalUser = findUser(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("Không tồn tại user có id=" + id);
        }
        User user= optionalUser.get();
        user.setAvatar(path);
    }


//    Helper method

    public Optional<User> findUser(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }


    public Optional<User> findUser(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }


}
