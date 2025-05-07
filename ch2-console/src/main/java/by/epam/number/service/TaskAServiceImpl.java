package by.epam.number.service;

import by.epam.number.file.NumbersFile;
import by.epam.number.model.Numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.epam.metods.console.Console.getDouble;

public class TaskAServiceImpl extends Task implements TaskAService {

    public TaskAServiceImpl(NumbersFile numbersFile) {
        super(numbersFile);
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
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
                    .sorted((a, b) -> a.getVarious() - b.getVarious())
                    .toList();
            result += nums1.getFirst().toString() + "\n";
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void taskA5() {
        String result;
        int lineSize = 10;
        try {
            if (numbersFile.findAll().isEmpty()) {
                throw new Exception("Заполните список.");
            }
            result = "5. Найти количество чисел, содержащих только четные цифры, а среди них —" +
                    "  количество чисел с равным числом четных и нечетных цифр.\n";
            show(numbersFile.findAll()
                            .stream()
                            .filter((i) -> {
                                        String[] line = String.valueOf(i.getNumbers()).split("");
                                        int sum1 = 0;
                                        int sum2 = 0;
                                        for (String s : line) {
                                            if (Integer.parseInt(s) % 2 == 0) {
                                                ++sum1;
                                            }
                                            if (Integer.parseInt(s) % 2 != 0) {
                                                ++sum2;
                                            }
                                        }
                                        return sum1 == sum2 && i.getNumbers() % 2 == 0;
                                    }
                            )
                            .toList()
                    , result, lineSize);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void taskA6() {
        String result;
        try {
            if (numbersFile.findAll().isEmpty()) {
                throw new Exception("Заполните список.");
            }
            result = "6. Найти число, цифры в котором идут в строгом порядке возрастания. Если" +
                    "  таких чисел несколько, найти первое из них.\n";
            List<Numbers> list = numbersFile.findAll()
                    .stream()
                    .filter((a) -> {
                                String[] line = String.valueOf(a.getNumbers()).split("");
                                for (int i = 0; i < line.length - 1; i++) {
                                    boolean flag = true;
                                    for (int j = 1; j < line.length; j++) {
                                        if (!(Integer.parseInt(line[i]) < Integer.parseInt(line[j]))) {
                                            flag = false;
                                            break;
                                        }
                                    }
                                    return flag;
                                }
                                return false;
                            }
                    )
                    .toList();
            if (!numbersFile.findAll().isEmpty()) {
                result += "Вывод: id/number/length\n";
                result += list.getFirst().getId() + "/" + list.getFirst().getNumbers() + "/" + String.valueOf(list.getFirst().getNumbers()).length() + "\n";
            } else {
                result += "Список пуст.\n";
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void taskA7() {
        String result;
        try {
            if (numbersFile.findAll().isEmpty()) {
                throw new Exception("Заполните список.");
            }
            result = "7. Найти число, состоящее только из различных цифр. Если таких чисел не-" +
                    "сколько, найти первое из них.\n";
            List<Numbers> list = numbersFile.findAll().stream()
                    .filter((a) -> {
                                String[] line = String.valueOf(a.getNumbers()).split("");
                                for (int i = 0; i < line.length - 1; i++) {
                                    int count = 0;
                                    for (int j = 0; j < line.length; j++) {
                                        if (Integer.parseInt(line[i]) == Integer.parseInt(line[j])) {
                                            count++;
                                            if (count > 1) {
                                                return false;
                                            }
                                        }
                                    }
                                    return true;
                                }
                                return false;
                            }
                    ).toList();
            if (!numbersFile.findAll().isEmpty()) {
                result += "Вывод: id/number/length\n";
                result += "\t" + list.getFirst().getId() + "/" + list.getFirst().getNumbers() + "/" + String.valueOf(list.getFirst().getNumbers()).length() + "\n";
            } else {
                result += "Список пуст.\n";
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void taskA8() {
        String result;
        try {
            if (numbersFile.findAll().isEmpty()) {
                throw new Exception("Заполните список.");
            }
            result = "8. Среди чисел найти число-палиндром. Если таких чисел больше одного," +
                    "  найти второе.\n";
            List<Numbers> list = numbersFile.findAll().stream()
                    .filter((a) -> {
                                String num1 = String.valueOf(a.getNumbers());
                                StringBuilder num2 = new StringBuilder(num1).reverse();
                                return num1.equalsIgnoreCase(num2.toString());
                            }
                    ).toList();
            if (list.size() > 1) {
                result += "Вывод: id/number/length\n";
                result += list.get(1).getId() + "/" + list.get(1).getNumbers() + "/" + String.valueOf(list.get(1).getNumbers()).length() + "\n";
            } else {
                result += "Список пуст.\n";
            }
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void taskA9() {
        String result;
        try {
            result = "9. Найти корни квадратного уравнения. Параметры уравнения передавать" +
                    " с командной строкой.\n";
            result += "ax^2 + bx + c = 0\n";
            System.out.println("Введите а (1):");
            double a = getDouble();
            System.out.println("Введите b (-8):");
            double b = getDouble();
            System.out.println("Введите c (15):");
            double c = getDouble();
            double D = b * b - (4 * a * c);
            if (D > 0) {
                double x1 = (-b - Math.sqrt(D)) / (2 * a);
                double x2 = (-b + Math.sqrt(D)) / (2 * a);
                result += "Корени уравнения: x1 = " + x1 + ", x2 = " + x2 + "\n";
            } else if (D == 0) {
                double x = -b / (2 * a);
                result += "Уравнение имеет единственный корень: x = " + x + "\n";
            } else {
                result += "Уравнение не имеет действительных корней!" + "\n";
            }
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