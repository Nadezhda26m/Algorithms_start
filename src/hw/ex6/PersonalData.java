package hw.ex6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PersonalData {

    public static String[] getInputData(boolean firstInput)
            throws NoSuchFormatException {
        Scanner scan = new Scanner(System.in);
        if (firstInput) {
            System.out.println("Введите данные одной строкой через пробел");
            System.out.println(":ФИО полностью (первая буква заглавная), " +
                    "дата рождения (dd.mm.yyyy), " +
                    "\n:номер телефона (только цифры), пол (f или m)");
        }
        System.out.println("Пример: Иванов Иван Иванович 20.02.1990 79101234567 m");
        String string = scan.nextLine();
        String[] data = string.split(" ");
        if (!isCorrectSize(checkCountData(data))) getInputData(false);
        int date = getDateIndex(data);
        int phone = getPhoneIndex(data);
        int gender = getGenderIndex(data);
        int name = getNameIndex(data, date, phone, gender);
        return new String[]{data[name], data[name + 1], data[name + 2],
                data[date], data[phone], data[gender]};
    }

    private static int checkCountData(String[] data) {
        for (int i = 0; i < data.length; i++)
            if (data[i].length() == 0) return -3;
        if (data.length < 6) return -1;
        if (data.length > 6) return -2;
        return 0;
    }

    private static boolean isCorrectSize(int errorNum) {
        if (errorNum == -1) {
            System.out.println("Данные не полные, повторите ввод согласно образцу\n");
            return false;
        }
        if (errorNum == -2) {
            System.out.println("Лишние данные, повторите ввод согласно образцу\n");
            return false;
        }
        if (errorNum == -3) {
            System.out.println("Лишние пробелы, повторите ввод\n");
            return false;
        }
        return true;
    }

    private static int getGenderIndex(String[] data) throws NoSuchFormatException {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals("f") || data[i].equals("m"))
                return i;
        }
        throw new NoSuchFormatException("Пол введен неверно");
    }

    private static int getDateIndex(String[] data) throws NoSuchFormatException {
        for (int i = 0; i < data.length; i++) {
            if (isCorrectDate(data[i]))
                return i;
        }
        throw new NoSuchFormatException("Дата рождения введена неверно");
    }

    private static boolean isCorrectDate(String checkDate) throws NoSuchFormatException{
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            formatter.setLenient(false);
            Date date = formatter.parse(checkDate);
            if (date.before(formatter.parse("01.01.1920"))) {
                throw new NoSuchFormatException("Введенная дата должна быть после 01.01.1920");
            }
            if (date.after(new Date())) {
                throw new NoSuchFormatException("Дата из будущего о_О");
            }
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static int getPhoneIndex(String[] data) throws NoSuchFormatException {
        for (int i = 0; i < data.length; i++) {
            if (data[i].length() == 11
                    && data[i].matches("[0-9]+")
                    && (data[i].charAt(0) == '7' || data[i].charAt(0) == '8')) {
                return i;
            }
        }
        throw new NoSuchFormatException("Номер телефона введен неверно");
    }

    private static int getNameIndex(String[] data, int date, int phone, int gender)
            throws NoSuchFormatException {
        int sum = 0;
        int nameStartIndex = -1;
        for (int i = 0; i < data.length; i++) {
            if (i != date && i != phone && i != gender) sum += 1;
            else sum = 0;
            if (sum == 3) {
                nameStartIndex = i - 2;
                break;
            }
        }
        if (nameStartIndex == -1) {
            throw new NoSuchFormatException("ФИО не найдено");
        }
        for (int i = nameStartIndex; i < nameStartIndex + 3; i++) {
            if (!data[i].matches("[А-Я][а-я]+")) {
                throw new NoSuchFormatException("ФИО введено неверно");
            }
        }
        return nameStartIndex;
    }
}
