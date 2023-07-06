// Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями. 
// Вывести название каждой планеты и количество его повторений в списке. Collections.frequency(list, item)

import java.util.ArrayList;
import java.util.Collections;

public class Task07 {
    public static void main(String[] args) {
        ArrayList<String> planetList = new ArrayList<>(); // Создаю список для хранения названий планет

        // Добавляю названия планет в список
        planetList.add("Меркурий");
        planetList.add("Венера");
        planetList.add("Земля");
        planetList.add("Марс");
        planetList.add("Земля"); // Повторяющееся название (2)
        planetList.add("Юпитер");
        planetList.add("Сатурн");
        planetList.add("Уран");
        planetList.add("Сатурн"); // Повторяющееся название (2)
        planetList.add("Нептун");
        planetList.add("Уран"); // Повторяющееся название (2)
        planetList.add("Плутон");
        planetList.add("Марс"); // Повторяющееся название

        // Вывожу название каждой планеты и количество его повторений в списке
        for (String planet : planetList) {
            int frequency = Collections.frequency(planetList, planet); // Вычисление кол-ва повторений

            System.out.println(planet + ": " + frequency); // Вывести название планеты и количество повторений
        }
    }
}