package com.company;

import java.util.ArrayList;

public class Tasks {
    private String task;
    private boolean isComplete;
    private boolean isActive;

    public Tasks () {
    }
    public Tasks (String task) {
        this.task = task;
        this.isComplete = false;
        this.isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        return task;
    }
}
