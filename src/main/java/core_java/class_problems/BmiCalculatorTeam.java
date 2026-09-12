package core_java.class_problems;

public class BmiCalculatorTeam {

    /**
     * Classifies health status based on BMI value.
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Calculates BMI and prints the complete wellness report table.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        int n = Math.min(heights.length, weights.length);

        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);

            System.out.printf("%-10s | %-12.2f | %-12.2f | %-8.2f | %-12s%n",
                    "Person " + (i + 1), h, w, bmi, status);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Corporate Wellness Program - BMI Report ===\n");

        // Team of 10 people including sample test cases
        double[] heights = {1.75, 1.60, 1.80, 1.55, 1.70, 1.65, 1.85, 1.50, 1.72, 1.68};
        double[] weights = {70.0, 90.0, 65.0, 42.0, 80.0, 58.0, 95.0, 68.0, 74.0, 52.0};

        printWellnessReport(heights, weights);
    }
}
