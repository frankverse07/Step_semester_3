package core_java.assigment_problems;

public class WarehouseInventoryBalancer {

    /**
     * Compares section totals and finds the highest-quantity item across both sections.
     *
     * @param sectionA array of item quantities in Section A
     * @param sectionB array of item quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            System.out.println("Invalid section data.");
            return;
        }

        int totalA = 0;
        int totalB = 0;

        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "";
        int highestItemIndex = -1;

        // Sum Section A and find max
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemIndex = i + 1; // 1-based index (Item 1, Item 2...)
            }
        }

        // Sum Section B and compare with max
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, highestQuantity, highestSection, highestItemIndex);
    }

    public static void main(String[] args) {
        System.out.println("=== Warehouse Inventory Balancer ===\n");

        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        System.out.println("Test Case 1:");
        analyzeInventory(sectionA, sectionB);

        int[] sectionA2 = {10, 20, 30};
        int[] sectionB2 = {15, 25, 35};
        System.out.println("\nTest Case 2 (Unbalanced):");
        analyzeInventory(sectionA2, sectionB2);
    }
}
