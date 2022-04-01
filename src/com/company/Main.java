package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.company.Lists.ListsArray;
import static com.company.Lists.listsArrayInfo;

public class Main {

    public static void main(String[] args) {
        for (; ; ) {
            System.out.println();
            System.out.println("1. Вывести список листов. " +
                    "2. Добавить. " +
                    "3. Удалить лист. " +
                    "4. Выбрать лист. " +
                    "5. Выйти из приложения.");
            Scanner scanner = null;
            try {
                scanner = new Scanner(System.in);
                int choice0 = scanner.nextInt();
                if (choice0==1 |choice0==2 | choice0==3 | choice0==4 | choice0==5){
                    switch (choice0) {
                        case 1:
                            Lists.listsArrayInfo();
                            break;

                        case 2:
                            System.out.println("Enter the list's name");
                            String listName = scanner.next(); //как использовать nextLine?
                            Lists newList = new Lists(listName);
                            newList.addList(newList);
                            System.out.println("Current ToDo lists: ");
                            Lists.listsArrayInfo();
                            break;

                        case 3:
                            System.out.println("Which list you want to delete?");
                            int listNumberToDelete = scanner.nextInt();
                            Lists.deleteList(listNumberToDelete);
                            System.out.println("Current ToDo lists: ");
                            Lists.listsArrayInfo();
                            break;

                        case 4:
                            System.out.println("Which list you want to edit?");
                            listsArrayInfo();
                            int choice4 = scanner.nextInt();
                            System.out.println("What would you like to edit in " + ListsArray[choice4 - 1].getListName() + ": " +
                                    "\n1. Add new task." +
                                    "\n2. Delete task." +
                                    "\n3. Edit task." +
                                    "\n4. Mark task as completed." +
                                    "\n5. Mark task as active.");
                        case 5:
                            System.out.println("Goodbye!");
                            return;
                    }
                } else {
                    System.out.println("try 1-5");}
            } catch (InputMismatchException e) {
                System.out.println("Enter correct number");
            }
        }
    }
}

