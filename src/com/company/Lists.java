package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Lists {
    String name;
    LinkedHashMap<String, ArrayList> toDoList = new LinkedHashMap<>();

    public Lists() {
    }
    public Lists(String toDoListName) {
        this.name = toDoListName;
    }
    public void addList(String name, ArrayList<String> toDoListName) {
        toDoList.put(name, toDoListName);
    }
    public void deleteList(String name) {
        listsArrayInfo();
        System.out.println(name + " successfully deleted!");
        toDoList.remove((name));
    }
    public void listsArrayInfo() throws NullPointerException {
        if (toDoList.isEmpty()) {
            System.out.println("No ToDo lists found");
        } else {
            System.out.println(toDoList.keySet() + "\n");
        }
    }
}
