package com.myprograms.WorkWithInheritance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ShapeEditor {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private boolean check;
    private ShapeType shape;

    ShapeEditor(ShapeType shape) {
        this.shape = shape;
    }

    void createShape() {
        do {
            try {
                switch (shape) {
                    case CIRCLE:
                        System.out.print("Enter the radius: ");
                        double radius = Double.parseDouble(reader.readLine());
                        new Circle(radius).printInfo();
                        break;

                    case SQUARE:
                        System.out.print("Enter the side a: ");
                        double sideA = Double.parseDouble(reader.readLine());
                        new Square(sideA).printInfo();
                        System.out.println("Since the square consists of two triangles, then their parameters are equal:");
                        new Triangle(sideA).printInfo();
                        break;

                    case TRIANGLE:
                        System.out.print("Enter the side a: ");
                        sideA = Double.parseDouble(reader.readLine());
                        System.out.print("Enter the side b: ");
                        double sideB = Double.parseDouble(reader.readLine());
                        System.out.print("Enter the side c: ");
                        double sideC = Double.parseDouble(reader.readLine());
                        new Triangle(sideA, sideB, sideC).printInfo();
                        break;

                    case RECTANGLE:
                        System.out.print("Enter the side a: ");
                        sideA = Double.parseDouble(reader.readLine());
                        System.out.print("Enter the side b: ");
                        sideB = Double.parseDouble(reader.readLine());
                        new Rectangle(sideA, sideB).printInfo();
                        System.out.println("Since the square consists of two triangles, then their parameters are equal:");
                        new Triangle(sideA, sideB).printInfo();
                        break;
                }
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("The data you entered is not correct. Try again.");
                check = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (check);
    }
}