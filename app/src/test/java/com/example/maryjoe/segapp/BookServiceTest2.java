package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceTest2 {

    BookService bookService = new BookService();

    @Test
    public void nameEmpty() {

        boolean expected = false;
        bookService.setName("Cleaning");
        boolean actual = bookService.nameEmpty();
        assertEquals(actual, expected);
    }
}