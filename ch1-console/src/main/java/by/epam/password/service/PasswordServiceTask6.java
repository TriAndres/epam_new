package by.epam.password.service;

import by.epam.password.file.PasswordFile;
import by.epam.password.model.Password;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static by.epam.methods.Input.getInteger;
import static by.epam.methods.Input.getString;

public class PasswordServiceTask6 {
    private final PasswordFile passwordFile;

    public PasswordServiceTask6(PasswordFile passwordFile) {
        this.passwordFile = passwordFile;
    }

    public void task() {
        System.out.println("6 Вывести фамилию разработчика, дату и время получения задания," +
                " а также дату и время сдачи задания.");
        if (!passwordFile.findAll().isEmpty()) {
            Password password = null;
            for (Password password1 : passwordFile.findAll()) {
                if (password1.getRegistration().equals(true)) {
                    password = password1;
                    break;
                }
            }


            System.out.println("Введите вашу фамилию:");
            String name = getString();
            LocalDateTime fromTime = LocalDateTime.now();
            String fromDate = fromTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            String fromTask = name + ", Вам задание, " + fromDate;
            System.out.println(fromTask);
            System.out.println("Через сколько дней решите:");
            long day = getInteger();
            LocalDateTime toTime = fromTime.plusDays(day);
            String toDate = toTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            String toTask = name + ", Вам дать задание в " + toDate;
            System.out.println(toTask);

            assert password != null;
            password.setName(name);
            passwordFile.save(password);
        }
    }
}