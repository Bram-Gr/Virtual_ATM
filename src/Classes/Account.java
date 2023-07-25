package Classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account {
    private BigDecimal balance = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_UP);
    private BigDecimal withdrawalAmt = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);;
    private BigDecimal transferAmt = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);;

    public BigDecimal getBalance(){
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getWithdrawalAmt() {
        return withdrawalAmt;
    }

    public BigDecimal getTransferAmt() {
        return transferAmt;
    }


    public void deposit(String userInput) {
        BigDecimal depositAmt = new BigDecimal(userInput);
        this.balance = this.balance.add(depositAmt);
    }

    public void withdrawal(String userInput){
        BigDecimal withdrawalAmt = new BigDecimal(userInput);
        int compareVal = this.balance.compareTo(withdrawalAmt);
        if (compareVal >= 0) {
        this.balance = this.balance.subtract(withdrawalAmt);
        System.out.println("You have received: $" + withdrawalAmt);
        } else {
            System.out.println("insufficient funds for transaction");
        }
    }


    //TODO make account a Dao to connect accounts to a database, nest create pin and check pin in this class
    //TODO make integration test once account database is created
}
