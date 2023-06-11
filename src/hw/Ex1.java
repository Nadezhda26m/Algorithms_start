package hw;

import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {
        // 1
        Integer[][] array = new Integer[3][];
        array[0] = new Integer[4];
        array[1] = new Integer[8];
        getLength(array); // NullPointerException

        // 2
        String[] strings = new String[]{"1", "2", "з"};
        // convertToInt(strings); // NumberFormatException

        // 3
        // getResult(); // ArithmeticException

        // 4
        // try {
        //     int[] result;
        //     result = test(new int[5], new int[6]);
        //     // result = test(new int[3], new int[]{1, 5, 0});
        //     // result = test(new int[]{23, 56, 93, 58}, new int[]{34, 65, 17, 22});
        //     // result = test(new int[0], new int[0]);
        //     System.out.println("result array = " + Arrays.toString(result));
        // } catch (RuntimeException e) {
        //     System.out.println("Ошибка: " + e.getMessage());
        // }
    }

    // 1
    public static void getLength(Integer[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].length);
        }
    }

    // 2
    public static void convertToInt(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Число " + Integer.parseInt(array[i]));
        }
    }

    // 3
    public static void getResult() {
        String string = "234567891";
        for (int i = 0; i < string.length(); i++) {
            System.out.println(17 /
                    (41 % Integer.parseInt(String.valueOf(string.charAt(i)))));
        }
    }

    // 4
    public static int[] test(int[] array1, int[] array2) {
        if (array1.length != array2.length)
            throw new RuntimeException("Длины массивов не равны");
        int[] result = new int[array1.length];
        for (int i = 0; i < result.length; i++) {
            if (array2[i] == 0)
                throw new RuntimeException("Деление на 0");
            result[i] = array1[i] / array2[i];
        }
        return result;
    }
}
