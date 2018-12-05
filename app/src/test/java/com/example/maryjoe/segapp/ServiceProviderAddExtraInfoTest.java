package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceProviderAddExtraInfoTest {

    ServiceProviderAddExtraInfo sInfo = new ServiceProviderAddExtraInfo("123 Test Ave.", "1234567890", "Testing Co.", "I am a tester","yes");

    @Test
    public void getAddress() {
        String expected = "123 Test Ave.";
        String actual = sInfo.getAddress();
        assertEquals(expected, actual);
    }

    @Test
    public void getPhoneNum() {
        String expected = "1234567890";
        String actual = sInfo.getPhoneNum();
        assertEquals(expected, actual);
    }

    @Test
    public void getCompanyName() {
        String expected = "Testing Co.";
        String actual = sInfo.getCompanyName();
        assertEquals(expected, actual);
    }

    @Test
    public void getDescription() {
        String expected = "I am a tester";
        String actual = sInfo.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    public void getLicensed() {
        String expected = "yes";
        String actual = sInfo.getLicensed();
        assertEquals(expected, actual);
    }
}