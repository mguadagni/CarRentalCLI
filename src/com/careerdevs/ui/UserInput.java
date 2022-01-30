package com.careerdevs.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String readString (String question) {
        while (true) {
            System.out.println("\nInput: ");
            String inputString = scanner.nextLine();

            if (!inputString.trim().equals("") ) {
                return inputString.trim();
            }
            System.out.println("You must enter something!");
        }

    }

    public static int readInt (String question) {
        while (true) {

            try {
                System.out.println(question + "\nSelection: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You must enter an integer, try again");
                scanner.nextLine();
            }

        }
    }
}
