package by.epam.number.file;

import by.epam.number.model.Number;
import by.epam.number.repository.NumberRepositoryImpl;

import java.io.*;
import java.util.List;

public class NumberFile extends NumberRepositoryImpl {
    private final String file;

    public NumberFile(String file) {
        this.file = file;
    }

    public void saveF() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for (Number number : findAll()) {
                writer.write(number.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Number> findAll() {
        return super.findAll();
    }

    @Override
    public Number save(Number number) {
        Number number1 = super.save(number);
        saveF();
        return number1;
    }

    @Override
    public Number findById(long id) {
        Number number = super.findById(id);
        saveF();
        return number;
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

    public static NumberFile loadFromFile(String file) {
        NumberFile numberFile = new NumberFile(file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                numberFile.save(
                        new Number(
                                Long.parseLong(row[0]),
                                Integer.parseInt(row[1])
                        )
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numberFile;
    }
}