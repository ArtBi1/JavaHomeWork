// 2) Вывести все простые числа от 1 до 1000

public class PrimeNumbers {
    public static void main(String[] args) {
        System.out.println("Простые числа от 1 до 1000:");
        for (int i = 2; i <= 1000; i++) { // От 2 до 1000
            if (Prime(i)) {  // Проверяем, является ли число простым
                System.out.print(i + "___");  // Вывод простых чисел, разделение можно сделать любое + + "; " напр.
            }
        }
    }

    
    public static boolean Prime(int number) {  // Метод для проверки, простое ли число
        if (number < 2) {  // Числа меньше 2 то они не простые
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {  // Тут квадрат корня через метод math sqrt
            if (number % i == 0) {  // Если число делится на i без остатка, то оно не простое
                return false;
            }
        }
        return true;  // Число является простым, если не было найдено делителей
    }
}