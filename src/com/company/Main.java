package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Lists newList = new Lists();
        Tasks newTask = new Tasks();
        for (; ; ) {
            System.out.println("1. Вывести список листов. " +
                    "2. Добавить. " +
                    "3. Удалить лист. " +
                    "4. Выбрать лист. " +
                    "5. Выйти из приложения.");
            Scanner scanner = null;
            try {
                scanner = new Scanner(System.in);
                int choice0 = scanner.nextInt();
                if (choice0 == 1 | choice0 == 2 | choice0 == 3 | choice0 == 4 | choice0 == 5) {
                    switch (choice0) {
                        case 1:
                            try {
                                newList.listsArrayInfo();
                            } catch (NullPointerException e) {
                                System.out.println("No ToDo lists found");
                            } break;

                        case 2:
                            System.out.println("Enter the list's name, 0 - back");
                            String listName = scanner.next();//как использовать nextLine?
                            if (listName.equals("0")) {
                                break;
                            } else {
                            ArrayList<String> newArrayList = new ArrayList<>();
                            newList.addList(listName, newArrayList);
                            System.out.println("Current ToDo lists: ");
                            newList.listsArrayInfo();
                            break;
                            }

                        case 3:
                            System.out.println("Which list you want to delete? 0 - back");
                            newList.listsArrayInfo();
                            String choice3 = scanner.next();
                            if (choice3.equals("0")) {
                                break;
                            } else {
                                newList.deleteList(choice3);
                                System.out.println("Current ToDo lists: ");
                                newList.listsArrayInfo();
                                break;
                            }

                        case 4:
                            System.out.println("Which list you want to edit?");
                            newList.listsArrayInfo();
                            System.out.println("0 - back");
                            String choice4 = scanner.next();
                            if (choice4.equals("0")) {
                                break;
                            } else {
                                System.out.println("What would you like to edit in " + "\"" + choice4 +"\""+ ": " +
                                        "\n1. Get all tasks of the list" +
                                        "\n2. Add new task." +
                                        "\n3. Delete task." +
                                        "\n4. Edit task." +
                                        "\n5. Mark task as completed." +
                                        "\n6. Mark task as active." +
                                        "\n0. Back");
                                    int choice4step2 = scanner.nextInt();
                                if (choice4step2 == 1 || choice4step2 == 2 || choice4step2 == 3 ||
                                    choice4step2 == 4 || choice4step2 == 5 || choice4step2 == 0) {
                                    switch (choice4step2) {
                                        case 1:

                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 0:
                                            return;
                                    }
                                } else {
                                    System.out.println("try 1-5 ");
                                    return;
                                }
                            }
                        case 5:
                            System.out.println("Goodbye!");
                            return;
                    }
                } else {
                    System.out.println("try 1-5 ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter correct number");
            }
        }
    }
}

