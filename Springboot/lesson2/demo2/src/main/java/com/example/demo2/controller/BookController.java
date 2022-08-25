package com.example.demo2.controller;

import com.example.demo2.dto.BookRequest;
import com.example.demo2.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/book")
public class BookController {
    private ConcurrentHashMap<String, Book> books;

    public BookController() {
        books = new ConcurrentHashMap<>();
        books.put("111", new Book("111", "Chí Phèo", "Nam Cao", 1975));
        books.put("112", new Book("112", "Truyện Kiều", "Nguyễn Du", 1250));
        books.put("113", new Book("113", "Chiếc lá cuối cùng", "XXX", 1950));
        books.put("114", new Book("114", "Cánh buồm ngoài xa", "Huy Cận", 1990));

    }

    @GetMapping
    public List<Book> getBooks() {
        return books.values().stream().collect(Collectors.toList());
    }

    @PostMapping
    public Book createNewBook(@RequestBody BookRequest bookRequest) {
        String uuid = UUID.randomUUID().toString();
        Book newBook = new Book(uuid, bookRequest.title(), bookRequest.author(), bookRequest.year());
        books.put(uuid, newBook);
        return newBook;
    }

    @GetMapping(value = "/{id}")
    public Book getBookById(@PathVariable String id) {
        return books.get(id);
    }



    @GetMapping(value = "/search")
    public Book getBookById2(@RequestParam("id") String id) {
        return books.get(id);
    }

    @PutMapping(value = "/{id}")
    public Book updateBookById(@PathVariable String id, @RequestBody BookRequest bookRequest) {
        Book updateBook = new Book(id, bookRequest.title(), bookRequest.author(), bookRequest.year());
        books.put(id, updateBook);
        return books.get(id);
    }

    @DeleteMapping(value = "/{id}")
    public Book deleteBookById(@PathVariable String id) {
        Book removedBook = books.remove(id);
        return removedBook;
    }

}
