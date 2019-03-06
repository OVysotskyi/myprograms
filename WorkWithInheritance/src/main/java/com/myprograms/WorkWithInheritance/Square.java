package com.myprograms.WorkWithInheritance;

public class Square extends Rectangle {
    private double sideA;

    Square(double sideA) {
        super(sideA);
        this.sideA = sideA;
    }

    @Override
    public void printInfo() {
        System.out.println("Side a of the square = " + sideA);
        System.out.println("Area of the square = " + calculateArea());
        System.out.println("Perimeter of the square = " + calculatePerimeter());
    }
}