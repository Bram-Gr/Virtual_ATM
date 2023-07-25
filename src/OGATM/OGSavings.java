package OGATM;

import OGATM.OGAccount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OGSavings extends OGAccount {
    private BigDecimal savingsBalance = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
    private BigDecimal withdrawalAmt = new BigDecimal(0);
    private BigDecimal transferAmt = new BigDecimal(0);


    public BigDecimal getSavingsBalance(){
        return savingsBalance;
    }
    public BigDecimal getWithdrawalAmt() {
        return withdrawalAmt.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTransferAmt() {//TODO format transfer amount
        return transferAmt;
    }
    @Override
    public void deposit(String userInput) {
        BigDecimal depositAmt = new BigDecimal(userInput);
        savingsBalance = savingsBalance.add(depositAmt).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public void withdrawal(String amount) {
        withdrawalAmt = new BigDecimal(amount);
        int compareVal = savingsBalance.compareTo(withdrawalAmt);
        if (compareVal >= 0) {
            savingsBalance = savingsBalance.subtract(withdrawalAmt).setScale(2, RoundingMode.HALF_UP);
            System.out.println("You have received: $" + getWithdrawalAmt());
        } else {
            System.out.println("insufficient funds for transaction");
        }
    }


    public void transfer(String userInput, OGChecking ch) {
        transferAmt = new BigDecimal(userInput);
        int compareVal = savingsBalance.compareTo(transferAmt);
        if (compareVal >= 0){
            savingsBalance = savingsBalance.subtract(transferAmt).setScale(2, RoundingMode.HALF_UP);
            ch.deposit(userInput);
            System.out.println("Transfer Amount: $" + getTransferAmt() + "\nChecking Balance: $" + ch.getCheckingBalance()
                    + "\nSavings Balance: $" + getSavingsBalance());
        } else {
            System.out.println("insufficient funds for transaction");
        }
    }

}
