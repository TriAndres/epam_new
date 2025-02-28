package by.epam.password.service;

import by.epam.password.file.PasswordFile;
import by.epam.password.model.Password;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static by.epam.methods.Input.getString;

public class PasswordServiceRegistration {
    private final PasswordFile passwordFile;

    public PasswordServiceRegistration(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }

    public void registration() {
        String login;
        String password;
        registrationFalse();
        while (true) {
            while (true) {
                System.out.println("Введите логин от 5 знаков или 0 для выхлда:");
                login = getString();
                if (login.length() >= 5) {
                    if (loginBool(login)) {
                        break;
                    } else {
                        System.out.println("Существует логин.");
                    }
                } else if (login.equals("0")) {
                    login = "0";
                    break;
                }
            }

            if (!login.equals("0")) {
                while (true) {
                    System.out.println("Введите пароль от 5 знаков");
                    password = getString();
                    if (password.length() >= 5) {
                        break;
                    } else if (password.equals("0")) {
                        password = "0";
                        break;
                    }
                }
                if (!password.equals("0")) {
                    String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                    passwordFile.save(new Password(getNextId(), login, password, true, "null", date, 0));
                } else {
                    System.out.println("Выход");
                    break;
                }
            } else {
                System.out.println("Выход");
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

    private boolean loginBool(String login) {
        if (passwordFile.findAll().isEmpty()) {
            return false;
        } else {
            for (Password password : passwordFile.findAll()) {
                if (!password.getLogin().equals(login)) {
                    return true;
                }
            }
        }
        return false;
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