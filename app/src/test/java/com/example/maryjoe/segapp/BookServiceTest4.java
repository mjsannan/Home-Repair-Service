package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceTest4 {

    BookService bookService = new BookService();

    @Test
    public void timeEmpty() {

        boolean expected = false;
        bookService.setTime("13:05");
        boolean actual = bookService.timeEmpty();
        assertEquals(actual, expected);
    }
}