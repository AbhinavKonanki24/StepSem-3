import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class HostelRoom {
    protected final int units;

    public HostelRoom(int units) {
        this.units = units;
    }

    public abstract String getRoomType();
    public abstract double calculateBill();
}

class SingleRoom extends HostelRoom {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public String getRoomType() {
        return "SINGLE";
    }

    @Override
    public double calculateBill() {
        return units * 8.0; // ₹8 per unit
    }
}

class SharedRoom extends HostelRoom {
    private final int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public String getRoomType() {
        return "SHARED";
    }

    @Override
    public double calculateBill() {
        if (occupants <= 0) {
            return 0.0;
        }
        return (units * 6.0) / occupants; // ₹6 per unit divided equally
    }
}

class AcRoom extends HostelRoom {
    public AcRoom(int units) {
        super(units);
    }

    @Override
    public String getRoomType() {
        return "AC";
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0; // ₹10 per unit + ₹200 fixed charge
    }
}

public class HostelElectricityBill {
    public static void processRooms(List<HostelRoom> rooms) {
        double grandTotal = 0.0;
        for (HostelRoom room : rooms) {
            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", room.getRoomType(), bill);
            grandTotal += bill;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<HostelRoom> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            if (type.equalsIgnoreCase("SHARED")) {
                int occupants = scanner.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if (type.equalsIgnoreCase("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else if (type.equalsIgnoreCase("AC")) {
                rooms.add(new AcRoom(units));
            } else {
                throw new IllegalArgumentException("Unknown room type: " + type);
            }
        }

        processRooms(rooms);
    }
}
