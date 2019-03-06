package com.myprograms.WorkWithInheritance;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        double area = Math.PI * Math.pow(radius, 2);
        return new BigDecimal(area).setScale(1, RoundingMode.UP).doubleValue();
    }

    @Override
    public double calculatePerimeter() {
        double perimeter = 2 * Math.PI * radius;
        return new BigDecimal(perimeter).setScale(1, RoundingMode.UP).doubleValue();
    }

    @Override
    public void printInfo() {
        System.out.println("Radius of the circle = " + radius);
        System.out.println("Area of the circle = " + calculateArea());
        System.out.println("Perimeter of the circle = " + calculatePerimeter());
    }
}