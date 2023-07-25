package Classes;

import java.math.BigDecimal;

public class SavingsAccount extends Account {

        public void transfer(String userInput, CheckingAccount ch) {
            BigDecimal transferAmt = new BigDecimal(userInput);
            int compareVal = getBalance().compareTo(transferAmt);
            if (compareVal >= 0) {
                BigDecimal newBalance = getBalance().subtract(transferAmt);
                setBalance(newBalance);
                ch.deposit(userInput);
                System.out.println("Transfer Amount: $" + transferAmt +
                        "\nChecking Balance: $" + ch.getBalance() +
                        "\nSavings Balance: $" + newBalance);
            } else {
                System.out.println("Insufficient funds for transaction");
            }
        }

}
