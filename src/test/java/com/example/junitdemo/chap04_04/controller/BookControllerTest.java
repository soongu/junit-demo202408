// src/test/java/com/example/junitdemo/chap04_04/controller/BookControllerTest.java
package com.example.junitdemo.chap04_04.controller;

import com.example.junitdemo.chap04_03.dto.BookSaveDTO;
import com.example.junitdemo.chap04_04.entity.Book;
import com.example.junitdemo.chap04_04.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetBookById() throws Exception {
        // Given
        Book book = new Book(1L, "Effective Java", "Joshua Bloch");
        given(bookService.getBookById(1L)).willReturn(Optional.of(book));

        // When & Then
        mockMvc.perform(get("/books/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Effective Java"))
                .andExpect(jsonPath("$.author").value("Joshua Bloch"));
    }

    @Test
    void testGetBookByIdNotFound() throws Exception {
        // Given
        given(bookService.getBookById(2L)).willReturn(Optional.empty());

        // When & Then
        mockMvc.perform(get("/books/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateBook() throws Exception {
        // Given
        Book savedBook = new Book(2L, "Clean Code", "Robert C. Martin");
        given(bookService.saveBook(any(Book.class))).willReturn(savedBook);

        // When & Then
        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Clean Code\", \"author\": \"Robert C. Martin\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.title").value("Clean Code"))
                .andExpect(jsonPath("$.author").value("Robert C. Martin"));
    }

    @Test
    void testUpdateBook() throws Exception {
        // Given
        Book updatedBook = new Book(1L, "Effective Java (2nd Edition)", "Joshua Bloch");
        given(bookService.updateBook(eq(1L), any(Book.class))).willReturn(Optional.of(updatedBook));

        // When & Then
        mockMvc.perform(put("/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Effective Java (2nd Edition)\", \"author\": \"Joshua Bloch\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Effective Java (2nd Edition)"))
                .andExpect(jsonPath("$.author").value("Joshua Bloch"));
    }

    @Test
    void testUpdateBookNotFound() throws Exception {
        // Given
        Book updatedBook = new Book(2L, "Effective Java (2nd Edition)", "Joshua Bloch");
        given(bookService.updateBook(eq(2L), any(Book.class))).willReturn(Optional.empty());

        // When & Then
        mockMvc.perform(put("/books/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Effective Java (2nd Edition)\", \"author\": \"Joshua Bloch\"}"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteBook() throws Exception {
        // Given
        given(bookService.deleteBook(1L)).willReturn(true);

        // When & Then
        mockMvc.perform(delete("/books/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteBookNotFound() throws Exception {
        // Given
        given(bookService.deleteBook(2L)).willReturn(false);

        // When & Then
        mockMvc.perform(delete("/books/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateBook2() throws Exception {
        // Given

        // DTO
        BookSaveDTO bookDto = new BookSaveDTO("Clean Code", "Robert C. Martin");

        Book savedBook = new Book(2L, "Clean Code", "Robert C. Martin");
        given(bookService.saveBook(any(Book.class))).willReturn(savedBook);

        // When & Then
        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookDto))) // 객체를 JSON으로 변환하여 전달
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2L))
                .andExpect(jsonPath("$.title").value("Clean Code"))
                .andExpect(jsonPath("$.author").value("Robert C. Martin"));
    }
}