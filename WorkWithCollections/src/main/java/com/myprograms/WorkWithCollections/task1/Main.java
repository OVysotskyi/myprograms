package com.myprograms.WorkWithCollections.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Alex",26));
        users.add(new User("Max",40));
        users.add(new User("Ben",45));
        users.add(new User("Morty",38));
        users.add(new User("Alex",12));
        users.add(new User("Rick",18));
        users.add(new User("Max", 44));

        System.out.println("Not sorted list: " + users);
        System.out.println();

        System.out.println("Bubble sort in ascending: " + ListSorter.sortByBubbles(users, Direction.ASC));
        System.out.println("Bubble sort in descending: " + ListSorter.sortByBubbles(users, Direction.DESC));
        System.out.println();

        System.out.println("Sort by insertion in ascending: " + ListSorter.sortByInsertion(users, Direction.ASC));
        System.out.println("Sort by insertion in descending: " + ListSorter.sortByInsertion(users, Direction.DESC));
        System.out.println();

        System.out.println("Sort by selection in ascending: " + ListSorter.sortBySelection(users, Direction.ASC));
        System.out.println("Sort by selection in descending: " + ListSorter.sortBySelection(users, Direction.DESC));
    }
}