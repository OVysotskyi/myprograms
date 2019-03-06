package com.myprograms.WorkWithInheritance;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rectangle implements Shape {
    private double sideA;
    private double sideB;

    Rectangle(double sideA) {
        this.sideA = this.sideB = sideA;
    }

    Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double calculateArea() {
        double area = sideA * sideB;
        return new BigDecimal(area).setScale(1, RoundingMode.UP).doubleValue();
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = (sideA + sideB) * 2;
        return new BigDecimal(perimeter).setScale(1, RoundingMode.UP).doubleValue();
    }

    @Override
    public void printInfo() {
        System.out.println("Side a of the rectangle = " + sideA);
        System.out.println("Side b of the rectangle = " + sideB);
        System.out.println("Area of the rectangle = " + calculateArea());
        System.out.println("Perimeter of the rectangle = " + calculatePerimeter());
    }
}