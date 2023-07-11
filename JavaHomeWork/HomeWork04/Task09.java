// Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди, 
// dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.

import java.util.LinkedList;

public class UsingList<T> {
    private LinkedList<T> list;

    public UsingList() {
        list = new LinkedList<>(); // Создание LinkedList для реализации очереди
    }

    public void enqueue(T element) {
        list.add(element); // Добавление элемента в конец очереди
    }

    public T dequeue() {
        return list.removeFirst(); // Извлечение и удаление первого элемента из очереди
    }

    public T first() {
        return list.getFirst(); // Получение первого элемента очереди без удаления
    }

    public static void main(String[] args) {
        UsingList<Integer> list = new UsingList<>(); // Создание объекта очереди с типом Integer
        list.enqueue(10); // Добавление элементов в очередь
        list.enqueue(20);
        list.enqueue(30);

        System.out.println("Первый элемент: " + list.first()); // Вывод первого элемента
        System.out.println("Извлеченный элемент: " + list.dequeue()); // Извлечение и вывод элемента
        System.out.println("Извлеченный элемент: " + list.dequeue());
        System.out.println("Первый элемент: " + list.first()); // Вывод первого элемента
    }
}
