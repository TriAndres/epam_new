package by.epam.password.service;

import by.epam.password.file.PasswordFile;
import by.epam.password.modell.Password;

import java.time.LocalDateTime;
import java.util.function.Predicate;

import static by.epam.metods.console.Console.getString;

public class PasswordService {
    private final PasswordFile passwordFile;

    public PasswordService(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }

    public void findAll() {
        for (Password password : passwordFile.findAll()) {
            System.out.println(password.toString());
        }
    }

    public void create() {
        Password password = new Password();
        password.setId(getNextId());
        password.setRegistration(false);
        password.setDataRegistration(LocalDateTime.now());
        System.out.println("Введите логин:");
        while (true) {
            String login = getString();
            if (login.length() >= 5) {
                if (filter(i -> i.getLogin().equals(login))) {
                    password.setLogin(login);
                    System.out.println("Сохранён.");
                    break;
                } else {
                    System.out.println("Есть такой логин, введите новый.");
                }
            } else {
                System.out.println("Логин дольжен больше или равно из 5 символов.");
            }
        }

        System.out.println("Введите пароль:");
        password.setPassword(getString());
        System.out.println("Введите имя:");
        password.setFirstName(getString());
        System.out.println("Введит фамилию:");
        password.setSecondName(getString());
        System.out.println("Введите емаил:");
        password.setEmail(getString());
        passwordFile.save(password);
    }

    private boolean filter(Predicate<Password> predicate) {
        boolean result = false;
        for (Password password : passwordFile.findAll()) {
            if (predicate.test(password)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void update() {

    }

    public void findById() {

    }

    public void deleteById() {

    }

    private long getNextId() {
        long currentMaxId = passwordFile
                .findAll()
                .stream()
                .mapToLong(Password::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}