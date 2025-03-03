package by.epam.number.service;

import by.epam.number.file.NumberFile;

public class NumberServiceTaskB {
    private final NumberFile numberFile;

    public NumberServiceTaskB(NumberFile numberFile) {
        this.numberFile = numberFile;
    }

    public void taskB1() {
        System.out.println("1. Четные и нечетные числа.");
    }
    public void taskB2() {
        System.out.println("2. Наибольшее и наименьшее число.");
    }
    public void taskB3() {
        System.out.println("3. Числа, которые делятся на 3 или на 9.");
    }
    public void taskB4() {
        System.out.println("4. Числа, которые делятся на 5 и на 7.");
    }
    public void taskB5() {
        System.out.println("5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.");
    }
    public void taskB6() {
        System.out.println("6. Простые числа.");
    }
    public void taskB7() {
        System.out.println("7. Отсортированные числа в порядке возрастания и убывания.");
    }
    public void taskB8() {
        System.out.println("8. Числа в порядке убывания частоты встречаемости чисел.");
    }
    public void taskB9() {
        System.out.println("9. «Счастливые» числа.");
    }
    public void taskB10() {
        System.out.println("10. Числа-палиндромы, значения которых в прямом и обратном порядке совпадают.");
    }
    public void taskB11() {
        System.out.println("11. Элементы, которые равны полусумме соседних элементов.");
    }
}
