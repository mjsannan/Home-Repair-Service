package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class RateServiceTest3 {

    RateService rateService = new RateService();

    @Test
    public void serviceEmpty() {

        boolean expected = false;
        rateService.setName("Cleaning");
        boolean actual = rateService.serviceEmpty();
        assertEquals(actual, expected);

    }

}