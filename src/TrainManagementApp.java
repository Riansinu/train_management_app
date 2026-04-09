import java.util.Arrays;

public class TrainManagementApp  {

    public static void main(String[] args) {

        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("===================================");

        // Sorted bogie IDs (IMPORTANT for binary search)
        int[] bogieIds = {101, 102, 103, 104, 105, 106};

        int target = 104;

        System.out.println("\nBogie IDs: " + Arrays.toString(bogieIds));
        System.out.println("Searching for: " + target);

        // Binary Search Logic
        int left = 0;
        int right = bogieIds.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (bogieIds[mid] == target) {
                System.out.println("Bogie found at index: " + mid);
                found = true;
                break;
            } else if (bogieIds[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Bogie ID not found.");
        }

        System.out.println("\nBinary Search completed successfully...");
    }
}