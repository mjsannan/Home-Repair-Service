package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpTest {

    SignUp signUp = new SignUp("Admin", "Test", "test@test.com", "Test", "testtest");

    @Test
    public void getNameOfUser() {
        String expected = "Test";
        String actual = signUp.getNameOfUser();
        assertEquals(actual, expected);
    }

    @Test
    public void getEmailOfUser() {
        String expected = "test@test.com";
        String actual = signUp.getEmailOfUser();
        assertEquals(actual, expected);
    }

    @Test
    public void getUsernameOfUser() {
        String expected = "Test";
        String actual = signUp.getUsernameOfUser();
        assertEquals(actual, expected);
    }

    @Test
    public void getPasswordOfUser() {
        String expected = "testtest";
        String actual = signUp.getPasswordOfUser();
        assertEquals(actual, expected);
    }

    @Test
    public void getAccountType() {
        String expected = "Admin";
        String actual = signUp.getAccountType();
        assertEquals(actual, expected);
    }
}