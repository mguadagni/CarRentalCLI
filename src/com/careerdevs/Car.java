package com.careerdevs;

public class Car {
    private String make;
    private String model;
    private boolean isRented;
    private String rentedName;
    private String returnName;

    public Car(String make, String model, boolean isRented, String rentedName, String returnName) {
        this.make = make;
        this.model = model;
        this.isRented = isRented;
        this.rentedName = rentedName;
        this.returnName = returnName;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getName () {
        return make + " " + model;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getRentedName() {
        return rentedName;
    }

    public String getReturnName() {
        return returnName;
    }

    public void setRentedName(String rentedName) {
        this.rentedName = rentedName;
    }

    public void setReturnName(String returnName) {
        this.returnName = returnName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", isRented=" + isRented +
                ", rentedName='" + rentedName + '\'' +
                ", returnName='" + returnName + '\'' +
                '}';
    }
}