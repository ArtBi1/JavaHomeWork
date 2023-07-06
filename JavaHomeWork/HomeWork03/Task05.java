// Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.Random;

public class Task05 {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Integer> list1 = new ArrayList<>();

        // Генерируем случайные числа и добавляем их в список
        for (int i = 0; i < 10; i++) {
            int val = rnd.nextInt(201) - 100; // Генерируем числа от -100 до 100
            list1.add(val);
        }

        System.out.printf("Первоначальный список: %s\n", list1);

        int i = 0;
        while (i < list1.size()) {
            if (list1.get(i) % 2 == 0) {
                list1.remove(i); // Удаление четного числа из списка
            } else {
                i++;
            }
        }

        System.out.printf("Измененный, без четных чисел: %s", list1);
    }
}