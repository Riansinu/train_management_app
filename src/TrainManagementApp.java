import java.util.Arrays;

public class TrainManagementApp {

    public static void main(String[] args) {

        System.out.println("UC17 - Sort Bogie Names using Arrays.sort()");
        System.out.println("===================================");

        // Bogie type names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Pantry"};

        System.out.println("\nBefore Sorting:");
        System.out.println(Arrays.toString(bogieNames));

        // Built-in sorting
        Arrays.sort(bogieNames);

        System.out.println("\nAfter Sorting (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nSorting completed successfully...");
    }
}