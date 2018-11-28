package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignInTest {

    SignIn signIn = new SignIn();

    @Test
    public void getPass() {
        String expected = "password";
        signIn.setPass("password");
        String actual = signIn.getPass();
        assertEquals(expected, actual);
    }

    @Test
    public void getEmail() {
        String expected = "test@test.com";
        signIn.setEmail("test@test.com");
        String actual = signIn.getEmail();
        assertEquals(expected, actual);
    }
}