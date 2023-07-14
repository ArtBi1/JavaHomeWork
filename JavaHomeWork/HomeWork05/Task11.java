// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Task11 {
    private Map<String, List<String>> phoneBook;

    public Task11() {
        phoneBook = new HashMap<>(); // Создание HashMap для хранения телефонной книги
    }

    public void addContact(String name, String phoneNumber) {
        List<String> phoneNumbers = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        phoneBook.put(name, phoneNumbers); // Добавление в телефонную книгу
    }

    public List<String> getPhoneNumbers(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>()); // Получение списка телефонов по имени контакта
    }

    public static void main(String[] args) {
        Task11 phoneBook = new Task11(); // Создаем экземпляр
        Scanner scanner = new Scanner(System.in); // сканнер для чтения пользовательского ввода

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Найти телефоны по имени");
            System.out.println("3. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt(); // Читаем выбор пользователя

            if (choice == 1) {
                System.out.print("Введите имя контакта: ");
                String name = scanner.next(); // Читаем имя контакта
                System.out.print("Введите номер телефона: ");
                String phoneNumber = scanner.next(); // Читаем номер телефона
                phoneBook.addContact(name, phoneNumber); // Добавляем контакт в телефонную книгу
                System.out.println("Контакт успешно добавлен!");
            } else if (choice == 2) {
                System.out.print("Введите имя для поиска: ");
                String name = scanner.next(); // Читаем имя для поиска
                List<String> phoneNumbers = phoneBook.getPhoneNumbers(name); // Получаем список телефонов по имени контакта
                if (phoneNumbers.isEmpty()) {
                    System.out.println("Контакты с таким именем не найдены");
                } else {
                    System.out.println("Телефоны для контакта" + name + ":");
                    for (String phoneNumber : phoneNumbers) {
                        System.out.println(phoneNumber);
                    }
                }
            } else if (choice == 3) {
                System.out.println("Выход");
                break; // Выходим из цикла
            } else {
                System.out.println("Некорректный выбор");
            }
            System.out.println();
        }
    }
}
