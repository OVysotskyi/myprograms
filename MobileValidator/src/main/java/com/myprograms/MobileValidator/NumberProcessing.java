package com.myprograms.MobileValidator;

import java.util.Arrays;

public class NumberProcessing {

    NumberProcessing() {
        createFullCode();
    }

    private String[] code = {"063", "066", "067", "068", "070", "073", "090", "094", "093", "095", "096", "097", "098", "099"};
    private String[] fullCode = new String[code.length];

    private void createFullCode() {
        for (int i = 0; i < code.length; i++) {
            fullCode[i] = "38" + code[i];
        }
    }

    private int sumArray(int[] array) {
        int sum = 0;

        for (int anArray : array) sum = sum + anArray;
        return sum;
    }

    private int[] stringToArray(String phoneNumber) {
        int[] array = new int[phoneNumber.length()];

        for (int i = 0; i < phoneNumber.length(); i++) {
            array[i] = Integer.parseInt(String.valueOf(phoneNumber.charAt(i)));
        }
        return array;
    }

    public boolean validator(String phoneNumber) {
        return ((Arrays.asList(fullCode).contains(phoneNumber.substring(0, 5)) || Arrays.asList(code).contains(phoneNumber.substring(0, 3)))
                    && (phoneNumber.length() == 10 || phoneNumber.length() == 12));
    }

    public void printToScreen(String phoneNumber) {
        int count = 1;
        int[] result = stringToArray(phoneNumber);

        if (!validator(phoneNumber)) {
            System.out.println("Phone number is incorrect. Please enter the phone number:");
        } else
            System.out.println("Phone number is correct.");

        while (String.valueOf(sumArray(result)).length() >= 1 && validator(phoneNumber)) {
            System.out.println(count + "st round of calculation, sum is: " + sumArray(result));
            if (String.valueOf(sumArray(result)).length() == 1) {
                int sum = sumArray(result);
                String name;

                switch (sum) {
                    case 1:
                        name = "One";
                        break;
                    case 2:
                        name = "Two";
                        break;
                    case 3:
                        name = "Tree";
                        break;
                    case 4:
                        name = "Four";
                        break;
                    default:
                        name = String.valueOf(sumArray(result));
                        break;
                }
                System.out.println("Final result is: " + name);
                break;
            }
            result = stringToArray(String.valueOf(sumArray(result)));
            count++;
        }
    }
}