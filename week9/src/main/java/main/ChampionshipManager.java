package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> races;

    //creates arraylist for drivers and races
    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    //register drivers
    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }
    //adds race
    public void addRace(RallyRaceResult race) {
        races.add(race);
    }
    //returns a list of drivers
    public List<Driver> getDrivers() {
        return drivers;
    }
    //returns a list of the races
    public List<RallyRaceResult> getRaces() {
        return races;
    }
    //displays standings
    public void displayStandings() {
        List<Driver> sortedDrivers = drivers.stream()
                .sorted((a, b) -> Integer.compare(b.getTotalPoints(), a.getTotalPoints()))
                .collect(Collectors.toList());

        for (int i = 0; i < sortedDrivers.size(); i++) {
            Driver driver = sortedDrivers.get(i);
            System.out.println((i + 1) + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getTotalPoints() + " points");
        }
    }
    //returns driver with most points
    public Driver getLeadingDriver() {
        return drivers.stream().max((a, b) -> Integer.compare(a.getTotalPoints(), b.getTotalPoints())).orElse(null);
    }
}
