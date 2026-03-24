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
    }
}