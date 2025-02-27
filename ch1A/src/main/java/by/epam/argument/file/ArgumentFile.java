package by.epam.argument.file;

import by.epam.argument.model.Argument;
import by.epam.argument.repository.ArgumentRepositoryImpl;

import java.io.*;
import java.util.List;

public class ArgumentFile extends ArgumentRepositoryImpl {
    private final String file;

    public ArgumentFile(String file) {
        this.file = file;
    }

    public void saveF() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Argument argument : findAll()) {
                writer.write(argument.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Argument> findAll() {
        return super.findAll();
    }

    @Override
    public Argument save(Argument argument) {
        Argument argument1 = super.save(argument);
        saveF();
        return argument1;
    }

    @Override
    public Argument findById(long id) {
        Argument argument = super.findById(id);
        saveF();
        return argument;
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

    public static ArgumentFile loadFromFile(String file) {
        ArgumentFile argumentFile = new ArgumentFile(file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                argumentFile.save(
                        new Argument(
                           Long.parseLong(row[0]),
                           row[1]
                        )
                );
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return argumentFile;
    }
}