
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Financial Forecasting Tool (Recursion) ===\n");

        double pastValue = 100000.0; // Baseline asset value (₹1,000,000)
        double annualGrowthRate = 0.10; // 10% annual growth
        int forecastPeriodYears = 5;

        System.out.println("Initial Past Value: ₹" + pastValue);
        System.out.println("Assumed Growth Rate: " + (annualGrowthRate * 100) + "% per year");
        System.out.println("Forecasting Window: " + forecastPeriodYears + " years\n");

        // Execute recursive calculation
        double predictedFutureValue = FinancialForecasting.calculateFutureValue(pastValue, annualGrowthRate, forecastPeriodYears);

        // Format and print the result
        System.out.printf("Predicted Future Value: ₹%.2f%n", predictedFutureValue);
    }
}