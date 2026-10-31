import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class TransportJourney {
    protected final double distance;

    public TransportJourney(double distance) {
        this.distance = distance;
    }

    public abstract String getTransportType();
    public abstract double calculateFare();
}

class BusJourney extends TransportJourney {
    public BusJourney(double distance) {
        super(distance);
    }

    @Override
    public String getTransportType() {
        return "BUS";
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(10.0, fare); // Maximum fare of $10
    }
}

class TrainJourney extends TransportJourney {
    public TrainJourney(double distance) {
        super(distance);
    }

    @Override
    public String getTransportType() {
        return "TRAIN";
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
}

class MetroJourney extends TransportJourney {
    private final double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public String getTransportType() {
        return "METRO";
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class PublicTransportFareCalculator {
    public static void processJourneys(List<TransportJourney> journeys) {
        double grandTotal = 0.0;
        for (TransportJourney journey : journeys) {
            double fare = journey.calculateFare();
            System.out.printf("%s: %.2f%n", journey.getTransportType(), fare);
            grandTotal += fare;
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int n = scanner.nextInt();
        List<TransportJourney> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            if (type.equalsIgnoreCase("METRO")) {
                double peakHourFactor = scanner.nextDouble();
                journeys.add(new MetroJourney(distance, peakHourFactor));
            } else if (type.equalsIgnoreCase("BUS")) {
                journeys.add(new BusJourney(distance));
            } else if (type.equalsIgnoreCase("TRAIN")) {
                journeys.add(new TrainJourney(distance));
            } else {
                throw new IllegalArgumentException("Unknown transport type: " + type);
            }
        }

        processJourneys(journeys);
    }
}
