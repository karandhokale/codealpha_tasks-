import java.util.*;
import java.text.*;

public class TravelItineraryPlanner {
    static class Budget {
        double flightCost;
        double accommodationCost;
        double dailySpending;

        Budget(double flightCost, double accommodationCost, double dailySpending) {
            this.flightCost = flightCost;
            this.accommodationCost = accommodationCost;
            this.dailySpending = dailySpending;
        }

        double calculateTotal(int days) {
            return flightCost + accommodationCost * days + dailySpending * days;
        }
    }
    static class Destination {
        String name;
        String weather;  
        String mapUrl;   
        
        Destination(String name, String weather, String mapUrl) {
            this.name = name;
            this.weather = weather;
            this.mapUrl = mapUrl;
        }

        void displayDetails() {
            System.out.println("Destination: " + name);
            System.out.println("Weather: " + weather);
            System.out.println("Map: " + mapUrl);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Destination> itinerary = new ArrayList<>();
        System.out.println("Welcome to the Travel Itinerary Planner!");
        System.out.print("Enter number of destinations: ");
        int numberOfDestinations = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < numberOfDestinations; i++) {
            System.out.println("\nEnter details for destination " + (i + 1) + ":");
            System.out.print("Destination Name: ");
            String name = scanner.nextLine();
            System.out.print("Weather Forecast (e.g., sunny, rainy, etc.): ");
            String weather = scanner.nextLine();
            System.out.print("Map URL (e.g., Google Maps link): ");
            String mapUrl = scanner.nextLine();

            itinerary.add(new Destination(name, weather, mapUrl));
        }
        System.out.print("\nEnter your start date (YYYY-MM-DD): ");
        String startDateStr = scanner.nextLine();
        System.out.print("Enter your end date (YYYY-MM-DD): ");
        String endDateStr = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        
        try {
            startDate = sdf.parse(startDateStr);
            endDate = sdf.parse(endDateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
            return;
        }
        long diff = endDate.getTime() - startDate.getTime();
        int days = (int) (diff / (1000 * 60 * 60 * 24));

        System.out.println("\nYour trip duration is " + days + " days.");
        
        System.out.print("\nEnter your flight cost estimate: ");
        double flightCost = scanner.nextDouble();
        System.out.print("Enter your accommodation cost per night: ");
        double accommodationCost = scanner.nextDouble();
        System.out.print("Enter your estimated daily spending (food, activities, etc.): ");
        double dailySpending = scanner.nextDouble();
        
        Budget budget = new Budget(flightCost, accommodationCost, dailySpending);
        double totalBudget = budget.calculateTotal(days);
        System.out.println("Estimated total budget for the trip: ₹" + totalBudget);

        System.out.println("\nYour Itinerary:");
        for (Destination dest : itinerary) {
            dest.displayDetails();
            System.out.println("Stay duration: " + days + " days\n");
        }

        System.out.println("\nWeather and Map links for your destinations:");
        for (Destination dest : itinerary) {
            System.out.println(dest.name + " - " + dest.weather + " - Map: " + dest.mapUrl);
        }

        scanner.close();
    }
}
