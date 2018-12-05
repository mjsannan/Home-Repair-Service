package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class RateServiceTest2 {

    RateService rateService = new RateService();

    @Test
    public void correctRating() {

        boolean expected = true;
        rateService.setRate("3");
        boolean actual = rateService.correctRating();
        assertEquals(actual, expected);
    }
}