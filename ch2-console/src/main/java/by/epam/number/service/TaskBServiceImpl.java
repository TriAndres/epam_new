package by.epam.number.service;

public class TaskBServiceImpl implements TaskBService {
    @Override
    public void taskB1() {
        String result;
        result = "1. Вывести на экран таблицу умножения.";
    }

    @Override
    public void taskB2() {
        String result;
        result = "2. Вывести элементы массива в обратном порядке.";
    }

    @Override
    public void taskB3() {
        String result;
        result = "3. Определить принадлежность некоторого значения k интервалам (n, m], [n,\n" +
                "   m), (n, m), [n, m].";
    }

    @Override
    public void taskB4() {
        String result;
        result = "4. Вывести на экран все числа от 1 до 100, которые делятся на 3 без остатка.";
    }

    @Override
    public void taskB5() {
        String result;
        result = "5. Сколько значащих нулей в двоичной записи числа 129?";
    }

    @Override
    public void taskB6() {
        String result;
        result = "6. В системе счисления с некоторым основанием десятичное число 81 запи-\n" +
                "   сывается в виде 100. Найти это основание.";
    }

    @Override
    public void taskB7() {
        String result;
        result = "7. Написать код программы, которая бы переводила числа из десятичной сис-\n" +
                "   темы счисления в любую другую.";
    }

    @Override
    public void taskB8() {
        String result;
        result = "8. Написать код программы, которая бы переводила числа одной любой сис-\n" +
                "   темы счисления в любую другую.";
    }

    @Override
    public void taskB9() {
        String result;
        result = "9. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствую-\n" +
                "   щего данному числу. Осуществить проверку корректности ввода чисел.";
    }
}
