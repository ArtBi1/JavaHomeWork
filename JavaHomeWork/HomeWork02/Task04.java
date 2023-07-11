// *Получить исходную json строку из файла, используя FileReader или Scanner
// Дана json строка вида:
// String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
// "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
// "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

// Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// Используйте StringBuilder для подготовки ответа. Далее создайте метод, который запишет
// результат работы в файл. Обработайте исключения и запишите ошибки в лог файл с помощью Logger.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task04 {
   
    static Logger logger;

    public static void main(String[] args) {
        String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
"{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
"{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        String string = parsestring(json); // Вызов функции parsestring(json) и присвоение результата переменной
        String filePath = "C:\\GitGeekBrains\\JavaCourse\\JavaHomeWork\\HomeWork02\\st.txt"; // Путь к файлу

        System.out.println(string); // Вывод содержимого переменной

        createLogger(); // Вызов функции createLogger()

        writeToFile(string, filePath); // запись строки string в файл по указанному пути
        System.out.println(readInFile(filePath)); // Вывод содержимого файла по указанному пути

        closeLogger(); // Вызов функции closeLogger()
    }

    private static void closeLogger() {
        for (Handler handler: logger.getHandlers()){
            handler.close(); // Закрыл
        }
    }

    private static void createLogger() {
        logger = Logger.getAnonymousLogger(); // Создание анонимного логгера
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("C:\\GitGeekBrains\\JavaCourse\\JavaHomeWork\\HomeWork02\\ log.txt", true); // Создание обработчика файлового журнала
            logger.addHandler(fileHandler); // Добавление обработчика в логгер
        } catch (IOException e) {
            e.printStackTrace(); // Вывод, если произошла ошибка
        }

        SimpleFormatter formatter = new SimpleFormatter();
        if (fileHandler != null){
            fileHandler.setFormatter(formatter); // Установка форматирования для обработчика файлового журнала
        }
    }

    static String readInFile(String filePath) {
        File file = new File(filePath); // Создание объекта файла
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                stringBuilder.append(scanner.nextLine()); // Чтение строк из файла и добавление их в стрингБилдер
                stringBuilder.append("\n"); // Добавление перевода строки
            }
        } catch (Exception e){
            e.printStackTrace(); // Вывод если ошибка
        }
        return stringBuilder.toString(); // Преобразование содержимого стрингБилдер в строку и возврат
    }

    static void writeToFile(String string, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)){
            writer.write(string); // Запись строки string в файл
            writer.write("\n"); // Запись перевода строки
            writer.flush(); // Сброс буфера записи
            logger.info("Успешно"); // Запись информации в лог
        } catch (Exception e){
            e.printStackTrace(); // Вывод если произошла ошибка
            logger.warning("Ошибка»"); // Запись предупреждения в лог
        }
    }

    static String parsestring(String s) {
        s = s.replace("[",""); // Удаление символа "["
        s= s.replace("{",""); // Удаление символа "{"
        s = s.replace("]",""); // Удаление символа "]"
        s= s.replace("}",""); // Удаление символа "}"
        s= s.replace(",",""); // Удаление символа ","
        s= s.replace("\""," "); // Удаление символа """
        s= s.replace("фамилия","\nСтудент"); // Замена подстроки "фамилия" на "\nСтудент"
        s= s.replace(":",""); // Удаление символа ":"
        s= s.replace("оценка","получил"); // Замена подстроки "оценка" на "получил"
        s= s.replace("предмет","по предмету"); // Замена подстроки "предмет" на "по предмету"

        return s; // Возврат измененной строки
    }
}