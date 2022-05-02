package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Lists implements Serializable {
    LinkedHashMap<String, ArrayList<Tasks>> toDoList = new LinkedHashMap<>();

    public Lists() {
    }

    public void addList(String name, ArrayList<Tasks> toDoListName) {
        toDoList.put(name, toDoListName);
    }

    public void listsArrayInfo() {
        if (toDoList.isEmpty()) {
            System.out.println("No ToDo lists found");
        } else {
            System.out.println("Lists: " + toDoList.keySet());
        }
        printActive();
    }

    public void deleteList(String name) {
        listsArrayInfo();
        System.out.println(name + " successfully deleted!");
        toDoList.remove((name));
    }

    public boolean ifListExists(String name) {
        return toDoList.containsKey(name);
    }

    public boolean isMapEmpty() {
        return toDoList.isEmpty();
    }

    public void tasksInListInfo(String name) {
        ArrayList<Tasks> tasks = toDoList.get(name);
        if (tasks.isEmpty()) {
            System.out.println("No tasks in this list");
        } else {
            System.out.println("Current tasks in " + name + " - ");
            for (Tasks task : tasks) {
                if (task.isComplete()) {
                    System.out.println((tasks.indexOf(task) + 1) + ". " + task + " ✓");
                } else {
                    System.out.println((tasks.indexOf(task) + 1) + ". " + task);
                }
            }
        }
        printActive();
    }

    public void addTask(String name, String info) {
        ArrayList<Tasks> tasks = toDoList.get(name);
        tasks.add(new Tasks(info));
    }

    public void deleteTask(String name, int number) {
        ArrayList<Tasks> tasks = toDoList.get(name);
        tasks.remove(number - 1);
    }

    public void editTask(String name, int number, String edit) {
        ArrayList<Tasks> tasks = toDoList.get(name);
        tasks.set(number - 1, new Tasks(edit));
    }

    public void completedMarker(String name, int number) {
        ArrayList<Tasks> tasks = toDoList.get(name);
        tasks.get(number).setComplete(true);
    }

    public Tasks getTask(String name, int number) {
        ArrayList<Tasks> tasks = toDoList.get(name);
        return tasks.get(number);
    }

    public void activeMarker(String name, int number) {
        Set<Map.Entry<String, ArrayList<Tasks>>> set = toDoList.entrySet();
        Iterator<Map.Entry<String, ArrayList<Tasks>>> i = set.iterator();
        while (i.hasNext()) {
            ArrayList<Tasks> tasks = i.next().getValue();
            for (Tasks task : tasks) {
                if (task.isActive()) {
                    task.setActive(false);
                }
            }
        }
        ArrayList<Tasks> tasks = toDoList.get(name);
        tasks.get(number).setActive(true);
    }

    public void printActive() {
        Set<Map.Entry<String, ArrayList<Tasks>>> set = toDoList.entrySet();
        Iterator<Map.Entry<String, ArrayList<Tasks>>> i = set.iterator();
        while (i.hasNext()) {
            ArrayList<Tasks> tasks = i.next().getValue();
            for (Tasks task : tasks) {
                if (task.isActive()) {
                    System.out.println("\nREMINDER: Task " + task + " is active!");
                }
            }
        }
    }





}

