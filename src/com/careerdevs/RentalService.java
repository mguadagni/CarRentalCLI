package com.careerdevs;

import com.careerdevs.ui.UserInput;

//need to create separate methods and call them within main
//mainMenu()
//rentACar()
//returnACar()
//exitProgram()

public class RentalService {
    public static void main(String[] args) {
        System.out.println("Welcome to Michael's Car Rental Service!");

        //create list/array
        Car[] carStorage = new Car[3];

        //create object instances
        Car car1 = new Car("Honda", "Accord");
        Car car2 = new Car("Chevy", "Cruze");
        Car car3 = new Car("Toyota", "Corolla");

        //store object instances in list/array
        carStorage[0] = car1;
        carStorage[1] = car2;
        carStorage[2] = car3;

        //How do we list just Rented/Available cars?
        //Iterate through array, only display cars where isRented is false
        System.out.println("Available Cars:");
        int listNumber = 1;

        for (int i = 0; i < carStorage.length; i++) {

            if (!carStorage[i].isRented()) {
                System.out.println("(" + listNumber + ") " + carStorage[i].getName());
                listNumber++;
            }

        }

        int userSelection = UserInput.readInt("Enter a number to select the car you'd like to rent:", 1, 3);
        carStorage[userSelection - 1].setRented(true);
        System.out.println("Thank you! You are now renting the " + carStorage[userSelection - 1].getMake() + " " +
                carStorage[userSelection - 1].getModel());



    }
}
