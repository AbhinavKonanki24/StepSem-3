public class WarehouseInventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null
                || sectionA.length != sectionB.length || sectionA.length == 0) {
            System.out.println("Invalid inventory data");
            return;
        }
        int totalA = 0;
        int totalB = 0;
        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "";
        int highestIndex = -1;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i + 1;
            }
        }
        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + highestQuantity
                + " (" + highestSection + ", Item " + highestIndex + ")");
    }
    public static void main(String[] args) {
        analyzeInventory(new int[] {20, 15, 30}, new int[] {25, 10, 30});
    }
}
