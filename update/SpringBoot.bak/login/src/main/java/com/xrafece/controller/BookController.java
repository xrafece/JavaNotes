package com.xrafece.controller;

import com.xrafece.entity.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xrafece
 */
@RestController
@RequestMapping("book")
public class BookController {
    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1, "第一本书"));
    }

    @GetMapping("api")
    public List<Book> listBooksApi() {
        return books;
    }

    @GetMapping("api/{id}")
    public Book getBookApi(Integer id) {
        Book book = new Book();
        book.setId(id);
        return books.contains(book) ? null : book;
    }

    @PostMapping("api/{id}/{name}")
    public List<Book> addBookApi(@PathVariable("id") int id, @PathVariable("name") String name) {
        Book book = new Book(id, name);
        books.add(book);
        return books;
    }

    @DeleteMapping("api/{id}")
    public List<Book> removeBookApi(@PathVariable("id") int id) {
        if (id <= books.size()) {
            books.remove(id);
        }
        return books;
    }


}
