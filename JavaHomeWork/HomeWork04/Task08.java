// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список. 
// Постараться не обращаться к листу по индексам.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task08 {
    public static void main (String[] args) {
        // Создаю список
        List<String> list = new ArrayList<>();
        list.add("01");
        list.add("22");
        list.add("03");
        list.add("04");
        list.add("05");
        list.add("66");

        System.out.println("Исходный список: " + list); // Вывести начальный список на экран

        List<String> reversedList = reverseListAPI(list); // Перевернутый спсиок поместить в резервный список

        System.out.println("Перевернутый список: " + reversedList); // Тут вывести перевернутый список на экран
    }

    public static <T> List<T> reverseListAPI(List<T> list) {   // Метод для переворота
        List<T> reversedList = new ArrayList<>(list); // Новый список, копируя исходный

        Collections.reverse(reversedList); // Использую метод Collections.reverse() для переворота элементов исходного списка

        return reversedList;  // Вернуть изменённый список
    }
}
