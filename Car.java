package vehicle;
import java.util.*;
public abstract class Car {
    private String carMake;
    private String carModel;
    private double odometer;

    public Car(String make, String model, double startingMileage){
        carMake = make;
        carModel = model;

        if (startingMileage < 0) {
            throw new IllegalArgumentException("FAILED: The starting mileage CANNOT be negative.");
        }
        else {
            odometer = startingMileage; 
        }
    }

    public Car(String make, String model){
        carMake = make;
        carModel = model;
        odometer = 0; 
    }

    public boolean canDrive(double miles){
        if (miles < 0){
            throw new IllegalArgumentException("FAILED: A car cannot drive NEGATIVE miles.");
        }

        if (getRemainingRange() - miles >= 0) {
            return true;
        }
        else {
            return false;
        }
    }   

    public abstract void drive (double miles);

    public String toString(){
        return String.format("%s %s (%.1f mi)", getMake(), getModel(), getMileage());
    }

    public double getMileage(){
        return odometer;
    }

    public String getMake(){
        return carMake;
    }   

    public String getModel(){
        return carModel;
    }

    public abstract double getRemainingRange();

    protected void addMileage(double miles){
        odometer += miles;
    }

    public int roadTrip (List<Double> milesEachDay){
        int days = 0;
        for (int i = 0; i < milesEachDay.size(); i++){
            if (milesEachDay.get(i) < 0) {
                throw new IllegalArgumentException("FAILED: The starting mileage CANNOT be negative.");
            }
            else if (canDrive(milesEachDay.get(i))){
                drive(milesEachDay.get(i));
                days++;
            }
            else {
                return days;
            }
        }
        return milesEachDay.size();
    }
}