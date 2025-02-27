package by.epam.password.file;

import by.epam.password.repository.PasswordRepositoryImpl;

public class PasswordFile extends PasswordRepositoryImpl {
    private final String file;

    public PasswordFile(String file) {
        this.file = file;
    }

    public static PasswordFile loadFromFile(String file) {
        PasswordFile passwordFile = new PasswordFile(file);

        return passwordFile;
    }
}
