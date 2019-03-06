package com.myprograms.WorkWithCollections.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.myprograms.WorkWithCollections.task2.Products.*;

public class InventoryStore {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int command;

        addingStandardProduct();

        while (true) {
            System.out.println("Press 1 to add a new product.");
            System.out.println("Press 2 to display product information.");
            System.out.println("Press 3 to print general store information.");
            System.out.println("Press 4 to exit");
            System.out.print("Press: ");
            command = Integer.parseInt(input.readLine());

            if (command == 1) {
                System.out.print("Enter the product name: ");
                String name = input.readLine();
                System.out.print("Enter the price of the item: ");
                double price = new BigDecimal(Double.parseDouble(input.readLine())).setScale(2, RoundingMode.UP).doubleValue();
                System.out.print("Enter the quantity of the product: ");
                int quantity = Integer.parseInt(input.readLine());

                System.out.println("Product group");
                System.out.println("(1) Ice Cream");
                System.out.println("(2) Cheese");
                System.out.println("(3) Fish");
                System.out.print("Press: ");
                int command1 = Integer.parseInt(input.readLine());

                if (command1 == 1) {
                    iceCreams.add(new IceCream(name, price, quantity));
                } else if (command1 == 2) {
                    cheeses.add(new Cheese(name, price, quantity));
                } else if (command1 == 3) {
                    fishes.add(new Fish(name, price, quantity));
                }
                System.out.println("Product added.");
            } else if (command == 2) {
                System.out.println("Product group" + "\n (1) Ice Cream" + "\n (2) Cheese" + "\n (3) Fish");
                System.out.print("Press: ");
                int command1 = Integer.parseInt(input.readLine());

                if (command1 == 1) {
                    System.out.println("Ice Cream:");
                    System.out.println(iceCreams.toString().replaceAll("^\\[|]$", "").replace(", ", ""));
                } else if (command1 == 2) {
                    System.out.println("Cheeses:");
                    System.out.println(cheeses.toString().replaceAll("^\\[|]$", "").replace(", ", ""));
                } else if (command1 == 3) {
                    System.out.println("Fish:");
                    System.out.println(fishes.toString().replaceAll("^\\[|]$", "").replace(", ", ""));
                }
            } else if (command == 3) {
                System.out.println("Total quantity of products in the store: " + totalQuantity() + ", a total cost: " + calculationTotalPrice());
            } else if (command == 4) {
                System.exit(0);
            } else {
                System.out.println("Enter the correct command");
            }
            System.out.println("___________________________________________________________________________");
        }
    }
}