package model;

import model.Car;

import java.util.ArrayList;
import java.util.Comparator;

public class CarShowroom {
    private String name = "";
    private ArrayList<Car> cars = new ArrayList<>();


    public ArrayList<Car> getCars() {
        return cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void sortUp() {
        if(cars.size() != 0) {
            cars.sort(Comparator.comparing(Car::getModel));
        } else {
            System.out.println("error#sortUp(cars.size == 0)");
        }
    }

    public void sortDown() {
        if(cars.size() != 0) {
            cars.sort(Comparator.comparing(Car::getModel).reversed());
        } else {
            System.out.println("error#sortDown(cars.size == 0)");
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void deleteCarForModel(String model) {
        Car findInput = findCarForModel(model);
        if(cars.contains(findInput)) {
            cars.remove(findInput);
        } else {
            System.out.println("error#deleteCarForModel(not find car in carshowroom)");
        }
    }

    public void deleteCarForColor(String color) {
        Car findInput = findCarForModel(color);
        if(cars.contains(findInput)) {
            cars.remove(findInput);
        } else {
            System.out.println("error#deleteCarForColor(not find car in carshowroom)");
        }
    }

    public Car findCarForModel(String model) {
        Car carOutput = null;
        for (Car car : cars) {
            if(car.getModel().equals(model)) {
                carOutput = car;
                break;
            }
        }
        return carOutput;
    }

    public Car findCarForColor(String color) {
        Car carOutput = new Car();
        for (Car car : cars) {
            if(car.getColor().equals(color)) {
                carOutput = car;
                break;
            }
        }
        return carOutput;
    }




}
