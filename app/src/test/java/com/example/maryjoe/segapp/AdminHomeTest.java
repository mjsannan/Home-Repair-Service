package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdminHomeTest {

    AdminHome adminHome = new AdminHome();

    @Test
    public void getService() {
        String expecetd = "Lawn Mowing";
        adminHome.setService("Lawn Mowing");
        String actual = adminHome.getService();
        assertEquals(actual, expecetd);
    }
}