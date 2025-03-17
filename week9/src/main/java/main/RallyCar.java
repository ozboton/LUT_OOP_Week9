package main;

public abstract class RallyCar {
    protected String manufacturer;
    protected String model;
    protected int horsepower;

    public RallyCar(String manufacturer, String model, int horsepower) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.horsepower = horsepower;
    }
    
    public abstract double calculatePerformance();
}