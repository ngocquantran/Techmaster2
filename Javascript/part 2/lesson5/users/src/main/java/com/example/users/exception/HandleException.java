package com.example.users.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class HandleException {

    // Xử lý cho trường hợp BadRequest
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleBadRequestException(BadRequestException e){
        log.error("Lỗi rồi fix đi");
        return new ErrorMessage(HttpStatus.BAD_REQUEST,e.getMessage());
    }

//  Xử lý exception NotFound
    @ExceptionHandler(com.example.users.exception.NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public com.example.users.exception.ErrorMessage handleNotFoundException(com.example.users.exception.NotFoundException e) {
        return new com.example.users.exception.ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
    }


//    Xử lý những exception còn lại
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public com.example.users.exception.ErrorMessage handleOtherException(Exception e) {
        return new com.example.users.exception.ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}
