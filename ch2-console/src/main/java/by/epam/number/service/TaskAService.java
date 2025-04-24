package by.epam.number.service;

import by.epam.number.file.NumbersFile;
import by.epam.number.model.Numbers;

import java.util.*;

public class TaskAService extends Task {

    public TaskAService(NumbersFile numbersFile) {
        super(numbersFile);
    }

    public void taskA1() {
        String result;
        try {
            if (numbersFile.findAll().isEmpty()) {
                throw new Exception("Заполните список.");
            }
            List<Numbers> list = numbersFile.findAll()
                    .stream()
                    .sorted((a, b) -> a.getNumbers() - b.getNumbers())
                    .toList();

            result = "1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.\n";

            int min = list.getFirst().getNumbers();
            int minLength = String.valueOf(min).length();
            result += "min=" + min + " length=" + minLength + "\n";

            int max = list.getLast().getNumbers();
            int maxLength = String.valueOf(max).length();
            result += "max=" + max + " lemgth=" + maxLength + "\n";
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void taskA2() {
        String result;
        int lineSize = 10;
        try {
            if (numbersFile.findAll().isEmpty()) {
                throw new Exception("Заполните список.");
            }
            result = "2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.\n";
            result += "В порядке возрастания значений:\n";
            result += show(numbersFile.findAll().stream().sorted((a, b) -> a.getNumbers() - b.getNumbers()).toList(), result, lineSize);

            result += "\nВ порядке убывания значений:\n";
            result += show(numbersFile.findAll().stream().sorted((a, b) -> b.getNumbers() - a.getNumbers()).toList(), result, lineSize);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void taskA3() {
        String result;
        int lineSize = 10;
        try {
            if (numbersFile.findAll().isEmpty()) {
                throw new Exception("Заполните список.");
            }
            result = "3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.\n";
            int sum = numbersFile.findAll().stream().mapToInt(Numbers::getNumbers).sum();
            result += "Числа меньше средней:\n";
            result += show(numbersFile.findAll()
                            .stream()
                            .filter(i -> i.getNumbers() > sum / numbersFile.findAll().size())
                            .toList()
                    , result, lineSize);
            result += "\nЧисла больше средней:\n";
            result += show(numbersFile.findAll()
                            .stream()
                            .filter(i -> i.getNumbers() < sum / numbersFile.findAll().size())
                            .toList()
                    , result, lineSize);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void taskA4() {
        String result;
        try {
            if (numbersFile.findAll().isEmpty()) {
                throw new Exception("Заполните список.");
            }
            result = "4. Найти число, в котором число различных цифр минимально. Если таких " +
                    "чисел несколько, найти первое из них.(число из 6 цифр)\n";
            class Num {
                private final Long id;
                private final Integer num;
                private final Integer various;

                Num(Long id, Integer num, Integer various) {
                    this.id = id;
                    this.num = num;
                    this.various = various;
                }

                public Long getId() {
                    return id;
                }

                public Integer getNum() {
                    return num;
                }

                public Integer getVarious() {
                    return various;
                }

                @Override
                public String toString() {
                    return id + "/" + num + "/" + various;
                }
            }
            List<Num> nums = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (Numbers numbers : numbersFile.findAll()) {
                String[] line = String.valueOf(numbers.getNumbers()).split("");

                for (String s : line) {
                    if (!map.containsKey(Integer.parseInt(s))) {
                        map.put(Integer.parseInt(s), 1);
                    } else {
                        map.put(Integer.parseInt(s), map.get(Integer.parseInt(s)) + 1);
                    }
                }
                System.out.println(numbers.getNumbers());
                int count = 0;
                for (Integer value : map.values()) {
                    count++;
                }
                System.out.println(count);
                nums.add(new Num(numbers.getId(), numbers.getNumbers(), count));
                map.clear();
            }
            result += "id/number/various\n";
            int size = 6;
            List<Num> nums1 = nums
                    .stream()
                    .filter(i -> String.valueOf(i.getNum()).length() == size)
                    .sorted((a, b) -> b.getNum() - a.getNum())
                    .sorted((a,b) -> a.getVarious() - b.getVarious())
                    .toList();
            result += nums1.getFirst().toString() + "\n";
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String show(List<Numbers> list, String result, int lineSize) {
        int count = 0;
        result = "Вывод: number/length\n";
        for (Numbers numbers : list) {
            result += "\t" + numbers.getNumbers() + "/" + String.valueOf(numbers.getNumbers()).length();
            count++;
            if (count == lineSize) {
                result += "\n";
                count = 0;
            }
        }
        return result;
    }
}