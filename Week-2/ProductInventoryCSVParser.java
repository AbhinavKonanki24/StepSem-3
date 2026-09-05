public class ProductInventoryCSVParser {
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }
        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3 || fields[0].trim().isEmpty()
                || fields[1].trim().isEmpty() || fields[2].trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Product: " + fields[0]
                + " | SKU: " + fields[1]
                + " | Qty: " + fields[2]);
    }
    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");
    }
}
