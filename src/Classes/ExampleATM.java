package Classes;

import Interfaces.Printable;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExampleATM {

    private static final String BANNER = "\n=============================================";
    private static final String CHECK_BAL_OPTION_CHECKING = "Checking  "; //added space for unique labels in switch case/ probably a better way to
    // do this but it functions currently
    private static final String CHECK_BAL_OPTION_SAVINGS = "Savings  ";
    private static final String MAKE_DEPOSIT_OPTION_CHECKING = "Checking";
    private static final String MAKE_DEPOSIT_OPTION_SAVINGS = "Savings";
    private static final String MAKE_WITHDRAWAL_MENU_OPTION_CHECKING = "Checking ";
    private static final String MAKE_WITHDRAWAL_OPTION_SAVINGS = "Savings ";
    private static final String MAKE_TRANSFER_MENU_OPTION_CHECKING = "Checking    ";
    private static final String MAKE_TRANSFER_OPTION_SAVINGS = "Savings    ";
    private static final String START_MENU_OPTION_ENTER_PIN = "Enter Pin";
    private static final String START_MENU_OPTION_CREATE_ACCOUNT = "Create Account";
    private static final String EXIT_OPTION = "Exit";
    private static final String[] START_MENU_OPTIONS = {START_MENU_OPTION_ENTER_PIN, START_MENU_OPTION_CREATE_ACCOUNT, EXIT_OPTION};
    private static final String[] MAIN_MENU_OPTION_CHECK_BAL = {CHECK_BAL_OPTION_CHECKING, CHECK_BAL_OPTION_SAVINGS};
    private static final String MAIN_MENU_OPTION_CHECK_BAL_ = "Check bal";
    private static final String[] MAIN_MENU_OPTION_MAKE_DEPOSIT = {MAKE_DEPOSIT_OPTION_CHECKING, MAKE_DEPOSIT_OPTION_SAVINGS};
    private static final String MAIN_MENU_OPTION_MAKE_DEPOSIT_ = "Make deposit";
    private static final String[] MAIN_MENU_OPTION_MAKE_WITHDRAWAL = {MAKE_WITHDRAWAL_MENU_OPTION_CHECKING, MAKE_WITHDRAWAL_OPTION_SAVINGS};
    private static final String MAIN_MENU_OPTION_MAKE_WITHDRAWAL_ = "Make Withdrawal";
    private static final String[] MAIN_MENU_OPTION_MAKE_TRANSFER = {MAKE_TRANSFER_MENU_OPTION_CHECKING, MAKE_TRANSFER_OPTION_SAVINGS};
    private static final String MAIN_MENU_OPTION_MAKE_TRANSFER_ = "Make Transfer";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_CHECK_BAL_, MAIN_MENU_OPTION_MAKE_DEPOSIT_,
            MAIN_MENU_OPTION_MAKE_WITHDRAWAL_, MAIN_MENU_OPTION_MAKE_TRANSFER_, EXIT_OPTION};

    Scanner userInput = new Scanner(System.in);
    Printable printer = new PrinterCL();

    MenuTester withdrawMenu = new MenuTester(printer, userInput);
    CheckingAccount ch = new CheckingAccount();

    SavingsAccount sav = new SavingsAccount();

    Account acct = new Account();

    public void run() {
        printer.println(BANNER);
        printer.println("\n\t\tWELCOME TO COMMAND LINE ATM");
        boolean runMenu = true;
        String[] activeMenu = START_MENU_OPTIONS;

        while (runMenu) {
            displayMenuOptions(activeMenu);
            String userSelection = userInput.nextLine();
            try {
                int userSelectionLocation = Integer.parseInt(userSelection) - 1;
                String menuSelection = activeMenu[userSelectionLocation];
                printer.println("You Have Selected: " + menuSelection);
                switch (menuSelection) {
                    case START_MENU_OPTION_CREATE_ACCOUNT:
                        printer.println("Enter a unique four digit pin to create your account");
                        String createPin = userInput.nextLine();
                        if (createPin.length() == 4 && createPin.matches("\\d+")) {
                            printer.println("Account Created");
                            activeMenu = MAIN_MENU_OPTIONS;
                        } else {
                            printer.println("Please enter valid selection");
                            activeMenu = START_MENU_OPTIONS;
                        }
                        break;
                    case START_MENU_OPTION_ENTER_PIN:
                        printer.println("Enter pin:");
                        String enterPin = userInput.nextLine();
                        if (enterPin.length() == 4 && enterPin.matches("\\d+")) {
                            printer.println("Valid pin entered");
                            activeMenu = MAIN_MENU_OPTIONS;
                        } else {
                            printer.println("\nplease enter a valid pin or create a new account");
                            activeMenu = START_MENU_OPTIONS;
                        }
                        break;
                    case MAIN_MENU_OPTION_CHECK_BAL_:
                        activeMenu = MAIN_MENU_OPTION_CHECK_BAL;
                        break;
                    case CHECK_BAL_OPTION_CHECKING:
                        printer.println("Your checking Account balance is: $" + ch.getCheckingBalance());
                        activeMenu = MAIN_MENU_OPTIONS;
                        break;
                    case CHECK_BAL_OPTION_SAVINGS:
                        printer.println("Your Savings Account balance is: $" + sav.getSavingsBalance());
                        activeMenu = MAIN_MENU_OPTIONS;
                        break;
                    case MAIN_MENU_OPTION_MAKE_DEPOSIT_:
                        activeMenu = MAIN_MENU_OPTION_MAKE_DEPOSIT;
                        break;
                    case MAKE_DEPOSIT_OPTION_CHECKING:
                        printer.println("Please enter a deposit amount:");
                        String inputChD = userInput.nextLine();
                        //ch.deposit(inputChD);
                        printer.println("Your updated Checking Account balance is $" + ch.getCheckingBalance());
                        activeMenu = MAIN_MENU_OPTIONS;
                        break;
                    case MAKE_DEPOSIT_OPTION_SAVINGS:
                        printer.println("Please enter a deposit amount:");
                        String inputSavD = userInput.nextLine();
                        //sav.deposit(inputSavD);
                        printer.println("Your updated Savings Account balance is $" + sav.getSavingsBalance());
                        activeMenu = MAIN_MENU_OPTIONS;
                        break;
                    case MAIN_MENU_OPTION_MAKE_WITHDRAWAL_:
                        activeMenu = MAIN_MENU_OPTION_MAKE_WITHDRAWAL;
                        break;
                    case MAKE_WITHDRAWAL_MENU_OPTION_CHECKING:
                        printer.println("Please enter withdrawal amount");
                        String inputChW = userInput.nextLine();
                        BigDecimal amount = new BigDecimal(inputChW);
                        ch.withdrawal(amount);
                        activeMenu = MAIN_MENU_OPTIONS;
                        break;
                    case MAKE_WITHDRAWAL_OPTION_SAVINGS:
                        printer.println("Please enter withdrawal amount");
                        String inputSavW = userInput.nextLine();
                        BigDecimal savW = new BigDecimal(inputSavW);
                        sav.withdrawal(savW);
                        activeMenu = MAIN_MENU_OPTIONS;
                        break;
                    case MAIN_MENU_OPTION_MAKE_TRANSFER_:
                        activeMenu = MAIN_MENU_OPTION_MAKE_TRANSFER;
                        break;
                    case MAKE_TRANSFER_MENU_OPTION_CHECKING:
                        printer.println("Please enter transfer amount");
                        String inputChT = userInput.nextLine();
                        //ch.transfer(inputChT, sav);
                        activeMenu = MAIN_MENU_OPTIONS;
                        break;
                    case  MAKE_TRANSFER_OPTION_SAVINGS:
                        printer.println("Please enter transfer amount");
                        String inputSavT = userInput.nextLine();
                        //sav.transfer(inputSavT, ch);
                        activeMenu = MAIN_MENU_OPTIONS;
                        break;
                    case EXIT_OPTION:
                        printer.println("Would you like a receipt?  Y/N");
                        userSelection = userInput.nextLine();
                        if (userSelection.equalsIgnoreCase("Y")){
//                            printReceipt();
                            printer.println("Thank you for using Command Line ATM");
                            runMenu = false;
                            break;
                        } else if (userSelection.equalsIgnoreCase("N")) {
                            printer.println("Thank you for using Command Line ATM");
                            runMenu = false;
                            break;
                        } else {
                            printer.println("Please enter \"Y\" for yes and \"N\" for no\nMake Selection" );
                            activeMenu = MAIN_MENU_OPTIONS;
                            break;
                        }


                }
            } catch (Exception e) {
                printer.println("Please enter a valid selection\t");
            }
        }

    }


    public void displayMenuOptions(String[] menu) {
        printer.println(BANNER);
        for (int i = 0; i < menu.length; i++) {
            printer.println("(" + (i + 1) + ") " + menu[i]);
        }
        printer.println(BANNER);
    }
//
//    public void  printReceipt(){
//        printer.println("Your Checking Account Balance is: $" + ch.getCheckingBalance()
//                + "\nYour Savings Account Balance is: $" + sav.getSavingsBalance() + "\n");
//    }
//}
