package com.careerdevs.classdemo;

import com.careerdevs.classdemo.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentalService {

    private static ArrayList<Car> carStorage;

    public static void main(String[] args) {
        initializeCarStorage();
        carStorage.get(0).setRented(true);
        carStorage.get(3).setRented(true);
        rentalMenu();

    }

    private static ArrayList<Car> filterCars(boolean filterRented) {

        ArrayList<Car> filteredCars = new ArrayList<>();
        for (int i = 0; i < carStorage.size(); i++) {
            boolean keepCar = carStorage.get(i).isRented();
            if (filterRented) keepCar = !keepCar;
            if ( keepCar ) {
                filteredCars.add(carStorage.get(i));
            }
        }
        return filteredCars;
    }

    private static ArrayList<Car> getAvailableCars () {
        return carStorage.stream().filter(car -> !car.isRented()).collect(Collectors.toCollection(ArrayList::new));
    }

    private static void rentalMenu() {

        ArrayList<Car> availableCars = getAvailableCars();

        System.out.println("\nAvailable Cars:\n");
        for (int i = 0; i < availableCars.size(); i++) {
            System.out.println(i+1 + ") " + availableCars.get(i).getName());
        }

        int userSelection = UI.readInt("Enter a number to select the car you'd like to rent", 1, availableCars.size());

        System.out.println(availableCars.get(userSelection-1).getName());
        availableCars.get(userSelection-1).setRented(true);
    }

    private static void initializeCarStorage () {
        carStorage = new ArrayList<>();

        Car car1 = new Car("Honda", "Accord", false);
        Car car2 = new Car("Chevy", "Cruze", false);
        Car car3 = new Car("Toyota", "Corolla", false);
        Car car4 = new Car("Ford", "F150", false);
        Car car5 = new Car("Nissan", "Altima", false);

        carStorage.addAll(List.of(new Car[]{car1, car2, car3, car4, car5}));
    }
}

//        System.out.println("\nRENTAL MENU\n");
//        int listNumber = 1;
//        for (int i = 0; i < carStorage.size(); i++) {
//            if ( !carStorage.get(i).isRented() ) {
//                System.out.println(listNumber + ") " + carStorage.get(i).getName());
//                listNumber++;
//            }
//        }
//
//        int userSelection = UI.readInt("Enter a number to select the car you'd like to rent", 1, listNumber - 1);
//
//        System.out.println(carStorage.get(userSelection-1).getName());