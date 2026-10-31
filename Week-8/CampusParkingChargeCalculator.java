import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Vehicle {
    protected final int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract String getVehicleType();
    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "BIKE";
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0;
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "CAR";
    }

    @Override
    public double calculateCharge() {
        if (hours <= 0) {
            return 0.0;
        }
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public String getVehicleType() {
        return "TRUCK";
    }

    @Override
    public double calculateCharge() {
        double fee = hours * 50.0;
        return Math.max(100.0, fee); // Minimum ₹100
    }
}

public class CampusParkingChargeCalculator {
    public static Vehicle createVehicle(String type, int hours) {
        switch (type.toUpperCase()) {
            case "BIKE":
                return new Bike(hours);
            case "CAR":
                return new Car(hours);
            case "TRUCK":
                return new Truck(hours);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void processVehicles(List<Vehicle> vehicles) {
        double grandTotal = 0.0;
        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();
            System.out.printf("%s: %.2f%n", vehicle.getVehicleType(), charge);
            grandTotal += charge;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            vehicles.add(createVehicle(type, hours));
        }

        processVehicles(vehicles);
    }
}
