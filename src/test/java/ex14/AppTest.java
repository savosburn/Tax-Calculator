/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Savannah Osburn
 */

package ex14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void output_string_includes_tax_and_total () {
        App myApp = new App();

        String state = "WI";
        String orderAmount = "10.00";

        String expectedOutput = "The total is $10.00.";

        if (state.equals("WI")) {

            expectedOutput = "The tax is $0.55.\n" +
                    "The total is $10.55.";
        }

        String actualOutput = myApp.generateOutput(state, orderAmount);

        assertEquals(expectedOutput, actualOutput);
    }

}