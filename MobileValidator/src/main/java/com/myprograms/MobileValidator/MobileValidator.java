package com.myprograms.MobileValidator;

import java.util.Scanner;

public class MobileValidator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean check;
        String scannerNumber;
        String phoneNumber;
        NumberProcessing np = new NumberProcessing();

        do {
            check = false;
            scannerNumber = in.nextLine();
            phoneNumber = scannerNumber.replaceAll("\\W", "");
            try {
                np.validator(phoneNumber);
                np.printToScreen(phoneNumber);
            } catch (NumberFormatException e) {
                check = true;
                System.out.println("Phone number is incorrect. Please enter the phone number:");
            }
        }

        while (check || !np.validator(phoneNumber));
    }
}