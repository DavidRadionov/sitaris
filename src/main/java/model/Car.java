package model;

public class Car {
    private String model;
    private String color;
    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public Car(){}
    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
