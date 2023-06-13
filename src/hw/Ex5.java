package hw;

import java.util.Scanner;

public class Ex5 {
    /*
    Разработайте программу, которая выбросит Exception, когда пользователь
    вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки
    вводить нельзя. Далее запросить повторный ввод строки
     */
    public static void main(String[] args) {
        String s = "";
        boolean flag = true;
        while (flag) {
            try {
                s = getNotNullString();
                flag = false;
            } catch (NullPointerException e) {
                System.out.println("Пустые строки вводить нельзя. Попробуйте снова.");
            }
        }
        System.out.println("Ваша строка: {" + s + "}");
    }

    public static String getNotNullString() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите текст");
        String string = scan.nextLine();
        if (string.length() == 0)
            throw new NullPointerException("Пустая строка");
        return string;
    }
}
