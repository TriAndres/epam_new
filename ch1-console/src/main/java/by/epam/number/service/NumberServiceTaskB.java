package by.epam.number.service;

import by.epam.number.file.NumberFile;
import by.epam.number.model.Number;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NumberServiceTaskB {
    private final NumberFile numberFile;

    public NumberServiceTaskB(NumberFile numberFile) {
        this.numberFile = numberFile;
    }

    public void taskB1() {
        System.out.println("1. Четные и нечетные числа.(id/num)");
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
        System.out.println("3. Числа, которые делятся на 3 или на 9.(id/num)");
        if (!numberFile.findAll().isEmpty()) {
            List<Number> list = numberFile.findAll().stream().filter(i -> i.getNum() % 3 == 0 || i.getNum() % 9 == 0).toList();
            taskBShow(list);
        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB4() {
        System.out.println("4. Числа, которые делятся на 5 и на 7.(id/num)");
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

        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB7() {
        System.out.println("7. Отсортированные числа в порядке возрастания и убывания.");
        if (!numberFile.findAll().isEmpty()) {

        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB8() {
        System.out.println("8. Числа в порядке убывания частоты встречаемости чисел.");
        if (!numberFile.findAll().isEmpty()) {

        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB9() {
        System.out.println("9. «Счастливые» числа.");
        if (!numberFile.findAll().isEmpty()) {

        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB10() {
        System.out.println("10. Числа-палиндромы, значения которых в прямом и обратном порядке совпадают.");
        if (!numberFile.findAll().isEmpty()) {

        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }

    public void taskB11() {
        System.out.println("11. Элементы, которые равны полусумме соседних элементов.");
        if (!numberFile.findAll().isEmpty()) {

        } else {
            System.out.println("Заполните список в меню цифр.");
        }
    }
}
