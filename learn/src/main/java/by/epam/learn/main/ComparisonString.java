package by.epam.learn.main;

public class ComparisonString {
    public static void main(String[] args) {
        String str1, str2;
        str1 = "Java";
        str2 = str1;
        System.out.println("comparison of references " + (str1 == str2));
        str2 = new String("Java");
        System.out.println("comparison of references " + (str1 == str2));
        System.out.println("comparison of value " + (str1.equals(str2)));
    }
}
