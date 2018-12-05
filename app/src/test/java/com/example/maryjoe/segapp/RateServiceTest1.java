package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class RateServiceTest1 {

    RateService rateService = new RateService();

    @Test
    public void getServiceName() {

        String expected = "Cleaning";
        rateService.setName("Cleaning");
        String actual = rateService.getServiceName();
        assertEquals(actual, expected);

    }

    @Test
    public void getServiceRating() {

        String expected = "4";
        rateService.setRate("4");
        String actual = rateService.getServiceRating();
        assertEquals(actual, expected);
    }

    @Test
    public void getServiceComment() {
        String expected = "Good Job";
        rateService.setComment("Good Job");
        String actual = rateService.getServiceComment();
        assertEquals(actual, expected);
    }
}