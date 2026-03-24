import java.util.ArrayList;
import java.util.List;

public class TrainManagementApp {

    public static void main(String[] args) {

        // Welcome banner
        System.out.println("=====================================");
        System.out.println("   Train Consist Management App");
        System.out.println("=====================================\n");

        // Create dynamic list for bogies
        List<String> trainConsist = new ArrayList<>();

        // Initial state
        System.out.println("Train initialized successfully...");
        System.out.println("Initial number of bogies: " + trainConsist.size());
        System.out.println("Current train consist: " + trainConsist);

        // ================= UC2 =================
        System.out.println("\nUC2 - Add Passenger Bogies to Train");
        System.out.println("===================================");

// Create ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

// Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

// Display after adding
        System.out.println("\nAfter Adding Bogies:");
        System.out.println("Passenger Bogies: " + passengerBogies);

// Remove "AC Chair"
        passengerBogies.remove("AC Chair");

// Display after removal
        System.out.println("\nAfter Removing 'AC Chair':");
        System.out.println("Passenger Bogies: " + passengerBogies);

// Check if "Sleeper" exists
        System.out.println("\nChecking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + passengerBogies.contains("Sleeper"));

// Final state
        System.out.println("\nFinal Train Passenger Consist:");
        System.out.println(passengerBogies);

        System.out.println("\nUC2 operations completed successfully...");

        // ================= UC3 =================
        System.out.println("\nUC3 - Track Unique Bogie IDs");
        System.out.println("===================================");

// Create HashSet for unique bogie IDs
        java.util.Set<String> bogieIds = new java.util.HashSet<>();

// Add bogie IDs (with duplicates intentionally)
        bogieIds.add("BG104");
        bogieIds.add("BG103");
        bogieIds.add("BG102");
        bogieIds.add("BG101");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

// Display result
        System.out.println("\nBogie IDs After Insertion:");
        System.out.println(bogieIds);

// Note about duplicates
        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");

        System.out.println("\nUC3 uniqueness validation completed...");
    }
}