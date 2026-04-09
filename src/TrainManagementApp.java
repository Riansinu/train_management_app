public class TrainManagementApp {

    // ===== Custom Runtime Exception =====
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // ===== Goods Bogie Class =====
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        void assignCargo(String cargo) {
            try {
                // Unsafe condition
                if (this.type.equals("Rectangular") && cargo.equals("Petroleum")) {
                    throw new CargoSafetyException("Unsafe: Cannot assign Petroleum to Rectangular bogie");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully: " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Assignment attempt completed.\n");
            }
        }

        @Override
        public String toString() {
            return type + " (" + cargo + ")";
        }
    }

    public static void main(String[] args) {

        System.out.println("UC15 - Safe Cargo Assignment Using try-catch-finally");
        System.out.println("===================================");

        GoodsBogie g1 = new GoodsBogie("Cylindrical", null);
        GoodsBogie g2 = new GoodsBogie("Rectangular", null);

        // Safe case
        g1.assignCargo("Petroleum");

        // Unsafe case
        g2.assignCargo("Petroleum");

        // Program continues
        g2.assignCargo("Coal");

        System.out.println("Program continues after handling exceptions...");
    }
}