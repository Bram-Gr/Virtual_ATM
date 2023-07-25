package OGATM;

import OGATM.OGAccount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OGChecking extends OGAccount {

    private BigDecimal checkingBalance = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);
    private BigDecimal withdrawalAmt = new BigDecimal(0);
    private BigDecimal transferAmt = new BigDecimal(0);

    public BigDecimal getCheckingBalance(){
        return checkingBalance;
    }
    public BigDecimal getWithdrawalAmt() {
        return withdrawalAmt.setScale(2, RoundingMode.HALF_UP);
    }
    public BigDecimal getTransferAmt() {
        return transferAmt;
    }
    @Override
    public void deposit(String userInput) { //TODO unit tests for deposit method both checking/saving
        BigDecimal depositAmt = new BigDecimal(userInput);
        checkingBalance = checkingBalance.add(depositAmt).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public void withdrawal(String amount) { //TODO unit tests for withdrawal method both checking/saving
        withdrawalAmt = new BigDecimal(amount);
        int compareVal = checkingBalance.compareTo(withdrawalAmt);
        if (compareVal >= 0) {
            checkingBalance = checkingBalance.subtract(withdrawalAmt).setScale(2, RoundingMode.HALF_UP);
            System.out.println("You have received: $" + getWithdrawalAmt());
        } else {
            System.out.println("insufficient funds for transaction");
        }
    }


    public void transfer(String userInput, OGSavings sav) { //TODO unit tests for transfer method both checking and saving
        transferAmt = new BigDecimal(userInput);
        int compareVal = checkingBalance.compareTo(transferAmt);
        if (compareVal >= 0){
            checkingBalance = checkingBalance.subtract(transferAmt).setScale(2, RoundingMode.HALF_UP);
            sav.deposit(userInput);
            System.out.println("Transfer Amount: $" + getTransferAmt() + "\nChecking Balance: $" + getCheckingBalance()
                    + "\nSavings Balance: $" + sav.getSavingsBalance());
        } else {
            System.out.println("insufficient funds for transaction");
        }
    }

}
