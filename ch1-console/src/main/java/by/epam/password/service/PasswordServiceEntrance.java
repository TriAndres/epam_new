package by.epam.password.service;

import by.epam.password.file.PasswordFile;
import by.epam.password.model.Password;

import static by.epam.methods.Input.getString;

public class PasswordServiceEntrance {
    private final PasswordFile passwordFile;

    public PasswordServiceEntrance(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }

    public void entrance() {
        String login;
        String password;
        registrationFalse();
        System.out.println("Введите логин или 0 для выхлда:");
        login = getString();
        for (Password login2 : passwordFile.findAll()) {
            if (login2.getLogin().equals(login)) {
                System.out.println("Введите пароль или 0 для выхлда:");
                password = getString();
                if (login2.getPassword().equals(password)) {
                    login2.setRegistration(true);
                    passwordFile.save(login2);
                } else {
                    System.out.println("Пароль не подходит");
                    break;
                }
            } else {
                System.out.println("Логин не подходит");
                break;
            }
        }
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