package main;

public class AsphaltCar extends RallyCar {
    public AsphaltCar(String make, String model, int horsepower) {
        super(make, model, horsepower);
    }

    @Override
    public double calculatePerformance() {
        return Math.round((horsepower * 1.15 + 25) * 10.0) / 10.0;
    }
}
