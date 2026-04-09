class TrainManageApp {

    public static void main(String[] args) {

        System.out.println("UC16 - Sort Passenger Bogies using Bubble Sort");
        System.out.println("===================================");

        // Passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("\nBefore Sorting:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        // Bubble Sort Algorithm
        for (int i = 0; i < capacities.length - 1; i++) {
            for (int j = 0; j < capacities.length - i - 1; j++) {

                if (capacities[j] > capacities[j + 1]) {
                    // Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        System.out.println("\n\nAfter Sorting (Ascending):");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nBubble Sort completed successfully...");
    }
}