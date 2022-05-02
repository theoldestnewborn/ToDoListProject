package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Loader {
    final String name = "ToDoList.bin";

    public boolean ifExists () {
        File newFile = new File(name);
        return newFile.exists();
    }
    public Lists load () throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream oos = new ObjectInputStream(fis);
        Lists list = (Lists) oos.readObject();
        oos.close();
        return list;
    }

}
