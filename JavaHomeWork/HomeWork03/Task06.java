// Задан целочисленный список ArrayList. 
// Найти минимальное, максимальное и среднее арифметическое из этого списка. Collections.max()

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Task06 {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();
        
        // Генерация случайных чисел и добавление их в список
        for (int i = 0; i < 10; i++) {
            int val = rnd.nextInt(201) - 100; // Генерация чисел от -100 до 100
            numbers.add(val);
        }

        System.out.println("Первоначальный список: " + numbers);

        // Нахождение минимального и максимального значения методами из класса Collections мин и макс
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);

        int sum = 0; // Нахождение суммы и среднего арифметического
        for (int number : numbers) {
            sum += number;
        }
        double average = (double) sum / numbers.size();

        // Вывод результатов
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее арифметическое значение: " + average);
    }
}
