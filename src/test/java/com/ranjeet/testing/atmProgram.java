package com.ranjeet.testing;

import java.util.Scanner;

public class atmProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 1000; // initial balance

        while (true) {
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Enter a choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + balance);
                    break;
                case 2:
                    System.out.print("Enter an amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance");
                    } else {
                        balance -= withdrawAmount;
                        System.out.println("Withdrawal successful");
                    }
                    break;
                case 3:
                    System.out.print("Enter an amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    balance += depositAmount;
                    System.out.println("Deposit successful");
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}