package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class RateServiceTest4 {

    RateService rateService = new RateService();

    @Test
    public void ratingEmpty() {

        boolean expected = true;
        rateService.setRate("");
        boolean actual = rateService.ratingEmpty();
        assertEquals(actual, expected);

    }
}