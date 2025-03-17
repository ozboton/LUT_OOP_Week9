package main;

import java.util.List;


public class ChampionshipStatistics {
    public static double averagePointsPerDriver(List<Driver> drivers) {
        return drivers.stream().mapToInt(Driver::getTotalPoints).average().orElse(0.0);
    }

    public static String mostSuccessfulCountry(List<Driver> drivers) {
        return drivers.stream()
                .max((a, b) -> Integer.compare(a.getTotalPoints(), b.getTotalPoints()))
                .map(Driver::getCountry).orElse("None");
    }

    public static int totalChampionshipPoints(List<Driver> drivers) {
        return drivers.stream().mapToInt(Driver::getTotalPoints).sum();
    }
}