package org.example;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class Password {
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    Password() {
        try {
            Path path = Path.of("src/main/resources/pass.txt");
            password = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
