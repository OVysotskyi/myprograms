package com.myprograms.BankManagement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

abstract class Client {
    protected String name;
    protected String address;
    protected String regNumber;
    protected double cash;
    protected int days;
    protected double percent;

    public static ArrayList<PhysicalPerson> physicalPerson = new ArrayList<>();
    public static ArrayList<LegalEntity> legalEntity = new ArrayList<>();

    public static void addingStandardClients() {
        physicalPerson.add(new PhysicalPerson("Petrov Q", "Jujomu 1, k. 221", "2654138987", 4500, 15, 250));
        physicalPerson.add(new PhysicalPerson("Zuev R", "Krechatuk 34, k. 59", "1234567890", 5000, 0, 0));
        legalEntity.add(new LegalEntity("Lotos", "ord 56", "25836912", 12000, 15, 180));
        legalEntity.add(new LegalEntity("McLaut", "bv 37", "12345698", 10000, 0, 0));
    }

    public static int indexSearch(String search, Object array) {
        int index = 0;

        if (array == physicalPerson) {
            for (PhysicalPerson place : physicalPerson) {
                if (place.getNin().equals(search)) {
                    break;
                } else {
                    index = index + 1;
                }
            }
        }

        if (array == legalEntity) {
            for (LegalEntity place : legalEntity) {
                if (place.getNin().equals(search)) {
                    break;
                } else {
                    index = index + 1;
                }
            }
        }
        return index;
    }

    public static double bankingAssets() {
        double sumAssets = 0;

        for (PhysicalPerson aPhysicalPerson : physicalPerson) {
            sumAssets = sumAssets + aPhysicalPerson.getCash();
        }
        for (LegalEntity aLegalEntity : legalEntity) {
            sumAssets = sumAssets + aLegalEntity.getCash();
        }

        return sumAssets;
    }

    public void printInfo(String name, String address, String nin, double cash, double percent, int days) {
        double deposit = depositCalculation(cash, percent, days);
        double totalAsset = totalAsset(deposit, cash);
        System.out.println("_________________________________________________");
        System.out.println("______________________result_____________________");
        System.out.println("Name: " + name);
        System.out.println("address: " + address);

        if (nin.length() == 10) {
            System.out.println("NIN: " + nin);
        }
        if (nin.length() == 8) {
            System.out.println("ERDPOU: " + nin);
        }

        System.out.println("Deposit amount: " + cash + "UAH");
        System.out.println("Days: " + days);
        System.out.println("Interest rate: " + percent + "%");
        System.out.println("Payment on deposit: " + deposit + " UAH");
        System.out.println("The final amount: " + totalAsset + " UAH");
    }

    private double depositCalculation(double cash, double persent, int days) {
        double deposite = (cash * (persent / 100) * days) / 365;
        return new BigDecimal(deposite).setScale(2, RoundingMode.UP).doubleValue();
    }

    private double totalAsset(double deposit, double cash) {
        return new BigDecimal(deposit + cash).setScale(2, RoundingMode.UP).doubleValue();
    }
}