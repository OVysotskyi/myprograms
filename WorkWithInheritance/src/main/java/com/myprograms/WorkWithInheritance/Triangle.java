package com.myprograms.WorkWithInheritance;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private double perimeter;

    Triangle(double sideA) {
        this.sideA = this.sideB = sideA;
        this.sideC = definingTheSideC(sideA, sideB);
    }

    Triangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = definingTheSideC(sideA, sideB);
    }

    Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    private double definingTheSideC(double sideA, double sideB) {
        double sideC = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
        return new BigDecimal(sideC).setScale(1, RoundingMode.UP).doubleValue();
    }

    @Override
    public double calculatePerimeter() {
        perimeter = sideA + sideB + sideC;
        return new BigDecimal(perimeter).setScale(1, RoundingMode.UP).doubleValue();
    }

    @Override
    public double calculateArea() {
        double halfPerimeter = perimeter / 2;
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
        return new BigDecimal(area).setScale(1, RoundingMode.UP).doubleValue();
    }

    @Override
    public void printInfo() {
        System.out.println("Sides of the triangle: a = " + sideA + ", b = " + sideB + ", c = " + sideC);
        System.out.println("Perimeter of the triangle = " + calculatePerimeter());
        System.out.println("Area of the triangle: " + calculateArea());
    }
}