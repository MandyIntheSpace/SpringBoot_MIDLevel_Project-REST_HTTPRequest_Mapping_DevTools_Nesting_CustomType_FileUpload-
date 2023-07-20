package com.example.rest.bootrestbook.controller;

import com.example.rest.bootrestbook.Model.Book;
import com.example.rest.bootrestbook.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

//    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @GetMapping(value = "/books")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping(value = "/books/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    @PostMapping(value = "/books")
    public Book addBook(@RequestBody Book book) {
        Book b = this.bookService.addBook(book);
        System.out.println(b);
        return b;
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
         this.bookService.deleteBook(bookId);
        System.out.println("The record of the book has been deleted");
    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        this.bookService.updateBook(book, bookId);
        return book;
    }

//    @PutMapping("/books/{bookId}")
//    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId){
//        Book updateBook = this.bookService.updateBook(book, bookId);
//        if (updateBook != null) {
//            return new ResponseEntity<>(updateBook, HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
