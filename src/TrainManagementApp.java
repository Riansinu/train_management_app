class TrainManagementApp {

    public static void main(String[] args) {

        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("===================================");

        // Unsorted bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String target = "BG309";  // change this to test

        System.out.println("\nSearching for: " + target);

        boolean found = false;

        // Linear Search
        for (String id : bogieIds) {
            if (id.equals(target)) {
                found = true;
                break; // early termination
            }
        }

        // Result
        if (found) {
            System.out.println("Bogie found: " + target);
        } else {
            System.out.println("Bogie not found: " + target);
        }

        System.out.println("\nLinear Search completed successfully...");
    }
}