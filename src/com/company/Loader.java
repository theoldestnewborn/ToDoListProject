package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Loader {
    final Path path = Path.of("ToDoList.bin");

    public boolean ifFileExists() {
        return Files.exists(path);
    }

    public Path getPath() {
        return path;
    }

    public Lists load() {
        try (FileInputStream fis = new FileInputStream(String.valueOf(path));
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Lists) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
