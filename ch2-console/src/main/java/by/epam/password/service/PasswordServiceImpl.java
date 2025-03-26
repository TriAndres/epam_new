package by.epam.password.service;

import by.epam.password.file.PasswordFile;
import by.epam.password.modell.Password;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

import static by.epam.metods.console.Console.getInteger;
import static by.epam.metods.console.Console.getString;

public class PasswordServiceImpl implements PasswordService{
    private final PasswordFile passwordFile;

    public PasswordServiceImpl(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }
    @Override
    public void findAll() {
        if (!passwordFile.findAll().isEmpty()) {
            for (Password password : passwordFile.findAll()) {
                System.out.println(password.toString());
            }
        } else {
            System.out.println("Заполните список данными.");
        }
    }
    @Override
    public void create() {
        Password password = new Password();
        password.setId(getNextId());
        password.setRegistration(false);
        password.setDataRegistration(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm")));
        System.out.println("Введите логин:");
        while (true) {
            String login = getString();
            if (login.length() >= 5) {
                if (!(filter(i -> i.getLogin().equals(login)))) {
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
        while (true) {
            String passwords = getString();
            if (passwords.length() >= 5) {
                password.setPassword(passwords);
                System.out.println("Сохранён.");
                break;
            } else {
                System.out.println("Пароль дольжен больше или равно из 5 символов.");
            }
        }

        System.out.println("Введите фамилию:");
        password.setFirstName(getString());
        System.out.println("Сохранён.");

        System.out.println("Введит имя:");
        password.setSecondName(getString());
        System.out.println("Сохранён.");

        System.out.println("Введите емаил:");
        while (true) {
            String email = getString();
            String[] a = email.split("");
            boolean result = false;
            for (String s : a) {
                if (s.equals("@")) {
                    result = true;
                    break;
                }
            }
            if (result) {
                password.setEmail(email);
                System.out.println("Сохранён.");
                break;
            } else {
                System.out.println("Имя дольжено больше или равно из 5 символов.");
            }
        }
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
    @Override
    public void update() {
        System.out.println("Введите id для обновления:");
        Password password = passwordFile.findById(getInteger());
        System.out.println("Обновить логин: \n1-да\nаргумент-нет");
        if (getInteger() == 1) {
            System.out.println("Введите логин:");
            while (true) {
                String login = getString();
                if (login.length() >= 5) {
                    if (filter(i -> !(i.getLogin().equals(login)))) {
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
        }

        System.out.println("Обновить пароль: \n1-да\nаргумент-нет");
        if (getInteger() == 1) {
            System.out.println("Введите пароль:");
            while (true) {
                String passwords = getString();
                if (passwords.length() >= 5) {
                    password.setPassword(passwords);
                    System.out.println("Сохранён.");
                    break;
                } else {
                    System.out.println("Пароль дольжен больше или равно из 5 символов.");
                }
            }
        }

        System.out.println("Обновить фамилию: \n1-да\nаргумент-нет");
        if (getInteger() == 1) {
            System.out.println("Введите фамилию:");
            password.setFirstName(getString());
            System.out.println("Сохранён.");
        }

        System.out.println("Обновить имя: \n1-да\nаргумент-нет");
        if (getInteger() == 1) {
            System.out.println("Введит имя:");
            password.setSecondName(getString());
            System.out.println("Сохранён.");
        }

        System.out.println("Обновить емаил: \n1-да\nаргумент-нет");
        if (getInteger() == 1) {
            System.out.println("Введите емаил:");
            while (true) {
                String email = getString();
                String[] a = email.split("");
                boolean result = false;
                for (String s : a) {
                    if (s.equals("@")) {
                        result = true;
                        break;
                    }
                }
                if (result) {
                    password.setEmail(email);
                    System.out.println("Сохранён.");
                    break;
                } else {
                    System.out.println("Имя дольжено больше или равно из 5 символов.");
                }
            }
        }
    }
    @Override
    public void findById() {
        System.out.println("Введите id для просмотра данного паспорта");
        System.out.println(passwordFile.findById(getInteger()));

    }
    @Override
    public void deleteById() {
        System.out.println("Введите id для удаления данного паспорта.");
        long id = getInteger();
        System.out.println(passwordFile.findById(id));
        passwordFile.deleteById(id);
        System.out.println("Удалён.");
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