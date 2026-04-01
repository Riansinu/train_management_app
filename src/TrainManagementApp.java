import java.util.*;

public class TrainManagementApp {

    // ===== UC7: Bogie Class =====
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    public static void main(String[] args) {

        // ================= UC1 =================
        System.out.println("=====================================");
        System.out.println("   Train Consist Management App");
        System.out.println("=====================================\n");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Train initialized successfully...");
        System.out.println("Initial number of bogies: " + trainConsist.size());
        System.out.println("Current train consist: " + trainConsist);

        // ================= UC2 =================
        System.out.println("\nUC2 - Add Passenger Bogies to Train");
        System.out.println("===================================");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("\nAfter Adding Bogies:");
        System.out.println("Passenger Bogies: " + passengerBogies);

        passengerBogies.remove("AC Chair");

        System.out.println("\nAfter Removing 'AC Chair':");
        System.out.println("Passenger Bogies: " + passengerBogies);

        System.out.println("\nChecking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + passengerBogies.contains("Sleeper"));

        System.out.println("\nFinal Train Passenger Consist:");
        System.out.println(passengerBogies);

        // ================= UC3 =================
        System.out.println("\nUC3 - Track Unique Bogie IDs");
        System.out.println("===================================");

        Set<String> bogieIds = new HashSet<>();

        bogieIds.add("BG104");
        bogieIds.add("BG103");
        bogieIds.add("BG102");
        bogieIds.add("BG101");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("\nBogie IDs After Insertion:");
        System.out.println(bogieIds);

        System.out.println("\nNote: Duplicates are automatically ignored by HashSet.");

        // ================= UC4 =================
        System.out.println("\nUC4 - Maintain Ordered Bogie Consist");
        System.out.println("===================================");

        LinkedList<String> train = new LinkedList<>();

        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("\nInitial Train Consist:");
        System.out.println(train);

        train.add(2, "Pantry Car");

        System.out.println("\nAfter Inserting 'Pantry Car':");
        System.out.println(train);

        train.removeFirst();
        train.removeLast();

        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(train);

        // ================= UC5 =================
        System.out.println("\nUC5 - Preserve Insertion Order");
        System.out.println("===================================");

        LinkedHashSet<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate

        System.out.println("\nFinal Train Formation:");
        System.out.println(formation);

        System.out.println("\nNote: LinkedHashSet preserves order and removes duplicates.");

        // ================= UC6 =================
        System.out.println("\nUC6 - Map Bogie to Capacity");
        System.out.println("===================================");

        HashMap<String, Integer> bogieCapacity = new HashMap<>();

        bogieCapacity.put("First Class", 24);
        bogieCapacity.put("Cargo", 120);
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 56);

        System.out.println("\nBogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // ================= UC7 =================
        System.out.println("\nUC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("===================================");

        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));

        System.out.println("\nBefore Sorting:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        // Sorting using Comparator
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        System.out.println("\nUC7 completed successfully...");

        // ================= UC8 =================
        System.out.println("\nUC8 - Filter Passenger Bogies Using Streams");
        System.out.println("===================================");

// Reuse bogieList from UC7

// Filter bogies with capacity > 60
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .toList();

// Display filtered bogies
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        for (Bogie b : filteredBogies) {
            System.out.println(b);
        }

// Check original list unchanged
        System.out.println("\nOriginal Bogie List (Unchanged):");
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        System.out.println("\nUC8 filtering completed successfully...");

        // ================= UC9 =================
        System.out.println("\nUC9 - Group Bogies by Type (groupingBy)");
        System.out.println("===================================");

// Reuse bogieList from UC7

// Group bogies by name/type
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(java.util.stream.Collectors.groupingBy(b -> b.name));

// Display grouped bogies
        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC9 grouping completed successfully...");

        // ================= UC10 =================
        System.out.println("\nUC10 - Count Total Seats in Train (reduce)");
        System.out.println("===================================");

// Reuse bogieList from UC7

// Calculate total seating capacity
        int totalSeats = bogieList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

// Display result
        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);

        System.out.println("\nUC10 aggregation completed successfully...");
    }
}