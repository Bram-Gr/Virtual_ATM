package Classes;

import Interfaces.Printable;

import java.util.Scanner;

public class MenuTester {

    Printable printer;
    Scanner scanner;

    public MenuTester(Printable printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }


    public void MainWithDrawMethod() {
        int userSelectionValue = 0;
        do {
            DisplayMainPrompt();
            String userInput = scanner.nextLine();

            try {
                userSelectionValue = Integer.parseInt(userInput);
            } catch (Exception e) {
                printer.println("Invalid Selection");
            }
            if (userSelectionValue == 1) {
                CheckingWithdrawMethod();
            } else if (userSelectionValue == 2) {
                SavingsWithdrawMethod();
            }
        } while (userSelectionValue != 3);
    }


    public void CheckingWithdrawMethod() {
        int userSelectionValue = 0;
        do {
            printer.println("Withdraw from Checking:");
            printer.println("How much?");
            String userInput = scanner.nextLine();
            try {
                userSelectionValue = Integer.parseInt(userInput);
            } catch (Exception e) {
                printer.println("Invalid Selection");
            }

            if (userSelectionValue == 1) {
                printer.println("Your withdraw amount.");
            }

        } while (userSelectionValue != 3);
    }

    public void SavingsWithdrawMethod() {
        printer.println("This is the savings account");
    }

    public void DisplayMainPrompt() {
        printer.println("Withdraw Menu");
        printer.println("Select from the following: ");
        printer.println("1) Checking");
        printer.println("2) Savings");
        printer.println("3) Exit Menu");
        printer.println("-------------------------");

    }
}
