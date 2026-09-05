import java.util.Random;

public class BMICalculator {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person\tHeight\tWeight\tBMI\tStatus");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf("%d\t%.2f\t%.1f\t%.2f\t%s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        int n = 10;

        double[] heights = new double[n];
        double[] weights = new double[n];

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            heights[i] = 1.5 + random.nextDouble() * 0.5;
            weights[i] = 50 + random.nextInt(51);
        }

        printWellnessReport(heights, weights);
    }
}