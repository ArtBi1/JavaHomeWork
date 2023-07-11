// Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор

import java.util.LinkedList;
import java.util.Iterator;

public class Task10 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(5);
        list.add(10);
        list.add(10);
        list.add(20);

        int sum = calculate(list);
        System.out.println("Сумма всех элементов равна: " + sum);
    }

    public static int calculate(LinkedList<Integer> list) {
        Iterator<Integer> iterator = list.iterator(); // Получение итератора для перебора элементов списка
        int sum = 0;

        while (iterator.hasNext()) {
            int element = iterator.next(); // Получение текущего элемента
            sum += element; // Добавление элемента к сумме
        }

        return sum;
    }
}
