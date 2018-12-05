package com.example.maryjoe.segapp;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AddServiceTest {

    @Test
    public void checkEmpty() {

        try {
            ArrayList<String> ls = new ArrayList<String>(2);
            AddService addService = new AddService(ls);

            boolean expected = true;
            boolean actual = addService.checkEmpty(ls);
            assertEquals(actual, expected);
        }
        catch (Exception e){System.out.println("Error Occured");}
    }
}