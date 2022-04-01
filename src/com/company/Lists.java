package com.company;


import java.util.Scanner;

public class Lists {
    String listName;
    static Lists[] ListsArray = new Lists[5];
    Scanner scanner1 = new Scanner(System.in);

    public Lists() {
    }

    public Lists(String listName) {
        this.listName = listName;
    }

    public static void listsArrayInfo() {
        int number = 1;
        for (Lists l1 : ListsArray) {
            if (l1 != null) {
                System.out.println(number + ". " + l1.getListName());
                number++;
            }
        }
        if (ListsArray[0] == null &
                ListsArray[1] == null &
                ListsArray[2] == null &
                ListsArray[3] == null &
                ListsArray[4] == null) {
            System.out.println("No To Do lists found");
        }
    }

    public void addList(Lists newList) {
        for (int i = 0; i < ListsArray.length; i++) {
            if (ListsArray[i] == null) {
                ListsArray[i] = newList;
                return;
            }
        }
    }

    public static void deleteList(int listNumber) {


        System.out.println(ListsArray[listNumber - 1].getListName() + " successfully deleted!");
        ListsArray[listNumber - 1] = null;
    }


    public String getListName() {
        return listName;
    }

    public Lists[] getListsArray() {
        return ListsArray;
    }
}
