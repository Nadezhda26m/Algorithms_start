package hw.ex6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static hw.ex6.PersonalData.getInputData;
import static hw.ex6.WorkWithFiles.createFile;

// задание внизу
public class Ex6 {
    public static void main(String[] args) {
        boolean getNextData = true;
        String dirName = "database";
        try {
            new File(dirName).mkdir();
        } catch (SecurityException e) {
            System.out.println(e.getMessage());
        }
        boolean notCorrect;
        String[] data;
        while (getNextData) {
            notCorrect = true;
            data = null;
            // получаем данные
            boolean firstInput = true;
            while (notCorrect) {
                try {
                    data = getInputData(firstInput);
                    notCorrect = false;
                } catch (NoSuchFormatException e) {
                    firstInput = false;
                    System.out.println(e.getMessage() + "\nПовторите ввод\n");
                }
            }
            // записываем в файл
            try {
                createFile(data, dirName);
                System.out.println("Запись добавлена\n");;
            } catch (IOException e) {
                System.out.println("Ошибка создания файла\n");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage() + "\n");
            }

            System.out.println("Добавить еще запись?");
            if (!getChoice()) getNextData = false;
            System.out.println();
        }

        System.out.println("Работа завершена");
    }

    public static boolean getChoice() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Подтвердите действие (да / нет): ");
            String flag = scan.next();
            if (flag.equals("да") || flag.equals("yes")) return true;
            else if (flag.equals("нет") || flag.equals("no")) return false;
            System.out.println("Некорректные данные, повторите ввод");
        }
    }
}

/*
    Напишите приложение, которое будет запрашивать у пользователя следующие данные
    в произвольном порядке, разделенные пробелом:
    ФИО, дата рождения, номер телефона, пол

    Форматы данных:
    фамилия, имя, отчество - строки
    дата рождения - строка формата dd.mm.yyyy
    номер телефона - целое беззнаковое число без форматирования
    пол - символ латиницей f или m.

    Приложение должно проверить введенные данные по количеству. Если количество
    не совпадает с требуемым, вернуть код ошибки, обработать его и показать
    пользователю сообщение, что он ввел меньше или больше данных, чем требуется.

    Приложение должно попытаться распарсить полученные значения и выделить из них
    требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение,
    соответствующее типу проблемы. Можно использовать встроенные типы java или
    создать свои. Исключение должно быть корректно обработано, пользователю выведено
    сообщение с информацией, что именно неверно.

    Если всё введено и обработано верно, должен создаться файл с названием,
    равным фамилии, в него в одну строку должны записаться полученные данные, вида

    <Фамилия><Имя><Отчество><дата рождения><номер телефона><пол>

    Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

    Не забудьте закрыть соединение с файлом.

    При возникновении проблемы с чтением-записью в файл, исключение должно быть
    корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */
