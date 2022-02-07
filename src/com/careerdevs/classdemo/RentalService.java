package com.careerdevs.classdemo;

//import com.careerdevs.classdemo.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentalService {

    private static ArrayList<Car> carStorage;

    public static void main(String[] args) {
        System.out.println("Welcome to Java Car Rentals!");
        initializeCarStorage();
        mainMenu();
        System.out.println("Thank you for using the program, goodbye!");
    }

//    private static ArrayList<Car> filterCars(boolean filterRented) {
//
//        ArrayList<Car> filteredCars = new ArrayList<>();
//        for (int i = 0; i < carStorage.size(); i++) {
//            boolean keepCar = carStorage.get(i).isRented();
//            if (filterRented) keepCar = !keepCar;
//            if ( keepCar ) {
//                filteredCars.add(carStorage.get(i));
//            }
//        }
//        return filteredCars;
//    }

    private static ArrayList<Car> getAvailableCars () {
        return carStorage.stream().filter(car -> !car.isRented()).collect(Collectors.toCollection(ArrayList::new));
    }

    private static void rentalMenu() {

        ArrayList<Car> availableCars = getAvailableCars();

        System.out.println("\nAvailable Cars:\n");
        for (int i = 0; i < availableCars.size(); i++) {
            System.out.println(i+1 + ") " + availableCars.get(i).getName());
        }

        System.out.println((availableCars.size() + 1) + ") Return back to Main Menu");

        int userSelection = UI.readInt("Enter a number to select the car you'd like to rent. ", 1, availableCars.size() + 1);

        if (userSelection == availableCars.size() + 1) {
            System.out.println("Bringing you back to the main menu...");
            mainMenu();
        } else {
            String selectedCar = availableCars.get(userSelection-1).getName();
            System.out.println("You are now renting the " + selectedCar);
            availableCars.get(userSelection-1).setRented(true);
            System.out.println("Now bringing you back to the main menu...\n");
            mainMenu();
        }
    }

    private static void initializeCarStorage () {
        carStorage = new ArrayList<>();

        Car car1 = new Car("Honda", "Accord", false);
        Car car2 = new Car("Chevy", "Cruze", true);
        Car car3 = new Car("Toyota", "Corolla", false);
        Car car4 = new Car("Ford", "F150", true);
        Car car5 = new Car("Nissan", "Altima", false);

        carStorage.addAll(List.of(new Car[]{car1, car2, car3, car4, car5}));
    }

    private static void mainMenu () {
        System.out.println("Would you like to...");
        System.out.println("1) Rent");
        System.out.println("2) Return");
        System.out.println("3) Exit the program");

        int mainMenuSelection = UI.readInt("",1, 3);

        if (mainMenuSelection == 1) {
            if (getAvailableCars().size() == 0) {
                System.out.println("Sorry, there are no available cars to rent.");
                System.out.println("Now bringing you back to the main menu...\n");
                mainMenu();
            } else {
                rentalMenu();
            }

        } else if (mainMenuSelection == 2) {
            if (getRentedCars().size() == 0) {
                System.out.println("Sorry, there are no available cars to return.");
                System.out.println("Now bringing you back to the main menu...\n");
                mainMenu();
            } else {
                returnMenu();
            }
        }
    }

    private static ArrayList<Car> getRentedCars () {
        return carStorage.stream().filter(car -> car.isRented()).collect(Collectors.toCollection(ArrayList::new));
    }

    private static void returnMenu() {

        ArrayList<Car> rentedCars = getRentedCars();

        System.out.println("\nAvailable Cars:\n");
        for (int i = 0; i < rentedCars.size(); i++) {
            System.out.println(i+1 + ") " + rentedCars.get(i).getName());
        }

        System.out.println((rentedCars.size() + 1) + ") Return back to Main Menu");

        int userSelection = UI.readInt("Enter a number to select the car you'd like to return. ", 1, rentedCars.size() + 1);

        if (userSelection == rentedCars.size() + 1) {
            System.out.println("Bringing you back to the main menu...");
            mainMenu();
        } else {
            String selectedCar = rentedCars.get(userSelection-1).getName();
            System.out.println("You have now returned the " + selectedCar);
            rentedCars.get(userSelection-1).setRented(false);
            System.out.println("Now bringing you back to the main menu...\n");
            mainMenu();
        }
    }
}
