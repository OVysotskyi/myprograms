package com.myprograms.WorkWithCollections.task2;

import java.util.ArrayList;
import java.util.List;

abstract class Products {
    String name;
    double price = 0;
    int quantity = 0;

    static List<IceCream> iceCreams = new ArrayList<>();
    static List<Cheese> cheeses = new ArrayList<>();
    static List<Fish> fishes = new ArrayList<>();

    static void addingStandardProduct() {
        iceCreams.add(new IceCream("Panda", 12.50, 10));
        iceCreams.add(new IceCream("Cold Cherry", 22, 15));
        cheeses.add(new Cheese("Roquefort", 250,10));
        cheeses.add(new Cheese("Camembert", 300,10));
        fishes.add(new Fish("Atlantic cod", 150,11));
        fishes.add(new Fish("Salmon", 200,12));
    }

    public String toString() {
        return "[name: " + name + " | price: " + price + " | quantity: " + quantity + " | total price: " + totalPrice(price, quantity) + "] \n";
    }

    double totalPrice(double price, int quantity) {
        return price * quantity;
    }

    static double calculationTotalPrice() {
        double value = 0;

        for (IceCream aIceCream : iceCreams) {
            value = value + aIceCream.getTotalPrice();
        }
        for (Cheese aCheese : cheeses) {
            value = value + aCheese.getTotalPrice();
        }
        for (Fish aFish : fishes) {
            value = value + aFish.getTotalPrice();
        }
        return value;
    }

    static int totalQuantity() {
        return iceCreams.size() + cheeses.size() + fishes.size();
    }
}