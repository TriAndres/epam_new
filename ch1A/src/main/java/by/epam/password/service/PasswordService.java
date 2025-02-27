package by.epam.password.service;

import by.epam.password.file.PasswordFile;
import by.epam.password.model.Password;

public class PasswordService {
    private final PasswordFile passwordFile;

    public PasswordService(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }

    public void registration() {

    }

    public void entrance() {

    }

    public Long getNextId() {
        long currentMaxId = passwordFile.findAll()
                .stream()
                .mapToLong(Password::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}
