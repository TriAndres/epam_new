package by.epam.password.controller;

import by.epam.password.file.PasswordFile;
import by.epam.password.service.PasswordServiceImpl;

import static by.epam.password.file.PasswordFile.loadFromFile;

public class PasswordController {
    private static final String file = "ch2-console\\src\\main\\java\\by\\epam\\password\\file\\PasswordFile.txt";
    private static final PasswordFile passwordFile = loadFromFile(file);

    public static PasswordServiceImpl getPasswordServiceImpl() {
        return new PasswordServiceImpl(passwordFile);
    }
}
