package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = null;
        try (FileInputStream fileInputStream = new FileInputStream(file)){
            String readFileContent = new String(fileInputStream.readAllBytes());
            String[] copyFileContent = readFileContent.split("\\R\n");
            String name = copyFileContent[0].split(" ")[1];
            Integer age = Integer.parseInt(copyFileContent[1].split(" ")[1]);
            String email = copyFileContent[2].split(" ")[1];
            Long phone = Long.parseLong(copyFileContent[3].split(" ")[1]);
            profile = new Profile(name, age, email, phone);
        } catch (IOException iOE){
            System.out.println("Catched)");
        }
        return profile;
    }
}
