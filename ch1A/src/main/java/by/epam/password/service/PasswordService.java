package by.epam.password.service;

import by.epam.password.file.PasswordFile;

public class PasswordService {
    private final PasswordFile passwordFile;

    public PasswordService(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }
}
