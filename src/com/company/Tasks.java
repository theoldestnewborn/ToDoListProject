package com.company;

import java.util.ArrayList;

public class Tasks {
    private boolean complete;
    ArrayList<String> taskList = new ArrayList<>();

    public ArrayList<String> createList (String name) {
        taskList = new ArrayList<>();
    return taskList;
    }

    public void getTaskListDescription (ArrayList<String> list, int number) {
        System.out.println(list);
    }

    private void addTask (int taskNumber, String taskDescription ){
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
    }

    private void deleteTask (){

    }

    private void editTask (int taskNumber, String taskDescription){
        this.taskDescription = newTaskDescription;
    }

    private void complete () {

    }
}
