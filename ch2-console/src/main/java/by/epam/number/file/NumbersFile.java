package by.epam.number.file;

import by.epam.number.model.Numbers;
import by.epam.number.repository.NumbersRepositoryImpl;

import java.io.*;
import java.util.List;

public class NumbersFile extends NumbersRepositoryImpl {
    private final String file;

    public NumbersFile(String file) {
        this.file = file;
    }

    private void saveNumber() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Numbers num : findAll()) {
                writer.write(num.toString());
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Numbers> findAll() {
        return super.findAll();
    }

    @Override
    public Numbers save(Numbers number) {
        Numbers numbers = super.save(number);
        saveNumber();
        return numbers;
    }

    @Override
    public Numbers findById(long id) {
        Numbers numbers = super.findById(id);
        saveNumber();
        return numbers;
    }

    @Override
    public void deleteById(long id) {
        super.deleteById(id);
        saveNumber();
    }

    public static NumbersFile loadFromFile(String file) {
        NumbersFile numbersFile = new NumbersFile(file);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("/");
                numbersFile.save(
                        new Numbers(
                                Long.parseLong(row[0]),
                                Integer.parseInt(row[1])
                        )
                );
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return numbersFile;
    }
}