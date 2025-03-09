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
            System.out.println("Введите логин:");
            login = getString();
            if (loginBool(login)) {
                break;
            } else {
                System.out.println("Существует логин.");
            }
        }
        System.out.println("Введите пароль:");
        password = getString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        Long id = getNextId();
        passwordFile.save(new Password(id, login, password, true, LocalDateTime.now().format(formatter), id));
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
            return true;
        } else {
            for (Password password : passwordFile.findAll()) {
                if (!password.getLogin().equals(login)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Long getNextId() {
        long currentMaxId = passwordFile.findAll()
                .stream()
                .mapToLong(Password::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}