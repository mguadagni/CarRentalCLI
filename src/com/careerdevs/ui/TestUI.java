package com.careerdevs.ui;

public class TestUI {
    public static void main(String[] args) {
        String userInput = UserInput.readString("Who are you?");
        System.out.println("Okay you are : " + userInput);

//        int input = UserInput.readInt("Enter a number");
//        System.out.println(input);
    }
}
