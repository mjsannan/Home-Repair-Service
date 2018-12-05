package com.example.maryjoe.segapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class RateServiceTest5 {

    RateService rateService = new RateService();

    @Test
    public void commentEmpty() {

        boolean expected = false;
        rateService.setComment("Good Job");
        boolean actual = rateService.commentEmpty();
        assertEquals(actual, expected);

    }
}