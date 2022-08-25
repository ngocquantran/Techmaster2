package com.demo3.controller;

import com.demo3.model.Book;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book book() {
        return new Book("x112", "Dế Mèn Phiêu Lưu ", "Tô Hoài");
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public Book book_xml() {
        return new Book("x111", "Dế Mèn Phiêu Lưu Ký", "Tô Hoài");
    }

    @GetMapping("/multi/{a}/{b}")
    public int multi(@PathVariable("a") int c,@PathVariable("b") int d){
        return c*d;
    }

    @GetMapping("/multi")
    public int multi2(@RequestParam("a") int c,@RequestParam("b") int d){
        return c*d;
    }

    @PostMapping("/hello")
    public Message sayHello(@RequestBody Message message){
        return message;
    }


}
