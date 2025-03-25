package by.epam.password.file;

import by.epam.password.modell.Password;
import by.epam.password.repository.PasswordRepositoryImpl;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PasswordFile extends PasswordRepositoryImpl {
    private final String file;

    public PasswordFile(String file) {
        this.file = file;
    }

    private void saveP() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Password password : findAll()) {
                writer.write(password.toString());
                writer.write("\n");
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
        saveP();
        return password1;
    }

    @Override
    public Password findById(long id) {
        Password password = super.findById(id);
        saveP();
        return password;
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
        saveP();
    }

    public static PasswordFile loadFromFile(String file) {
        PasswordFile passwordFile = new PasswordFile(file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                passwordFile.save(
                        new Password(
                                Long.parseLong(row[0]),
                                row[1],
                                row[2],
                                row[3],
                                row[4],
                                row[5],
                                Boolean.parseBoolean(row[7]),
                                LocalDateTime.parse(row[8], DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm"))
                        )
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return passwordFile;
    }
}
