package com.myprograms.TaskManager2;

public class Application {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        System.out.println("find5NearestImportantTasks() >> ");
        System.out.println(taskManager.find5NearestImportantTasks(taskManager.taskList()));
        System.out.println("================================================================");

        System.out.println("getUniqueCategories() >> ");
        System.out.println(taskManager.getUniqueCategories(taskManager.taskList()));
        System.out.println("================================================================");

        System.out.println("getCategoriesWithTasks() >> ");
        System.out.println(taskManager.getCategoriesWithTasks(taskManager.taskList()));
        System.out.println("================================================================");

        System.out.println("splitTasksIntoDoneAndInProgress >> ");
        System.out.println(taskManager.splitTasksIntoDoneAndInProgress(taskManager.taskList()));
        System.out.println("================================================================");

        System.out.println("exitsTaskOfCategory >> ");
        System.out.println(taskManager.exitsTaskOfCategory(taskManager.taskList(), "red"));
        System.out.println("================================================================");

        System.out.println("getTitlesOfTasks >> ");
        System.out.println(taskManager.getTitlesOfTasks(taskManager.taskList(), 2, 5));
        System.out.println("================================================================");

        System.out.println("getCountsByCategories >> ");
        System.out.println(taskManager.getCountsByCategories(taskManager.taskList()));
        System.out.println("================================================================");

        System.out.println("getCategoriesNamesLengthStatistics >> ");
        System.out.println(taskManager.getCategoriesNamesLengthStatistics(taskManager.taskList()).toString());
        System.out.println("================================================================");

        System.out.println("findTaskWithBiggestCountOfCategories >> ");
        System.out.println(taskManager.findTaskWithBiggestCountOfCategories(taskManager.taskList()));
        System.out.println("================================================================");
    }
}