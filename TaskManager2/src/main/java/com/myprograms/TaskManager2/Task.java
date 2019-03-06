package com.myprograms.TaskManager2;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class Task {
    private int id;
    private TaskType type;
    private String title;
    private boolean done;
    private Set<String> categories = new TreeSet<>();
    private LocalDate startsOn;

    public Task() {

    }

    public Task(int id, TaskType type, String title, String categories, LocalDate startsOn) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.categories.add(categories);
        this.startsOn = startsOn;
        done = false;
    }

    public Task(int id, TaskType type, String title, String categories, LocalDate startsOn, boolean done) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.categories.add(categories);
        this.startsOn = startsOn;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskType getType() {
        return type;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public String categoryToString() {
        return categories.toString();
    }

    public LocalDate getStartsOn() {
        return startsOn;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public String toString() {
        String result = "\n\nTask id: [" + getId() + "]. " + "TaskType: " + getType()
                            + ".\nTitle: " + getTitle() + ".\nCategories: " + getCategories()
                            + ".\nStart date: [" + getStartsOn() + "].\nStatus: " + ((isDone()) ? "Not done" : "Done");
        return result.replaceAll("\\{|\\}|\\=", "");
    }
}