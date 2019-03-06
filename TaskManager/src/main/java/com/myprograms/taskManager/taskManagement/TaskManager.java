package com.myprograms.taskManager.taskManagement;

import com.myprograms.taskManager.outputWindow.Terminal;

import java.time.LocalDate;

import static com.myprograms.taskManager.taskManagement.Priority.Importantly;
import static com.myprograms.taskManager.taskManagement.Priority.notImportantly;
import static com.myprograms.taskManager.taskManagement.Task.tasks;

public class TaskManager {
    private static void addingStandardTasks() {
        tasks.add(new Task(LocalDate.of(2018, 12, 18), "1", notImportantly));
        tasks.add(new Task(LocalDate.of(2018, 12, 18), "3", Importantly));
        tasks.add(new Task(LocalDate.of(2018, 12, 18), "2", Importantly));
        tasks.add(new Task(LocalDate.of(2018, 12, 18), "2", notImportantly));
        tasks.add(new Task(LocalDate.of(2018, 12, 5), "test", Importantly));
        tasks.add(new Task(LocalDate.of(2018, 12, 12), "test 5", Importantly));
        tasks.add(new Task(LocalDate.of(2018, 12, 1), "6", notImportantly));
        tasks.add(new Task(LocalDate.of(2018, 12, 13), "3", Importantly));
        tasks.add(new Task(LocalDate.of(2018, 12, 5), "ee", notImportantly));
        tasks.add(new Task(LocalDate.of(2018, 12, 3), "ee", Importantly));
        tasks.add(new Task(LocalDate.of(2018, 12, 6), "ee", Importantly));
        tasks.add(new Task(LocalDate.of(2018, 10, 6), "ee", Importantly));
        tasks.add(new Task(LocalDate.of(2018, 11, 26), "ee", Importantly));
    }

    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        addingStandardTasks();
        terminal.processingInput();
    }
}