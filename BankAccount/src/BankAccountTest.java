package src;

public class BankAccountTest {

public static void main(String[]args){

        BankAccount bankAccount1 = new BankAccount();
        BankAccount bankAccount2 = new BankAccount(1250.00, 5550.25);

        bankAccount2.deposit(150.25);
        bankAccount1.deposit(150.25);

        bankAccount1.withdraw(160.00);
        bankAccount2.withdraw(160.00);

        bankAccount1.getCheckingBalance();
        bankAccount2.getSavingsBalance();



        bankAccount2.displayTotals();
        bankAccount1.displayTotals();
        }
}