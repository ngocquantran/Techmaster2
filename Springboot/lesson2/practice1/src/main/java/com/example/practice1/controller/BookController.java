package com.example.practice1.controller;

import com.example.practice1.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {
    private ConcurrentHashMap<String, Book> books;

    public BookController(){
        books=new ConcurrentHashMap<>();
        books.put("111",new Book("111","Chí Phèo","Nam Cao",1975));
        books.put("112",new Book("112","Truyện Kiều","Nguyễn Du",1250));
        books.put("113",new Book("113","Chiếc lá cuối cùng","XXX",1950));
        books.put("114",new Book("114","Cánh buồm ngoài xa","Huy Cận",1990));

    }

    @GetMapping
    public List<Book> getBooks(){
        return books.values().stream().collect(Collectors.toList());
    }
}
