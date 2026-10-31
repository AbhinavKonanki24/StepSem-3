import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class PaymentMethod {
    protected final double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract String getPaymentType();
    public abstract double calculateAdjustedAmount();
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.02; // 2% processing fee
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.01; // 1% processing fee
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public String getPaymentType() {
        return "BANKTRANSFER";
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount; // No fee
    }
}

public class PaymentSystemFeeCalculation {
    public static PaymentMethod createPayment(String type, double amount) {
        switch (type.toUpperCase()) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            case "BANKTRANSFER":
                return new BankTransferPayment(amount);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void processPayments(List<PaymentMethod> payments) {
        double grandTotal = 0.0;
        for (PaymentMethod payment : payments) {
            double adjustedAmount = payment.calculateAdjustedAmount();
            System.out.printf("%s: %.2f%n", payment.getPaymentType(), adjustedAmount);
            grandTotal += adjustedAmount;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<PaymentMethod> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            payments.add(createPayment(type, amount));
        }

        processPayments(payments);
    }
}
