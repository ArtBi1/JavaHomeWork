// 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Создаем объект Scanner для чтения ввода пользователя
        System.out.print("Введите число n: ");
        int n = scanner.nextInt();  // Считываем число N nextInt'ом
        
        int triangleNumber = calcNumber(n);  // Метод для вычисления треугольного числа
        System.out.println("n-ое треугольное число: " + triangleNumber);
        
        long factorial = calcFactorial(n);  // Метод для вычисления факториала числа
        System.out.println("Факториал числа n: " + factorial);
    }
    
    public static int calcNumber(int n) { // Метод для вычисления треугольного числа
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;  // Сумма + текущее число
        }
        return sum;  // Возвращаем готовую треугольную сумму
    }
    
    public static long calcFactorial(int n) { // Метод для вычисления факториала
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;  // Множить текущее число на факториал
        }
        return factorial;  // Возвращаем готовый факториал
    }
}