// 3) Реализовать простой калькулятор

import java.util.Scanner;

public class SimpleCalculator {
public static void main(String[] args) {

Scanner scanner = new Scanner(System.in); // Объект Scanner для чтения что ввел пользователь

System.out.print("Введите первое число: "); // Запрос первого числа
double num1 = scanner.nextDouble();

System.out.print("Введите второе число: "); // Запрос второго числа
double num2 = scanner.nextDouble();

System.out.print("Выберите операцию (+, -, *, /): "); // Запрос операции (плюс, минус, умн., дел.)
char operator = scanner.next().charAt(0);

double result; // Переменная для хранения результата


if (operator == '+') { // Запуск операции которую сказал пользователь
result = num1 + num2; // Сложение
} else if (operator == '-') {
result = num1 - num2; // Вычитание
} else if (operator == '*') {
result = num1 * num2; // Умножение
} else if (operator == '/') {
if (num2 != 0) { // Проверка второго числа (не равно 0)
result = num1 / num2; // Деление
} else {
System.out.println("Ошибка: Деление на ноль невозможно!"); // Вывод о делении на нуль
return; // Завершение программы
}
} else {
System.out.println("Ошибка: Некорректная операция!"); // Обработка некорректной операции
return; // Завершаем программу
    }

System.out.println("Результат: " + result); // Вывести результат

scanner.close(); // Закрыть Scanner
    }
}