package by.epam.number.service;

import by.epam.number.file.NumberFile;
import by.epam.number.model.Number;

import java.util.*;

public class NumberServiceTaskB {
    private final NumberFile numberFile;

    public NumberServiceTaskB(NumberFile numberFile) {
        this.numberFile = numberFile;
    }

    public void taskB1() {
        System.out.println("1. Четные и нечетные числа.");
        if (!numberFile.findAll().isEmpty()) {
            System.out.println("Четные числа:");
            List<Number> list1 = numberFile.findAll().stream().filter(i -> i.getNum() % 2 == 0).toList();
            taskBShow(list1);

            System.out.println("Нечетные числа:");
            List<Number> list2 = numberFile.findAll().stream().filter(i -> i.getNum() % 2 != 0).toList();
            taskBShow(list2);
        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB2() {
        System.out.println("2. Наибольшее и наименьшее число.");
        if (!numberFile.findAll().isEmpty()) {
            Optional<Number> max = numberFile.findAll().stream().max(Comparator.comparing(Number::getNum));
            System.out.println("Наибольшее число: " + max);
            Optional<Number> min = numberFile.findAll().stream().min(Comparator.comparing(Number::getNum));
            System.out.println("Наименьшее число: " + min);
        } else {
            System.out.println("Заполните список в меню цифр.");
        }

    }

    public void taskB3() {
        System.out.println("3. Числа, которые делятся на 3 или на 9.");
        if (!numberFile.findAll().isEmpty()) {
            List<Number> list = numberFile.findAll().stream().filter(i -> i.getNum() % 3 == 0 || i.getNum() % 9 == 0).toList();
            taskBShow(list);
        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB4() {
        System.out.println("4. Числа, которые делятся на 5 и на 7.");
        if (!numberFile.findAll().isEmpty()) {
            List<Number> list = numberFile.findAll().stream().filter(i -> i.getNum() % 5 == 0 && i.getNum() % 7 == 0).toList();
            taskBShow(list);
        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB5() {
        System.out.println("5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.");
        if (!numberFile.findAll().isEmpty()) {
            List<Number> list = numberFile
                    .findAll()
                    .stream()
                    .filter(i -> {
                        String r = String.valueOf(i.getNum());
                        String[] line = r.split("");
                        if (line.length == 3) {
                            return (Integer.parseInt(line[0]) != Integer.parseInt(line[1]) &&
                                    Integer.parseInt(line[1]) != Integer.parseInt(line[2]) &&
                                    Integer.parseInt(line[2]) != Integer.parseInt(line[0]));
                        }
                        return false;
                    }).toList();
            taskBShow(list);
        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB6() {
        System.out.println("6. Простые числа.");
        if (!numberFile.findAll().isEmpty()) {
            List<Number> list = numberFile
                    .findAll()
                    .stream()
                    .filter(i -> {
                        for (int j = 2; j <=Math.sqrt(i.getNum()) ; j++) {
                            if (i.getNum() % j == 0) {
                                return false;
                            } else if (String.valueOf(i.getNum()).length() > 3) {
                                return false;
                            }
                        }
                        return true;
                    }).toList();
            taskBShow(list);
        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB7() {
        System.out.println("7. Отсортированные числа в порядке возрастания и убывания.");
        if (!numberFile.findAll().isEmpty()) {
            System.out.println("В порядке возрастания:");
            List<Number> list1 = numberFile
                    .findAll()
                    .stream()
                    .sorted((a, b) -> a.getNum() - b.getNum())
                    .toList();
            taskBShow(list1);
            System.out.println("\nВ порядке убывания:");
            List<Number> list2 = numberFile
                    .findAll()
                    .stream()
                    .sorted((a, b) -> b.getNum() - a.getNum())
                    .toList();
            taskBShow(list2);
        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB8() {
        System.out.println("8. Числа в порядке убывания частоты встречаемости чисел.");
        if (!numberFile.findAll().isEmpty()) {
            Map<Integer, Integer> map = new HashMap<>();
            for (Number numbers : numberFile.findAll()) {
                if (!map.containsKey(numbers.getNum())) {
                    map.put(numbers.getNum(), 1);
                } else {
                    map.put(numbers.getNum(), map.get(numbers.getNum()) + 1);
                }
            }
            map.entrySet().stream().sorted((a, b) -> b.getKey() - a.getKey()).forEach(System.out::println);
        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    /*
    Счастливым будет считаться такое число из цифр,
    в котором сумма левых цифр равна сумме правых,
    например: 457961:4+5+5=9+6+1=16.
     */
    public void taskB9() {
        System.out.println("9. «Счастливые» числа.(из 6 чисел)");
        if (!numberFile.findAll().isEmpty()) {
            List<Number> list = numberFile
                    .findAll()
                    .stream()
                    .filter(i -> {
                        int length = Integer.toString(i.getNum()).length();
                        String[] num = Integer.toString(i.getNum()).split("");
                        int left = length / 2;
                        int sum1 = 0;
                        int sum2 = 0;
                        for (int j = 1; j == left ; j++) {
                            sum1 += Integer.parseInt(num[j - 1]);
                        }
                        for (int j = 1; j == left ; j++) {
                            sum2 += Integer.parseInt(num[(j + left) - 1]);
                        }
                        return sum1 == sum2 && length % 2 == 0;
                    })
                    .toList();
            taskBShow(list);
        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB10() {
        System.out.println("10. Числа-палиндромы, значения которых в прямом и обратном порядке совпадают.");
        if (!numberFile.findAll().isEmpty()) {
            List<Number> list = numberFile
                    .findAll()
                    .stream()
                    .filter(i -> {
                        StringBuilder stringBuilder = new StringBuilder(Integer.toString(i.getNum()));
                        return Integer.toString(i.getNum()).contentEquals(stringBuilder.reverse());
                    }).toList();
            taskBShow(list);
        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB11() {
        System.out.println("11. Элементы, которые равны полусумме соседних элементов.");
        if (!numberFile.findAll().isEmpty()) {
            List<Number> list1 = numberFile.findAll();
            List<Number> list2 = new ArrayList<>();
            for (int i = 1; i < list1.size() - 1; i++) {
                if (list1.get(i).getNum() == (list1.get(i - 1).getNum() + list1.get(i + 1).getNum()) / 2) {
                    list2.add(new Number(list1.get(i).getId(), list1.get(i).getNum()));
                }
            }
            taskBShow(list2);
        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    private void taskBShow(List<Number> list) {
        int count = 0;
        int lineCount = 10;
        for (Number number : list) {
            //System.out.println(number.getId() + "/" + number.getNum() + "\t");
            System.out.println(number.getNum() + "\t");
            count++;
            if (count == lineCount) {
                System.out.println();
                count = 0;
            }
        }
    }
}
