package com.lapi.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.lapi.library.model.Book;
import com.lapi.library.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    // Constructor Injection (BEST PRACTICE)
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 1️⃣ POST /books
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // 2️⃣ GET /books/{id}
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    // 3️⃣ GET /books/search?year=2024
    @GetMapping("/search")
    public List<Book> getBooksByYear(@RequestParam int year) {
        return bookService.getBooksByYear(year);
    }

    // 4️⃣ DELETE /books/{id}
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "Book deleted successfully";
    }
    
 // GET /books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

}
