package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdminAddUserTest {

    AdminAddUser adminAddUser = new AdminAddUser();

    @Test
    public void getService() {
        String expected = "Dog Walker";
        adminAddUser.setServiceType("Dog Walker");
        String actual = adminAddUser.getService();
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceService() {
        String expected = "10";
        adminAddUser.setPriceOfService("10");
        String actual = adminAddUser.getPriceService();
        assertEquals(expected, actual);
    }
}