import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class CustomerBill {
    protected final double amount;

    public CustomerBill(double amount) {
        this.amount = amount;
    }

    public abstract String getCustomerType();
    public abstract double calculateFinalAmount();
}

class StudentBill extends CustomerBill {
    public StudentBill(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "STUDENT";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }
}

class StaffBill extends CustomerBill {
    public StaffBill(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "STAFF";
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95; // 5% discount
    }
}

class GuestBill extends CustomerBill {
    public GuestBill(double amount) {
        super(amount);
    }

    @Override
    public String getCustomerType() {
        return "GUEST";
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0; // ₹10 service charge
    }
}

public class CanteenBillingCounter {
    public static CustomerBill createBill(String type, double amount) {
        switch (type.toUpperCase()) {
            case "STUDENT":
                return new StudentBill(amount);
            case "STAFF":
                return new StaffBill(amount);
            case "GUEST":
                return new GuestBill(amount);
            default:
                throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void processBills(List<CustomerBill> bills) {
        double grandTotal = 0.0;
        for (CustomerBill bill : bills) {
            double finalAmount = bill.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", bill.getCustomerType(), finalAmount);
            grandTotal += finalAmount;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<CustomerBill> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            bills.add(createBill(type, amount));
        }

        processBills(bills);
    }
}
