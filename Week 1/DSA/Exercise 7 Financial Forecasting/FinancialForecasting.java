public class FinancialForecasting {

    public static double calculateFutureValue(double currentAmount, double growthRate, int years) {
     
        if (years <= 0) {
            return currentAmount;
        }

        double nextYearAmount = currentAmount * (1 + growthRate);
        return calculateFutureValue(nextYearAmount, growthRate, years - 1);
    }
}
