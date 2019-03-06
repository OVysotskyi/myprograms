package com.myprograms.taskManager.taskManagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.myprograms.taskManager.taskManagement.Priority.Importantly;

public class Task {
    private LocalDate date;
    private String description;
    private Priority priority;
    private boolean status;

    public static List<Task> tasks = new ArrayList<>();

    public Task(LocalDate date, String description, Priority priority) {
        this.date = date;
        this.description = description;
        this.priority = priority;
        this.status = false;
    }

    public static List<Task> getTasks(boolean status) {
        List<Task> getTasks = new ArrayList<>();
        LocalDate dateNow = LocalDate.now();

        for (Task task : tasks) {
            if (task.getStatus() == status && (task.getDate().isAfter(dateNow) || task.getDate().isEqual(dateNow))) {
                getTasks.add(task);
            }
        }
        return getTasks;
    }

    public static List<Task> getCompletedTasks(boolean status) {
        List<Task> getTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getStatus() == status) {
                getTasks.add(task);
            }
        }
        return getTasks;
    }

    public String getDescription() {
        return description;
    }

    public boolean getStatus() {
        return status;
    }

    public void isStatus(boolean status) {
        this.status = status;
    }

    public String getPriority() {
        if (priority == Importantly) {
            return "Task is important.";
        }
        return "";
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        String output = "Finish to: " + dateToString() + "; " + "Status: " + getStat() + ". " + getPriority() + "\n" + "Task: " + description + "\n";
        String border = "______________________________________________________________" + "\n";

        return output + border;
    }

    private String getStat() {
        if (status) {
            return "completed";
        }
        return "not complete";
    }

    private String dateToString() {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.uuuu"));
    }
}