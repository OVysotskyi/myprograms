package com.myprograms.WorkWithCollections.task1;

import java.util.List;

class ListSorter {

    public static <T extends Comparable> List<T> sortByBubbles(List<T> elements, Direction direction) {
        if (elements.size() > 0) {
            T temp;

            for (int i = 0; i < elements.size(); i++) {
                for (int j = i; j < elements.size(); j++) {
                    if ((elements.get(i).compareTo(elements.get(j)) * direction.getDirection()) > 0) {
                        temp = elements.get(i);
                        elements.set(i, elements.get(j));
                        elements.set(j, temp);
                    }
                }
            }
            return elements;
        }
        return null;
    }

    public static <T extends Comparable> List<T> sortByInsertion(List<T> elements, Direction direction) {
        if (elements.size() > 0) {
            T temp;
            int j;

            for (int i = 1; i < elements.size(); i++) {
                temp = elements.get(i);
                for (j = i - 1; j >= 0 && (elements.get(j).compareTo(temp) * direction.getDirection()) > 0; j--) {
                    elements.set(j + 1, elements.get(j));
                }
                elements.set(j + 1, temp);
            }
            return elements;
        }
        return null;
    }

    public static <T extends Comparable> List<T> sortBySelection(List<T> elements, Direction direction) {
        if (elements.size() > 0) {
            for (int i = 0; i < elements.size() - 1; i++) {
                int min = i;

                for (int j = i + 1; j < elements.size(); j++) {
                    if ((elements.get(j).compareTo(elements.get(min)) * direction.getDirection()) < 0) {
                        min = j;
                    }
                }
                T temp = elements.get(i);
                elements.set(i, elements.get(min));
                elements.set(min, temp);
            }
            return elements;
        }
        return null;
    }
}