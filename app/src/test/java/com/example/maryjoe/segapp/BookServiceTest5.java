package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceTest5 {

    BookService bookService = new BookService();

    @Test
    public void success() {

        boolean expected = false;
        bookService.setName("Cleaning");
        bookService.setDate("21-12-2018");
        bookService.setTime("");
        boolean actual = bookService.success();
        assertEquals(actual, expected);

    }
}