package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceTest3 {

    BookService bookService = new BookService();

    @Test
    public void dateEmpty() {

        boolean expected = true;
        bookService.setDate("");
        boolean actual = bookService.dateEmpty();
        assertEquals(actual, expected);
    }
}