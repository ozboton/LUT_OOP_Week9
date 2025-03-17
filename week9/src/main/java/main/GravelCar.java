package main;

public class GravelCar extends RallyCar {
    public GravelCar(String make, String model, int horsepower) {
        super(make, model, horsepower);
    }

    @Override
    public double calculatePerformance() {
        return Math.round((horsepower * 1.05 + 40) * 10.0) / 10.0;
    }
}
