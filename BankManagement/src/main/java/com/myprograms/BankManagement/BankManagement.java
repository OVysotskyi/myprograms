package com.myprograms.BankManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.myprograms.BankManagement.Client.*;

public class BankManagement {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int command;
        String name;
        String address;
        String regNumber;
        double cash;
        double percent;
        int days;

        addingStandardClients();

        while (true) {
            System.out.println("Press 1 to add a new customer.");
            System.out.println("Press 2 to open the customer information.");
            System.out.println("Press 3 to activate the deposit.");
            System.out.println("Press 4 to print total amount of investments in the bank.");
            System.out.println("Press 5 to exit.");
            System.out.print("Press: ");
            command = Integer.parseInt(input.readLine());

            if (command == 1) {
                System.out.println("Is this an physical(1) or a legal entity(2)?");
                System.out.print("Press: ");
                command = Integer.parseInt(input.readLine());

                if (command == 1) {
                    System.out.println("Enter customer information:");
                    System.out.print("Name: ");
                    name = input.readLine();
                    System.out.print("Address: ");
                    address = input.readLine();
                    System.out.print("NIN: ");
                    regNumber = input.readLine();
                    System.out.print("Deposit amount, UAH: ");
                    cash = Double.parseDouble(input.readLine());
                    System.out.println("Deposit activation? YES - 1, NO - 2");
                    int command1 = Integer.parseInt(input.readLine());

                    if (command1 == 1) {
                        System.out.print("Days: ");
                        days = Integer.parseInt(input.readLine());
                        System.out.print("Interest rate: ");
                        percent = Double.parseDouble(input.readLine());
                        physicalPerson.add(new PhysicalPerson(name, address, regNumber, cash, percent, days));
                        System.out.println("Deposit activated");
                    } else {
                        physicalPerson.add(new PhysicalPerson(name, address, regNumber, cash));
                    }
                    System.out.println("Client added");
                }

                if (command == 2) {
                    System.out.println("Enter customer information:");
                    System.out.print("Name: ");
                    name = input.readLine();
                    System.out.print("Address: ");
                    address = input.readLine();
                    System.out.print("ERDPOU: ");
                    regNumber = input.readLine();
                    System.out.print("Deposit amount, UAH: ");
                    cash = Double.parseDouble(input.readLine());
                    System.out.println("Deposit activation? YES - 1, NO - 2");
                    int command1 = Integer.parseInt(input.readLine());

                    if (command1 == 1) {
                        System.out.print("Days: ");
                        days = Integer.parseInt(input.readLine());
                        System.out.print("Interest rate: ");
                        percent = Double.parseDouble(input.readLine());
                        legalEntity.add(new LegalEntity(name, address, regNumber, cash, percent, days));
                        System.out.println("Deposit activated");
                    } else {
                        legalEntity.add(new LegalEntity(name, address, regNumber, cash));
                    }
                    System.out.println("Client added");
                }

            } else if (command == 2) {
                System.out.print("Enter the NIN/ERDPOU of the existing client: ");
                String search = input.readLine();

                if (search.length() == 8) {
                    legalEntity.get(indexSearch(search, legalEntity)).getInfo();
                } else if (search.length() == 10) {
                    physicalPerson.get(indexSearch(search, physicalPerson)).getInfo();
                } else {
                    System.out.println("Enter the correct NIN/ERDPOU");
                }
            } else if (command == 3) {
                System.out.print("Enter the NIN/ERDPOU of the existing client: ");
                String search = input.readLine();
                System.out.print("Days: ");
                days = Integer.parseInt(input.readLine());
                System.out.print("Interest rate: ");
                percent = Double.parseDouble(input.readLine());

                if (search.length() == 8) {
                    legalEntity.get(indexSearch(search, legalEntity)).setDays(days);
                    legalEntity.get(indexSearch(search, legalEntity)).setPercent(percent);

                    System.out.println("_________________________________________________");
                    System.out.println("Deposit activated");
                    System.out.println("_________________________________________________");

                    legalEntity.get(indexSearch(search, legalEntity)).getInfo();
                } else if (search.length() == 10) {
                    physicalPerson.get(indexSearch(search, physicalPerson)).setDays(days);
                    physicalPerson.get(indexSearch(search, physicalPerson)).setPercent(percent);

                    System.out.println("_________________________________________________");
                    System.out.println("Deposit activated");
                    System.out.println("_________________________________________________");

                    physicalPerson.get(indexSearch(search, physicalPerson)).getInfo();
                } else {
                    System.out.println("Enter the correct NIN/ERDPOU");
                }
            } else if (command == 4) {
                System.out.println("Total amount of investments in the bank: ");
                System.out.println(bankingAssets() + " UAH");
            } else if (command == 5) {
                System.exit(0);
            } else {
                System.out.println("Enter the correct command");
            }
            System.out.println("_________________________________________________");
        }
    }
}