package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceTest1 {

    BookService bookService = new BookService();

    @Test
    public void getName() {

        String expecetd = "Cleaning";
        bookService.setName("Cleaning");
        String actual = bookService.getName();
        assertEquals(actual, expecetd);

    }

    @Test
    public void getDate() {

        String expecetd = "21-12-2018";
        bookService.setDate("21-12-2018");
        String actual = bookService.getDate();
        assertEquals(actual, expecetd);
    }

    @Test
    public void getTime() {

        String expeceted = "13:05";
        bookService.setTime("13:05");
        String actual = bookService.getTime();
        assertEquals(actual, expeceted);
    }
}