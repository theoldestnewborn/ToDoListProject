package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Loader {
    Path path = Path.of("D:\\JAVA\\tasks\\ToDoListProject\\ToDoList.bin");
    private Lists newList;

    public boolean ifFileExists () {
        return Files.exists(Path.of("D:\\JAVA\\tasks\\ToDoListProject\\ToDoList.bin"));
    }
    public Lists load () {
        try (FileInputStream fis = new FileInputStream("D:\\JAVA\\tasks\\ToDoListProject\\ToDoList.bin");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            Lists list = (Lists) ois.readObject();
            ois.close();
            return list;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void save () throws IOException {
        FileOutputStream fos = new FileOutputStream(String.valueOf(path));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(newList);
        oos.close();
    }
}
