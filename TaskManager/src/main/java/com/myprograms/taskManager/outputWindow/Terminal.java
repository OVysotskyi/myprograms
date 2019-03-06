package com.myprograms.taskManager.outputWindow;


import com.myprograms.taskManager.taskManagement.Priority;
import com.myprograms.taskManager.taskManagement.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import static com.myprograms.taskManager.taskManagement.Priority.Importantly;
import static com.myprograms.taskManager.taskManagement.Priority.notImportantly;
import static com.myprograms.taskManager.taskManagement.Task.*;


public class Terminal {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static void printSortedList(List<Task> tasks, Comparator comparator) {
        tasks.sort(comparator);

        for (ListIterator<Task> i = tasks.listIterator(); i.hasNext(); ) {
            System.out.println(i.nextIndex() + 1 + ": " + i.next());
        }
    }

    private void windowToCreateANewTask() throws IOException {
        Priority priority;

        System.out.println("Enter a description of the new task:");
        String description = reader.readLine();
        System.out.println();
        System.out.println("Enter the end date for the task");
        System.out.print("Day: ");
        int day = Integer.parseInt(reader.readLine());
        System.out.print("Month: ");
        int month = Integer.parseInt(reader.readLine());
        System.out.print("Year: ");
        int year = Integer.parseInt(reader.readLine());

        LocalDate.of(year, month, day);

        System.out.println("The task is a priority? (yes/no)");

        if (reader.readLine().equals("yes")) {
            priority = Importantly;
        } else {
            priority = notImportantly;
        }

        tasks.add(new Task(LocalDate.of(year, month, day), description, priority));

        System.out.println("Task added.");
        System.out.println("_______________________________________________________");
    }

    private void windowToDeleteTask() throws IOException {
        System.out.println("Enter the task number: ");

        int number = Integer.parseInt(reader.readLine());

        System.out.println(tasks.get(number - 1).toString());
        System.out.println("Exactly delete? (yes/no)");
        if (reader.readLine().equals("yes")) {
            tasks.remove(number - 1);
            System.out.println("Done!");

            for (ListIterator<Task> i = tasks.listIterator(); i.hasNext(); ) {
                System.out.println(i.nextIndex() + 1 + ": " + i.next());
            }
        } else {
            System.out.println("Cancelled!");
        }
    }

    private void windowToChangeTaskStatus() throws IOException {
        System.out.println("Enter the task number: ");
        int number1 = Integer.parseInt(reader.readLine());
        System.out.println(tasks.get(number1 - 1).toString());

        if (tasks.get(number1 - 1).getStatus()) {
            System.out.println("The task has already been completed!");
            System.out.println("_______________________________________________________");
        }

        System.out.println("Change status? (yes/no)");

        if (reader.readLine().equals("yes")) {
            tasks.get(number1 - 1).isStatus(true);
            System.out.println("Done!");
            System.out.println(tasks.get(number1 - 1).toString());
        } else {
            System.out.println("Cancelled!");
        }
    }

    public void processingInput() {
        int command;

        while (true) {
            System.out.println("Select the operation:");
            System.out.println();
            System.out.println("1: Create a new task.");
            System.out.println("2: Delete task");
            System.out.println("3: Mark task as completed.");
            System.out.println("4: Show all task.");
            System.out.println("5: Show all uncompleted tasks.");
            System.out.println("6: Show all completed tasks.");
            System.out.println("Press 7 to exit.");
            System.out.println();
            System.out.print("Press: ");

            try {
                command = Integer.parseInt(reader.readLine());

                switch (command) {
                    case 1:
                        windowToCreateANewTask();
                        break;

                    case 2:
                        windowToDeleteTask();
                        break;

                    case 3:
                        windowToChangeTaskStatus();
                        break;

                    case 4:
                        System.out.println("Tasks:");

                        printSortedList(tasks, Comparator.comparing(Task::getDate));
                        break;

                    case 5:
                        System.out.println("Uncompleted tasks:");

                        printSortedList(getTasks(false), (Comparator<Task>) (o1, o2) -> {
                            int result = o1.getDate().compareTo(o2.getDate());

                            if (result != 0) {
                                return result;
                            }
                            return o1.getPriority().compareTo(o2.getPriority()) * (-1);
                        });
                        break;

                    case 6:
                        System.out.println("Completed tasks:");

                        try {
                            printSortedList(getCompletedTasks(true), (Comparator<Task>) (o1, o2) -> {
                                int result = o1.getDescription().compareTo(o2.getDescription());

                                if (result == 0) {
                                    int result2 = o1.getPriority().compareTo(o2.getPriority()) * (-1);

                                    if (result2 != 0) {
                                        return result2;
                                    }
                                    return o1.getDate().compareTo(o2.getDate());
                                }
                                return result;
                            });
                        } catch (NullPointerException e) {
                            System.out.println("No task has yet been completed. \n");
                        }
                        break;

                    case 7:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Command is not correct. Try again: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("The data you entered is not correct. Try again: ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}