package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private Map<Driver, Integer> results;

    public RallyRaceResult(String raceName) {
        this.raceName = raceName;
        this.results = new HashMap<>();
    }

    //records points
    @Override
    public void recordResult(Driver driver, int points) {
        if (!results.containsKey(driver)) {  // Ensure no duplicate entries
            results.put(driver, points);
            driver.addPoints(points);
        } else {
            System.out.println("Duplicate entry: " + driver.getName() + " in " + raceName);
        }
    }


    //displays points
    @Override
    public void displayResults() {
        System.out.println("Race: " + raceName);
        List<Map.Entry<Driver, Integer>> sortedResults = results.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sort by points (descending)
                .collect(Collectors.toList());
        
        for (int i = 0; i < sortedResults.size(); i++) {
            Map.Entry<Driver, Integer> entry = sortedResults.get(i);
            System.out.println("  Position " + (i + 1) + ": " + entry.getKey().getName() + " - " + entry.getValue() + " points");
        }
        System.err.println("\n");
    }

}
