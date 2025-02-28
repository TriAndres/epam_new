package by.epam.password.service;

import by.epam.password.file.PasswordFile;
import by.epam.password.model.Password;

public class PasswordServiceEntrance {
    private final PasswordFile passwordFile;

    public PasswordServiceEntrance(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }

    public void entrance() {
        String login;
        String password;
        registrationFalse();
    }

    public boolean registrationBool() {
        for (Password password : passwordFile.findAll()) {
            if (password.getRegistration().equals(true)) {
                return true;
            }
        }
        return false;
    }

    private void registrationFalse() {
        if (!passwordFile.findAll().isEmpty()) {
            for (Password password : passwordFile.findAll()) {
                password.setRegistration(false);
                passwordFile.save(password);
            }
        }
    }
}
