package src;

public class BankAccount {

    private double checkingBalance;
    private double savingsBalance;
    private long accountNumber;
    private static int numberOfAccounts;
    private static int totalBankBalance;

    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.accountNumber = BankAccount.getAccountNumber();

        numberOfAccounts++;
        totalBankBalance += checkingBalance + savingsBalance;
    }

    public BankAccount() {
        this.accountNumber = BankAccount.getAccountNumber();
        numberOfAccounts++;
    }

    private static long getAccountNumber() {
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public double deposit(double amountDeposited) {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Into which account would you like to deposit?\n\n For Savings, please type 'savings'. For checking, type 'checking'.");
        String userInput = System.console().readLine();

        while (userInput != null) {
            switch (userInput.toLowerCase()) {
                case "savings":
                    this.savingsBalance += amountDeposited;
                    totalBankBalance += amountDeposited;
                    System.out.println("You deposited " + amountDeposited + " into your savings account. Your current balance is:");
                    return this.savingsBalance;

                case "checking":
                    this.checkingBalance += amountDeposited;
                    totalBankBalance += amountDeposited;
                    System.out.println("You deposited " + amountDeposited + " into your checking account. Your current balance is:");
                    return this.checkingBalance;

                default:
                    System.out.println("Invalid input! Please enter either 'savings' or 'checking'.");
                    userInput = System.console().readLine();
                    break;
            }
        }

        System.out.println("You have cancelled this transaction. Your current checking balance is:");
        System.out.println(this.checkingBalance);
        System.out.println("Your current savings balance is: " + this.savingsBalance);
        return this.savingsBalance;
    }

    public double withdraw(double amountWithdrawn) {
        System.out.println("Account Number: " + this.accountNumber);
        if(amountWithdrawn > this.checkingBalance) {
            System.out.println("Insufficient funds! Your current balance is: " + this.checkingBalance);
            return this.checkingBalance;
        }
        this.checkingBalance -= amountWithdrawn;
        System.out.println("Success! You have withdrawn " + amountWithdrawn + " and your current balance is: " + this.checkingBalance);
        return this.checkingBalance;
    }

    public double displayTotals() {
        double total = this.savingsBalance + this.checkingBalance;

        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Checking: " + this.checkingBalance);
        System.out.println("Savings: " + this.savingsBalance + "\n");
        System.out.println("Your total balance is: " + total);
        return this.checkingBalance + this.savingsBalance;
    }


}