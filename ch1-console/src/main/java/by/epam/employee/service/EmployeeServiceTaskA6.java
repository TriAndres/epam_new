package by.epam.employee.service;

import by.epam.employee.file.EmployeeFile;
import by.epam.employee.model.Employee;
import by.epam.password.file.PasswordFile;
import by.epam.password.model.Password;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static by.epam.methods.Input.getInteger;
import static by.epam.methods.Input.getString;

public class EmployeeServiceTaskA6 {
    private final EmployeeFile employeeFile;
    private final PasswordFile passwordFile;

    public EmployeeServiceTaskA6(EmployeeFile employeeFile, PasswordFile passwordFile) {
        this.employeeFile = employeeFile;
        this.passwordFile = passwordFile;
    }

    public void task() {
        long id = 0;
        for (Password password : passwordFile.findAll()) {
            if (password.getRegistration().equals(true)) {
                id = password.getEmployeeId();
            } else {
                id = getNextId();
            }
        }

        if (!employeeFile.findAll().contains(employeeFile.findById(id))) {
            System.out.println("Введите вашу фамилию:");
            String firstName = getString();
            System.out.println("Введите ваше имя:");
            String secondName = getString();
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            LocalDateTime localDateTime1 = LocalDateTime.now();
            String time1 = localDateTime1.format(formatter1);
            String timeFrom = firstName + ", вы получили задание в " + time1;
            System.out.println(timeFrom);

            System.out.println("Через сколько дней решите задачи?");
            int interval = getInteger();

            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy 10:00:00");
            LocalDateTime localDateTime2 = localDateTime1.plusDays(interval);
            String time2 = localDateTime2.format(formatter2);
            String timeTo = firstName + ", сдать работу в " + time2;
            System.out.println(timeTo);

            employeeFile.save(new Employee(id, firstName, secondName, timeFrom, timeTo));
            System.out.println("Записано.");
        } else {
            Employee employee = employeeFile.findById(id);
            System.out.println(employee.getTimeFrom() + "\n" + employee.getTimeTo());
        }

    }


    private long getNextId() {
        long currentMaxId = employeeFile
                .findAll()
                .stream()
                .mapToLong(Employee::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;

    }
}