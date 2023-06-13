package hw;

public class Ex3 {
    public static void main(String[] args) {

        // try {
        //     int d = 0;
        //     double catchedRes1 = intArray[8] / d;
        //     System.out.println("catchedRes1 = " + catchedRes1);
        // } catch (ArithmeticException e) {
        //     System.out.println("Catching exception: " + e);
        // }

        double d = 0;
        int[] intArray = null;
        getResult(intArray, d);
        intArray = new int[2];
        getResult(intArray, d);
        intArray = new int[10];
        getResult(intArray, d);
        intArray = new int[]{0, 4, 5, 7, 9, 4, 6, 2, 4};
        getResult(intArray, d);
        System.out.println();

        d = 5;
        intArray = null;
        getResult(intArray, d);
        intArray = new int[2];
        getResult(intArray, d);
        intArray = new int[10];
        getResult(intArray, d);
        intArray = new int[]{0, 4, 5, 7, 9, 4, 6, 2, 4};
        getResult(intArray, d);
        System.out.println();

        try {
            double catchedRes1 = getResult2(intArray, d);
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (RuntimeException e) {
            System.out.println("Catching exception: " + e.getMessage());
        }
    }

    public static void getResult(int[] array, double d) {
        if (array == null) System.out.println("Catching exception: Массив не инициализирован");
        else if (array.length < 9) System.out.println("Catching exception: Короткий массив");
        else if (d == 0) System.out.println("Catching exception: Деление на 0");
        else {
            double catchedRes1 = array[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }
    }

    public static double getResult2(int[] array, double d) {
        if (array == null)
            throw new RuntimeException("Массив не инициализирован");
        else if (array.length < 9)
            throw new RuntimeException("Короткий массив");
        else if (d == 0)
            throw new RuntimeException("Деление на 0");
        else return array[8] / d;
    }
}
