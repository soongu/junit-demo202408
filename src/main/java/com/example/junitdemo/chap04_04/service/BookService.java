// src/main/java/com/example/junitdemo/chap04_04/service/BookService.java
package com.example.junitdemo.chap04_04.service;

import com.example.junitdemo.chap04_04.entity.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    private final Map<Long, Book> bookRepository = new HashMap<>();
    private Long idCounter = 1L;

    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(bookRepository.get(id));
    }

    public Book saveBook(Book book) {
        book.setId(idCounter++);
        bookRepository.put(book.getId(), book);
        return book;
    }

    public Optional<Book> updateBook(Long id, Book book) {
        if (bookRepository.containsKey(id)) {
            book.setId(id);
            bookRepository.put(id, book);
            return Optional.of(book);
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteBook(Long id) {
        return bookRepository.remove(id) != null;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookRepository.values());
    }
}