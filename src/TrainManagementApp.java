class TrainManageApp  {

    public static void main(String[] args) {

        System.out.println("UC20 - Exception Handling During Search Operations");
        System.out.println("===================================");

        // Case 1: Empty bogie list
        String[] bogieIds = {};   // try changing to {"BG101", "BG205"}

        String target = "BG101";

        try {
            // Fail-fast validation
            if (bogieIds.length == 0) {
                throw new IllegalStateException("No bogies available in the train. Cannot perform search.");
            }

            // Linear search (after validation)
            boolean found = false;

            for (String id : bogieIds) {
                if (id.equals(target)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("Bogie found: " + target);
            } else {
                System.out.println("Bogie not found: " + target);
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nProgram continues safely...");
    }
}