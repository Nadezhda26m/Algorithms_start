package hw;

public class Ex4 {
    public static void main(String[] args){
        int a = 90;
        int b = 3;
        if (b == 0) System.out.println("Деление на 0!");
        else System.out.println(a / b);
        printSum(23, 234);
        int[] abc = {1, 2};
        if (abc == null) System.out.println("Массив не инициализирован!");
        else if (abc.length < 4)
            System.out.println("Индекс выходит за пределы размера массива!");
        else abc[3] = 9;
    }
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    /*
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }
    */

}
