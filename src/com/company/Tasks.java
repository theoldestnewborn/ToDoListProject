package com.company;

public class Tasks {
    private int taskNumber;
    private String taskDescription, newTaskDescription;
    private boolean complete;

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
