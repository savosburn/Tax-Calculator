/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Savannah Osburn
 */

package ex14;

import java.text.DecimalFormat;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);
    public static double WI_TAX = 0.055;

    public static void main(String[] args) {
        App myApp = new App();

        // Input
        String orderAmount = myApp.readOrderAmount();
        String state = myApp.readState();

        // Calculations and Output
        String output = myApp.generateOutput(state, orderAmount);
        myApp.outputString(output);
    }

    public String readOrderAmount() {
        System.out.print("What is the order amount? ");

        while (!in.hasNextDouble()) {
            System.out.print("Invalid amount. Enter again: ");
            in.nextLine();
        }

        return in.nextLine();
    }

    public String readState() {
        System.out.print("What is the state? (ex: TX) ");

        while (in.hasNextDouble()) {
            System.out.print("Invalid state. Enter again: ");
            in.nextLine();
        }

        return in.nextLine().toUpperCase();
    }

    public String generateOutput(String state, String orderAmount) {
        double price = Double.parseDouble(orderAmount);

        String str1 = "The total is ";

        // Only do tax if the state is wisconsin
        if (state.equals("WI")) {
            DecimalFormat df = new DecimalFormat("'$'#.##");

            double tax = price * WI_TAX;
            String taxRounded = df.format(tax);

            String str2 = String.format("The tax is %s.\n", taxRounded);

            // You need the total that has total with the tax
            return str2 + str1 + String.format("$%.2f.", price + tax);
        }

        // You just need the base total
        return str1 + String.format("$%.2f.", price);
    }

    public void outputString(String output) {
        System.out.println(output);
    }
}
