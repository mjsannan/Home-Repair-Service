package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserInformationTest {

    UserInformation userInformation = new UserInformation();

    @Test
    public void getPrice() {
        String expected = "30";
        userInformation.setPrice("30");
        String actual = userInformation.getPrice();
        assertEquals(actual, expected);
    }

    @Test
    public void getService() {
        String expected = "Movers";
        userInformation.setService("Movers");
        String actual = userInformation.getService();
        assertEquals(actual, expected);
    }
    @Test
    public void getName() {
        String expeceted = "Test";
        userInformation.setName("Test");
        String actual = userInformation.getName();
        assertEquals(actual, expeceted);
    }

    @Test
    public void getEmail() {
        String expeceted = "Test@test.com";
        userInformation.setEmail("Test@test.com");
        String actual = userInformation.getEmail();
        assertEquals(actual, expeceted);
    }

    @Test
    public void getAccountType() {
        String expeceted = "Admin";
        userInformation.setAccountType("Admin");
        String actual = userInformation.getAccountType();
        assertEquals(actual, expeceted);
    }
}