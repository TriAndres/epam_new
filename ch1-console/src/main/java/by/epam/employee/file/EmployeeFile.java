package by.epam.employee.file;

import by.epam.employee.model.Employee;
import by.epam.employee.repository.EmployeeRepositoryImpl;

import java.io.*;
import java.util.List;

public class EmployeeFile extends EmployeeRepositoryImpl {
    private final String file;

    public EmployeeFile(String file) {
        this.file = file;
    }

    private void saveF() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Employee employee : findAll()) {
                writer.write(employee.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Employee> findAll() {
        return super.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        Employee employee1 = super.save(employee);
        saveF();
        return employee1;
    }

    @Override
    public Employee findById(long id) {
        Employee employee = super.findById(id);
        saveF();
        return employee;
    }

    @Override
    public void deleteById(long id) {
        saveF();
        super.deleteById(id);
    }

    @Override
    public void deleteAll() {
        saveF();
        super.deleteAll();
    }

    public static EmployeeFile loadFromFileEmployee(String file) {
        EmployeeFile employeeFile = new EmployeeFile(file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                employeeFile.save(
                        new Employee(
                              Long.parseLong(row[0]),
                                row[1],
                                row[2],
                                row[3],
                                row[4]
                        )
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employeeFile;
    }
}