package com.lapi.library.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lapi.library.exception.BookNotFoundException;
import com.lapi.library.model.Book;

@Service
public class BookService {

    private Map<Integer, Book> bookStore = new HashMap<>();

    public Book addBook(Book book) {

        if (bookStore.containsKey(book.getId())) {
            throw new RuntimeException(
                    "Book with ID " + book.getId() + " already exists");
        }

        bookStore.put(book.getId(), book);
        return book;
    }

    public Book getBookById(int id) {

        Book book = bookStore.get(id);

        if (book == null) {
            throw new BookNotFoundException(
                    "Book not found with ID: " + id);
        }

        return book;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookStore.values());
    }

    public List<Book> getBooksByYear(int year) {

        List<Book> result = new ArrayList<>();

        for (Book book : bookStore.values()) {
            if (book.getYear() == year) {
                result.add(book);
            }
        }

        return result;
    }

    public void deleteBook(int id) {

        if (!bookStore.containsKey(id)) {
            throw new BookNotFoundException(
                    "Cannot delete. Book not found with ID: " + id);
        }

        bookStore.remove(id);
    }
}
