package com.myprograms.WorkWithInheritance;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShapeType shape = null;
        boolean check;
        System.out.print("Enter name the shape: ");

        do {
            check = false;
            String nameShape = input.nextLine().toUpperCase();
            try {
                shape = ShapeType.valueOf(nameShape);
            } catch (IllegalArgumentException e) {
                System.out.print("The form you entered is not correct. Try again: ");
                check = true;
            }
        } while (check);

        new ShapeEditor(shape).createShape();
    }
}