package hw;

import java.util.Scanner;

public class Ex2 {
    /*
    Реализуйте метод, который запрашивает у пользователя ввод дробного числа
    (типа float), и возвращает введенное значение. Ввод текста вместо числа
    не должно приводить к падению приложения, вместо этого, необходимо
    повторно запросить у пользователя ввод данных.
     */
    public static void main(String[] args) {
        float number = getFloatValue();
        System.out.println("number = " + number);
    }

    private static float getFloatValue() {
        while (true) {
            System.out.println("Введите дробное число (используйте для разделения точку)");
            Scanner scan = new Scanner(System.in);
            String line = scan.nextLine();
            if (line.matches("-[0-9]+||[0-9]+||-[0-9]+\\.[0-9]+||[0-9]+\\.[0-9]+")) {
                return Float.parseFloat(line);
            } else System.out.println("Неверный формат числа");
        }
    }
}
