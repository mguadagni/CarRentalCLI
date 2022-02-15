package com.careerdevs;

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

        UI.scanner.nextLine();

        if (userSelection == availableCars.size() + 1) {
            System.out.println("Bringing you back to the main menu...");
            mainMenu();
        } else {
            String selectedCar = availableCars.get(userSelection-1).getName();
            boolean rentalConfirm = UI.yesOrNo("Are you sure you want to rent the " + selectedCar + "?");
            if (rentalConfirm) {
                String rentalName = UI.readString("Enter the name you would like to use for this rental");
                availableCars.get(userSelection-1).setRentedName(rentalName);
                System.out.println("You are now renting the " + selectedCar + ", " + rentalName);
                availableCars.get(userSelection-1).setRented(true);
                System.out.println("Now bringing you back to the main menu...\n");
                mainMenu();
            } else {
                rentalMenu();
            }

        }
    }

    private static void initializeCarStorage () {
        carStorage = new ArrayList<>();

        Car car1 = new Car("Honda", "Accord", true, "jeff", " ");
        Car car2 = new Car("Chevy", "Cruze", false, " ", " ");
        Car car3 = new Car("Toyota", "Corolla", false, " ", " ");
        Car car4 = new Car("Ford", "F150", true, "erika", " ");
        Car car5 = new Car("Nissan", "Altima", false, " ", " ");

        carStorage.addAll(List.of(new Car[]{car1, car2, car3, car4, car5}));
    }

    private static void mainMenu () {
        System.out.println("Would you like to...");
        System.out.println("1) Rent (" + getAvailableCars().size() + " cars available)");
        System.out.println("2) Return (" + getRentedCars().size() + " cars available)");
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
        return carStorage.stream().filter(Car::isRented).collect(Collectors.toCollection(ArrayList::new));
    }

    private static void returnMenu() {

        ArrayList<Car> rentedCars = getRentedCars();

        System.out.println("\nAvailable Cars:\n");
        for (int i = 0; i < rentedCars.size(); i++) {
            System.out.println(i+1 + ") " + rentedCars.get(i).getName());
        }

        System.out.println((rentedCars.size() + 1) + ") Return back to Main Menu");

        int userSelection = UI.readInt("Enter a number to select the car you'd like to return. ", 1, rentedCars.size() + 1);

        UI.scanner.nextLine();

        if (userSelection == rentedCars.size() + 1) {
            System.out.println("Bringing you back to the main menu...");
            mainMenu();
        } else {
            String selectedCar = rentedCars.get(userSelection-1).getName();
            boolean returnConfirm = UI.yesOrNo("Are you sure you want to return the " + selectedCar + "?");
            if (returnConfirm) {
                String returnName = UI.readString("Enter the name you used to rent this car");
                rentedCars.get(userSelection-1).setReturnName(returnName);
                    if (getRentedCars().get(userSelection-1).getRentedName().equals(getRentedCars().get(userSelection-1).getReturnName())) {
                        System.out.println("You have now returned the " + selectedCar + ", " + returnName);
                        rentedCars.get(userSelection - 1).setRented(false);
                        rentedCars.get(userSelection - 1).setReturnName("");
                        System.out.println("Now bringing you back to the main menu...\n");
                        mainMenu();
                    } else {
                        System.out.println("Incorrect Name.");
                        System.out.println("Would you like to...\n");
                        System.out.println("1) Try again");
                        System.out.println("2) Return to main menu");
                        int returnCarError = UI.readInt(" ",1,2);
                        if (returnCarError == 1) {
                            while (true) {
                                System.out.println("Please enter the correct name");
                                String attemptedName = UI.scanner.nextLine();
                                if (attemptedName.equals(getRentedCars().get(userSelection-1).getRentedName())) {
                                    System.out.println("You have now returned the " + selectedCar + ", " + attemptedName);
                                    rentedCars.get(userSelection - 1).setRented(false);
                                    rentedCars.get(userSelection - 1).setReturnName("");
                                    System.out.println("Now bringing you back to the main menu...\n");
                                    mainMenu();
                                    break;
                                }

                            }
                        } else {
                            System.out.println("Now bringing you back to the main menu...\n");
                            mainMenu();
                        }
                    }

            } else {
                returnMenu();
            }
        }
    }
}

