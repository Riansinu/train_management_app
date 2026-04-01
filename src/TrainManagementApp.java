import java.util.*;

public class TrainManagementApp {

    // ===== UC14 Custom Exception =====
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ===== UC7 + UC14 Bogie Class =====
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    // ===== UC12 Goods Bogie =====
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " (" + cargo + ")";
        }
    }

    public static void main(String[] args) {

        // ================= UC1 =================
        System.out.println("=====================================");
        System.out.println("   Train Consist Management App");
        System.out.println("=====================================\n");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized...");
        System.out.println("Initial bogies: " + trainConsist);

        // ================= UC2 =================
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        passengerBogies.remove("AC Chair");
        System.out.println("\nUC2 Passenger Bogies: " + passengerBogies);

        // ================= UC3 =================
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG101");
        System.out.println("\nUC3 Unique Bogies: " + bogieIds);

        // ================= UC4 =================
        LinkedList<String> train = new LinkedList<>();
        train.add("Engine");
        train.add("Sleeper");
        train.add("Cargo");
        train.add(1, "Pantry");
        train.removeFirst();
        train.removeLast();
        System.out.println("\nUC4 Train: " + train);

        // ================= UC5 =================
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Sleeper");
        System.out.println("\nUC5 Formation: " + formation);

        // ================= UC6 =================
        HashMap<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);
        System.out.println("\nUC6 Capacity Map: " + capacityMap);

        // ================= UC7 =================
        List<Bogie> bogieList = new ArrayList<>();
        try {
            bogieList.add(new Bogie("Sleeper", 72));
            bogieList.add(new Bogie("AC Chair", 56));
            bogieList.add(new Bogie("First Class", 24));
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        bogieList.sort(Comparator.comparingInt(b -> b.capacity));
        System.out.println("\nUC7 Sorted Bogies: " + bogieList);

        // ================= UC8 =================
        List<Bogie> filtered = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .toList();
        System.out.println("\nUC8 Filtered: " + filtered);

        // ================= UC9 =================
        Map<String, List<Bogie>> grouped = bogieList.stream()
                .collect(java.util.stream.Collectors.groupingBy(b -> b.name));
        System.out.println("\nUC9 Grouped: " + grouped);

        // ================= UC10 =================
        int total = bogieList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        System.out.println("\nUC10 Total Seats: " + total);

        // ================= UC11 =================
        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        boolean validTrain = trainId.matches("TRN-\\d{4}");
        boolean validCargo = cargoCode.matches("PET-[A-Z]{2}");

        System.out.println("\nUC11 Train ID Valid: " + validTrain);
        System.out.println("UC11 Cargo Valid: " + validCargo);

        // ================= UC12 =================
        List<GoodsBogie> goods = new ArrayList<>();
        goods.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goods.add(new GoodsBogie("Open", "Coal"));

        boolean safe = goods.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("\nUC12 Safety: " + (safe ? "SAFE" : "UNSAFE"));

        // ================= UC13 =================
        List<Bogie> largeList = new ArrayList<>();
        try {
            for (int i = 0; i < 10000; i++) {
                largeList.add(new Bogie("Sleeper", 72));
                largeList.add(new Bogie("AC Chair", 56));
            }
        } catch (InvalidCapacityException e) {
            System.out.println(e.getMessage());
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopRes = new ArrayList<>();
        for (Bogie b : largeList) {
            if (b.capacity > 60) loopRes.add(b);
        }
        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();
        List<Bogie> streamRes = largeList.stream()
                .filter(b -> b.capacity > 60)
                .toList();
        long endStream = System.nanoTime();

        System.out.println("\nUC13 Loop Time: " + (endLoop - startLoop));
        System.out.println("UC13 Stream Time: " + (endStream - startStream));

        // ================= UC14 =================
        try {
            Bogie b1 = new Bogie("Sleeper", 72);
            System.out.println("\nUC14 Valid: " + b1);

            Bogie b2 = new Bogie("AC", -5); // ❌
        } catch (InvalidCapacityException e) {
            System.out.println("UC14 Error: " + e.getMessage());
        }

        System.out.println("\n=== PROGRAM COMPLETED SUCCESSFULLY ===");
    }
}