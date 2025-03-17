package main;


//create rally car class, which is used for asphalt and gravel car
public abstract class RallyCar {
    protected String make;
    protected String model;
    protected int horsepower;

    public RallyCar(String make, String model, int horsepower) {
        this.make = make;
        this.model = model;
        this.horsepower = horsepower;
    }
    
    public abstract double calculatePerformance();
}
