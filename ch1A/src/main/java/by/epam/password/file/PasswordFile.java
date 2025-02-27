package by.epam.password.file;

import by.epam.password.model.Password;
import by.epam.password.repository.PasswordRepositoryImpl;

import java.io.*;
import java.util.List;

public class PasswordFile extends PasswordRepositoryImpl {
    private final String file;

    public PasswordFile(String file) {
        this.file = file;
    }

    public void saveF() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Password password : findAll()) {
                writer.write(password.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Password> findAll() {
        return super.findAll();
    }

    @Override
    public Password save(Password password) {
        Password password1 = super.save(password);
        saveF();
        return password1;
    }

    @Override
    public Password findById(long id) {
        Password password = super.findById(id);
        saveF();
        return password;
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
        saveF();
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
        saveF();
    }

    public static PasswordFile loadFromFile(String file) {
        PasswordFile passwordFile = new PasswordFile(file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");

                passwordFile.save(new Password(
                        Long.parseLong(row[0]),
                        row[1],
                        row[2],
                        Boolean.valueOf(row[3]),
                        row[4],
                        row[5],
                        Integer.parseInt(row[6])
                ));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return passwordFile;
    }
}