package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Lists newList = new Lists();
        Loader loader = new Loader();
        if (loader.ifFileExists()) {
                newList = loader.load();
                System.out.println("load");

        } else {newList = new Lists();
            System.out.println("created");}

        for (; ; ) {
            System.out.println("\n1. View all ToDo lists " +
                    "\n2. Add list " +
                    "\n3. Delete list " +
                    "\n4. Choose list " +
                    "\n5. Quit");

            newList.printActive();

            Scanner scanner;
            try {
                scanner = new Scanner(System.in);
                int choice0 = scanner.nextInt();
                if (choice0 == 1 | choice0 == 2 | choice0 == 3 | choice0 == 4 | choice0 == 5) {
                    switch (choice0) {
                        case 1:
                            newList.listsArrayInfo();
                            break;
                        case 2:
                            System.out.println("Enter the list's name, 0 - back");
                            String listName = scanner.next();//как использовать nextLine?
                            if (listName.equals("0")) {
                                break;
                            } else if (newList.ifListExists(listName)) {
                                System.out.println("Try another name!");
                                break;
                            } else {
                                ArrayList<Tasks> newArrayList = new ArrayList<>();
                                newList.addList(listName, newArrayList);
                                System.out.println("Current ToDo lists: ");
                                newList.listsArrayInfo();
                                break;
                            }

                        case 3:
                            for (; ; ) {
                                if (newList.isMapEmpty()) {
                                    System.out.println("No ToDo lists");
                                } else {
                                    System.out.println("Which list you want to delete? 0 - back");
                                    newList.listsArrayInfo();
                                    String choice3 = scanner.next();
                                    if (choice3.equals("0")) {
                                        break;
                                    } else if (!newList.ifListExists(choice3)) {
                                        System.out.println("Wrong list name");
                                    } else if (newList.ifListExists(choice3)) {
                                        newList.deleteList(choice3);
                                        System.out.println("Current ToDo lists: ");
                                        newList.listsArrayInfo();
                                        break;
                                    }
                                }
                            }
                            break;

                        case 4:
                            for (; ; ) {
                                System.out.println("Which list you want to edit?");
                                newList.listsArrayInfo();
                                System.out.println("0 - back");
                                String choice4 = scanner.next();
                                if (choice4.equals("0")) {
                                    break;
                                } else if (newList.ifListExists(choice4)) {
                                    for (; ; ) {
                                        System.out.println("\nWhat would you like to edit in " + "\"" + choice4 + "\"" + ": " +
                                                "\n1. View all tasks of the list" +
                                                "\n2. Add new task." +
                                                "\n3. Delete task." +
                                                "\n4. Edit task." +
                                                "\n5. Mark task as completed." +
                                                "\n6. Mark task as active." +
                                                "\n0. Back");
                                        String choice4step2 = scanner.next();
                                        if (choice4step2.equals("0")) {
                                            break;
                                        } else if (choice4step2.equals("1") || choice4step2.equals("2") || choice4step2.equals("3")
                                                || choice4step2.equals("4") || choice4step2.equals("5") || choice4step2.equals("6")) {
                                            switch (choice4step2) {
                                                case "1":
                                                    newList.tasksInListInfo(choice4);
                                                    break;
                                                case "2":
                                                    System.out.println("Enter the task");
                                                    String taskToAdd = scanner.next();
                                                    newList.addTask(choice4, taskToAdd);
                                                    newList.tasksInListInfo(choice4);
                                                    break;
                                                case "3":
                                                    if (newList.isListEmpty(choice4)) {
                                                        System.out.println("The list is empty"); break;
                                                    } else {
                                                        newList.tasksInListInfo(choice4);
                                                        newList.tasksInListInfo(choice4);
                                                        System.out.println("Which task you want to delete? (Number 1-...)");
                                                        int taskToDelete = scanner.nextInt();
                                                        newList.deleteTask(choice4, taskToDelete);
                                                        newList.tasksInListInfo(choice4);
                                                        break;
                                                    }
                                                case "4":
                                                    if (newList.isListEmpty(choice4)) {
                                                        System.out.println("The list is empty"); break;
                                                    } else {
                                                        newList.tasksInListInfo(choice4);
                                                        System.out.println("Which task you want to edit");
                                                        int taskToEdit = scanner.nextInt();
                                                        System.out.println("Type corrected task");
                                                        String correction = scanner.next(); // nextline?
                                                        newList.editTask(choice4, taskToEdit, correction);
                                                        newList.tasksInListInfo(choice4);
                                                        break;
                                                    }
                                                case "5":
                                                    if (newList.isListEmpty(choice4)) {
                                                        System.out.println("The list is empty");
                                                        break;
                                                    } else {
                                                        newList.tasksInListInfo(choice4);
                                                        System.out.println("Which task you want to mark as completed");
                                                        int completed = scanner.nextInt() - 1;
                                                        newList.completedMarker(choice4, completed);
                                                        System.out.println("Task " + newList.getTask(choice4, completed).
                                                                toString() + " is marked as completed now.");
                                                        break;
                                                    }

                                                case "6":
                                                    if (newList.isListEmpty(choice4)) {
                                                        System.out.println("The list is empty");
                                                        break;
                                                    } else {
                                                        newList.tasksInListInfo(choice4);
                                                        System.out.println("Which task you want to choose as active " +
                                                                "(only 1 task can be active)");
                                                        int active = scanner.nextInt() - 1;
                                                        newList.activeMarker(choice4, active);
                                                        System.out.println("Task " + newList.getTask(choice4, active)
                                                                + " is active now!");
                                                        break;
                                                    }
                                            }
                                        } else {
                                            System.out.println("Try 1-6");
                                        }
                                    }
                                } else {
                                    System.out.println("Try another name");
                                }
                            }
                            break;

                        case 5:
                            try {
                                loader.save();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("Goodbye!");
                            return;
                    }
                } else {
                    System.out.println("try 1-5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter correct number");
            }
        }
    }
}

