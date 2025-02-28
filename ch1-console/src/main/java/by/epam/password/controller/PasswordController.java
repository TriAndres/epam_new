package by.epam.password.controller;

import by.epam.password.file.PasswordFile;
import by.epam.password.service.PasswordServiceEntrance;
import by.epam.password.service.PasswordServiceRegistration;
import by.epam.password.service.PasswordServiceTask;

import static by.epam.password.file.PasswordFile.loadFromFile;

public class PasswordController {
    private static final String file = "ch1-console\\src\\main\\java\\by\\epam\\password\\file\\PasswordFile.txt";
    private static final PasswordFile passwordFile = loadFromFile(file);

    public static PasswordServiceRegistration passwordServiceRegistration() {
        return new PasswordServiceRegistration(passwordFile);
    }

    public static PasswordServiceEntrance passwordServiceEntrance() {
        return new PasswordServiceEntrance(passwordFile);
    }

    public static PasswordServiceTask passwordServiceTask() {
        return new PasswordServiceTask(passwordFile);
    }
}