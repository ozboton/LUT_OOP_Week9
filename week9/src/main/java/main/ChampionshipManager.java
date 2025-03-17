package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> races;

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

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addRace(RallyRaceResult race) {
        races.add(race);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<RallyRaceResult> getRaces() {
        return races;
    }
    
    public void displayStandings() {
        List<Driver> sortedDrivers = drivers.stream()
                .sorted((a, b) -> Integer.compare(b.getTotalPoints(), a.getTotalPoints()))
                .collect(Collectors.toList());

        for (int i = 0; i < sortedDrivers.size(); i++) {
            Driver driver = sortedDrivers.get(i);
            System.out.println((i + 1) + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getTotalPoints() + " points");
        }
    }

    public Driver getLeadingDriver() {
        return drivers.stream().max((a, b) -> Integer.compare(a.getTotalPoints(), b.getTotalPoints())).orElse(null);
    }
}