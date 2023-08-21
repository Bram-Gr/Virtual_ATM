package Classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account {
    private BigDecimal balance = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_UP);
    private BigDecimal withdrawalAmt = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);;
    private BigDecimal transferAmt = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);;
    private BigDecimal value10 = new BigDecimal("10");
    private BigDecimal value20 = new BigDecimal("20");
    private BigDecimal value50 = new BigDecimal("50");
    private BigDecimal value100 = new BigDecimal("100");

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
        if((depositAmt.remainder(value10).equals(BigDecimal.ZERO)) || (depositAmt.remainder(value20).equals(BigDecimal.ZERO))||
        (depositAmt.remainder(value50).equals(BigDecimal.ZERO))  || (depositAmt.remainder(value100).equals(BigDecimal.ZERO))) {
            this.balance = this.balance.add(depositAmt);
            System.out.println("Your updated account balance is $" + this.balance);
        }else{
            System.out.println("Please enter 10's, 20's, 50's, 100's");
        }
    }

    public void withdrawal(String userInput){
        BigDecimal withdrawalAmt = new BigDecimal(userInput);
        int compareVal = this.balance.compareTo(withdrawalAmt);
        if (compareVal <= 0){
            System.out.println("insufficient funds for transaction");
        }
        else if (((withdrawalAmt.remainder(value10).equals(BigDecimal.ZERO)) || (withdrawalAmt.remainder(value20).equals(BigDecimal.ZERO))||
                (withdrawalAmt.remainder(value50).equals(BigDecimal.ZERO))  || (withdrawalAmt.remainder(value100).equals(BigDecimal.ZERO)))) {
        this.balance = this.balance.subtract(withdrawalAmt);
        System.out.println("You have received: $" + withdrawalAmt);
        }
        else {
            System.out.println("Please enter 10's, 20's, 50's, 100's");
        }
    }



    //TODO make integration tests. For happy, sad, and edge cases on math methods.
    //TODO create logger class to write new pin information
    //TODO create User class to loop through logger and set mapped values of input/balances
}
