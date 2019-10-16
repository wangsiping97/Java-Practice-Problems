package savingsaccount;

public class SavingsAccount {
    public static double annualInterestRate = 0.06;
    private double savingsBalance; // current savings
    SavingsAccount (double saving) {
        savingsBalance = saving;
    }
    public double calculateMonthlyInterest () {
        double monthlyInterest = savingsBalance * annualInterestRate / 12;
        savingsBalance += monthlyInterest;
        return monthlyInterest;
    }
    public void modifyInterestRate (double newInterest) {
        annualInterestRate = newInterest;
    }
}