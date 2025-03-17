package main;

public class Main {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        Driver driver1 = new Driver("Sébastien Ogier", "France");
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland");
        Driver driver3 = new Driver("Ott Tänak", "Estonia");
        Driver driver4 = new Driver("Thierry Neuville", "Belgium");
        
        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);
        
        RallyCar car1 = new GravelCar("Toyota", "Yaris", 380);
        RallyCar car2 = new AsphaltCar("Hyundai", "i20", 400);

        RallyRaceResult race1 = new RallyRaceResult("Rally Finland");
        race1.recordResult(driver1, 25);
        race1.recordResult(driver3, 18);
        race1.recordResult(driver2, 15);
        race1.recordResult(driver4, 12);
        manager.addRace(race1);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally");
        race2.recordResult(driver2, 25);
        race2.recordResult(driver4, 18);
        race2.recordResult(driver1, 15);
        race2.recordResult(driver3, 12);
        manager.addRace(race2);

        manager.displayStandings();
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(manager.getLeadingDriver().getName() + " with " + manager.getLeadingDriver().getTotalPoints() + " points");

        System.err.println("\n ===== CHAMPIONSHIP STATISTICS =====");
        System.err.println("Total Drivers: " + manager.getDrivers().size());
        System.out.println("Total Races: " + manager.getRaces().size());
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.averagePointsPerDriver(manager.getDrivers()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.mostSuccessfulCountry(manager.getDrivers()));
        System.out.println("Total Championship Points: " + ChampionshipStatistics.totalChampionshipPoints(manager.getDrivers()));

        System.out.println("\n===== RACE RESULTS =====");
        race1.displayResults();
        race2.displayResults();
        
        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + car1.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + car2.calculatePerformance());
    }
}
