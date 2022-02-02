package com.careerdevs.classdemo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
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

    public static int readInt (String question, int min, int max) {
        while (true) {

            try {
                System.out.println(question + "\nNumber (" + min + " - " + max + "):");
                int userSelect = scanner.nextInt();
                if (userSelect >= min && userSelect <= max) {
                    return userSelect;
                }
                System.out.println("Number must be in the range (" + min + "-" + max + ")");

            } catch (InputMismatchException e) {
                System.out.println("You must enter an integer, try again");
                scanner.nextLine();
            }

        }
    }
}