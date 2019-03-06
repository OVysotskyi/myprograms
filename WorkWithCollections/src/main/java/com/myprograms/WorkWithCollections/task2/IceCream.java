package com.myprograms.WorkWithCollections.task2;

public class IceCream extends Products {
    IceCream(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice(){
        return totalPrice(price, quantity);
    }
}