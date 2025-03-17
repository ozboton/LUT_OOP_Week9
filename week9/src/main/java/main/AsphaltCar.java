package main;

public class AsphaltCar extends RallyCar {
    public AsphaltCar(String manufacturer, String model, int horsepower) {
        super(manufacturer, model, horsepower);
    }

    @Override
    public double calculatePerformance() {
        return Math.round((horsepower * 1.15 + 25) * 10.0) / 10.0;
    }
}