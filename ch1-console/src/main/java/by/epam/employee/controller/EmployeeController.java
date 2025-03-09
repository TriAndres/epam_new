package by.epam.employee.controller;

import by.epam.employee.file.EmployeeFile;
import by.epam.employee.service.EmployeeServiceTaskA6;
import by.epam.password.file.PasswordFile;

import static by.epam.password.file.PasswordFile.loadFromFile;

public class EmployeeController {
    private static final String file1 = "ch1-console\\src\\main\\java\\by\\epam\\employee\\file\\EmployeeFile.txt";
    private static final EmployeeFile employeeFile = EmployeeFile.loadFromFileEmployee(file1);
    private static final String file2 = "ch1-console\\src\\main\\java\\by\\epam\\password\\file\\PasswordFile.txt";
    private static final PasswordFile passwordFile = loadFromFile(file2);
    public static EmployeeServiceTaskA6 employeeServiceTaskA6() {
        return new EmployeeServiceTaskA6(employeeFile, passwordFile);
    }
}