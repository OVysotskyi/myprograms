package com.myprograms.TaskManager2;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    public List<Task> find5NearestImportantTasks(List<Task> tasks) {
        return tasks.stream()
                    .sorted(Comparator.comparing(Task::getStartsOn))
                    .limit(5)
                    .collect(Collectors.toList());
    }

    public List<String> getUniqueCategories(List<Task> tasks) {
        return tasks.stream()
                    .map(p -> p.getCategories() + "")
                    .distinct()
                    .collect(Collectors.toList());
    }

    public Map<String, List<Task>> getCategoriesWithTasks(List<Task> tasks) {
        return tasks.stream()
                    .collect(Collectors.groupingBy(p -> p.getCategories().toString()));
    }

    public Map<Boolean, List<Task>> splitTasksIntoDoneAndInProgress(List<Task> tasks) {
        return tasks.stream()
                    .collect(Collectors.partitioningBy(Task::isDone));
    }

    public boolean exitsTaskOfCategory(List<Task> tasks, String category) {
        return tasks.stream()
                    .map(p -> p.getCategories() + "")
                    .map(p -> p.replaceAll("\\[|\\]|\\=", ""))
                    .anyMatch(p -> p.contains(category));
    }

    public String getTitlesOfTasks(List<Task> tasks, int startNo, int endNo) {
        return tasks.stream()
                    .skip(startNo)
                    .limit(endNo)
                    .map(Task::getTitle)
                    .collect(Collectors.joining(", ", "", "."));
    }

    public Map<String, Long> getCountsByCategories(List<Task> tasks) {
        return tasks.stream()
                    .collect(Collectors.groupingBy(Task::categoryToString, Collectors.counting()));
    }

    public IntSummaryStatistics getCategoriesNamesLengthStatistics(List<Task> tasks) {
        return tasks.stream()
                    .map(p -> p.getCategories().toString().replaceAll("\\[|\\]|", ""))
                    .map(p -> p.length())
                    .collect(Collectors.summarizingInt(p -> p));
    }

    public Task findTaskWithBiggestCountOfCategories(List<Task> tasks) {
        return tasks.stream()
                    .max(Comparator.comparing(t -> t.categoryToString().length())).get();
    }

    public List<Task> taskList() {
        List<Task> taskList = new ArrayList<>();

        taskList.add(new Task(1, TaskType.Important, "test", "green, red", LocalDate.of(2018, 12, 11)));
        taskList.add(new Task(2, TaskType.Important, "test2", "blue", LocalDate.of(2018, 11, 30)));
        taskList.add(new Task(3, TaskType.Important, "test3", "red", LocalDate.of(2018, 11, 26), true));
        taskList.add(new Task(4, TaskType.noPriority, "test4", "green", LocalDate.of(2018, 12, 1), true));
        taskList.add(new Task(5, TaskType.noPriority, "test5", "red", LocalDate.of(2018, 12, 12)));
        taskList.add(new Task(6, TaskType.Important, "test6", "red", LocalDate.of(2018, 11, 24), true));
        taskList.add(new Task(7, TaskType.Important, "test7", "red", LocalDate.of(2018, 12, 15)));

        return taskList;
    }
}