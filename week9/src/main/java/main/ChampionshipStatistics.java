package main;

import java.util.List;

//calcs average points for drivers
public class ChampionshipStatistics {
    public static double averagePointsPerDriver(List<Driver> drivers) {
        return drivers.stream().mapToInt(Driver::getTotalPoints).average().orElse(0.0);
    }
    //gets the country of the driver with the most points
    public static String mostSuccessfulCountry(List<Driver> drivers) {
        return drivers.stream()
                .max((a, b) -> Integer.compare(a.getTotalPoints(), b.getTotalPoints()))
                .map(Driver::getCountry).orElse("None");
    }
    //calcs all points for drivers
    public static int totalChampionshipPoints(List<Driver> drivers) {
        return drivers.stream().mapToInt(Driver::getTotalPoints).sum();
    }
}
