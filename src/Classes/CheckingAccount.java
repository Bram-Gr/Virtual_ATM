package Classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CheckingAccount extends Account {
    public void transfer(String userInput, SavingsAccount sav) {
        BigDecimal transferAmt = new BigDecimal(userInput);
        int compareVal = getBalance().compareTo(transferAmt);
        if (compareVal >= 0) {
            BigDecimal newBalance = getBalance().subtract(transferAmt);
            setBalance(newBalance);
            sav.deposit(userInput);
            System.out.println("Transfer Amount: $" + transferAmt +
                    "\nChecking Balance: $" + newBalance +
                    "\nSavings Balance: $" + sav.getBalance());
        } else {
            System.out.println("Insufficient funds for transaction");
        }
    }

}
