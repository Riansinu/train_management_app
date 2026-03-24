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

        // ================= UC4 =================
        System.out.println("\nUC4 - Maintain Ordered Bogie Consist");
        System.out.println("===================================");

// Create LinkedList for train consist
        java.util.LinkedList<String> train = new java.util.LinkedList<>();

// Add initial bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

// Display initial state
        System.out.println("\nInitial Train Consist:");
        System.out.println(train);

// Insert "Pantry Car" at position 2 (index 2)
        train.add(2, "Pantry Car");

// After insertion
        System.out.println("\nAfter Inserting 'Pantry Car' at position 2:");
        System.out.println(train);

// Remove first and last bogie
        train.removeFirst();
        train.removeLast();

// Final state
        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(train);

        System.out.println("\nUC4 ordered consist operations completed...");

        // ================= UC5 =================
        System.out.println("\nUC5 - Preserve Insertion Order of Bogies");
        System.out.println("===================================");

// Create LinkedHashSet
        java.util.LinkedHashSet<String> formation = new java.util.LinkedHashSet<>();

// Add bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

// Add duplicate intentionally
        formation.add("Sleeper"); // duplicate (ignored)

// Display final formation
        System.out.println("\nFinal Train Formation:");
        System.out.println(formation);

// Note
        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("\nUC5 formation setup completed...");

        // ================= UC6 =================
        System.out.println("\nUC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("===================================");

// Create HashMap for bogie → capacity
        java.util.HashMap<String, Integer> bogieCapacity = new java.util.HashMap<>();

// Insert data
        bogieCapacity.put("First Class", 24);
        bogieCapacity.put("Cargo", 120);
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);

// Display details
        System.out.println("\nBogie Capacity Details:");

        for (java.util.Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}