import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Collection;
import java.util.TreeMap;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FinalTask {

    static Logger logger;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        String fileName = "lap.txt"; // Указываем имя и путь к файлу с данными о ноутбуках
        String path = "C:\\GitGeekBrains\\JavaCourse\\JavaHomeWork\\HomeWork06\\";
     
        String filePath = path.trim() + fileName.trim();
   
        String[] filterParams = new String[10]; // Массив параметров фильтрации

        filterParams[0] = "Закончить"; // Задаем значения параметров фильтрации
        filterParams[1] = "Тип устройства";
        filterParams[2] = "Бренд";
        filterParams[3] = "Размер экрана";
        filterParams[4] = "Процессор";
        filterParams[5] = "Оперативная память[объём]";
        filterParams[6] = "Жесткий диск [объём]";
        filterParams[7] = "Тип жесткого диска";
        filterParams[8] = "Операционная система";
        filterParams[9] = "Цена";

        Set<Laptop> notebookSet = new HashSet<>(); // Множество ноутбуков

        createLogger();

        ArrayList<String> inputList = readFile(filePath); // Чтение данных из файла

        closeLogger();

        ArrayList<String> typeList = new ArrayList<>(); // Списки значений для каждого параметра фильтрации
        ArrayList<String> brandList = new ArrayList<>();
        ArrayList<String> screenSizeList = new ArrayList<>();
        ArrayList<String> cpuFamilyList = new ArrayList<>();
        ArrayList<String> memoryList = new ArrayList<>();
        ArrayList<String> storageSizeList = new ArrayList<>();
        ArrayList<String> storageTypeList = new ArrayList<>();
        ArrayList<String> osList = new ArrayList<>();
        ArrayList<String> costList = new ArrayList<>();

        for (String str: inputList){ // Обработка данных из файла и создание объектов ноутбуков
            String[] field = str.trim().split(";",0); 
            Laptop notebook = new Laptop(field[0], field[1], field[2], field[3], field[4], field[5], field[6], field[7], field[8], field[9]);
            notebookSet.add(notebook);

            if (!typeList.contains(field[1])){typeList.add(field[1]);} // Заполнение списков значений для каждого параметра фильтрации
            if (!brandList.contains(field[0])){brandList.add(field[0]);}
            if (!screenSizeList.contains(field[3])){screenSizeList.add(field[3]);}
            if (!cpuFamilyList.contains(field[4])){cpuFamilyList.add(field[4]);}
            if (!memoryList.contains(field[5])){memoryList.add(field[5]);}
            if (!storageSizeList.contains(field[7])){storageSizeList.add(field[7]);}
            if (!storageTypeList.contains(field[6])){storageTypeList.add(field[6]);}
            if (!osList.contains(field[8])){osList.add(field[8]);}
            if (!costList.contains(field[9])){costList.add(field[9]);}
    
        }

        Map<String,List<String>> dictionary = new TreeMap<>(); // Создание словаря с параметрами фильтрации
        dictionary.put(filterParams[1], typeList);
        dictionary.put(filterParams[2], brandList);
        dictionary.put(filterParams[3], screenSizeList);
        dictionary.put(filterParams[4], cpuFamilyList);
        dictionary.put(filterParams[5], memoryList);
        dictionary.put(filterParams[6], storageSizeList);
        dictionary.put(filterParams[7], storageTypeList);
        dictionary.put(filterParams[8], osList);
        dictionary.put(filterParams[9], costList);

        Map<String, String> selectedNotebook = new TreeMap<>(); // Получение выбранных пользователем параметров фильтрации
        selectedNotebook = getFilterParams(dictionary, filterParams);
        scanner.close();


        List<Laptop> result = new ArrayList<>();
        boolean addRecord = false;

        for (Laptop notebook: notebookSet){ // Фильтрация ноутбуков согласно выбранным параметрам
            boolean recordMatch = true;

            if (selectedNotebook.isEmpty()){
                    recordMatch = true;
                    addRecord = true;
            } else {
                if (selectedNotebook.get(filterParams[9]) != null && notebook.getCost() >= Integer.valueOf(selectedNotebook.get(filterParams[9]))) {
                    addRecord = true;
                } else if(selectedNotebook.get(filterParams[9]) != null) {
                    recordMatch = false;
                }
                if (selectedNotebook.get(filterParams[2]) != null && notebook.getBrand().equals(selectedNotebook.get(filterParams[2]))) {
                    addRecord = true;
                } else if (selectedNotebook.get(filterParams[2]) != null){
                    recordMatch = false;
                }

                if (notebook.getCpuFamily().equals(selectedNotebook.get(filterParams[4]))){
                    addRecord = true;
                } else if (selectedNotebook.get(filterParams[4]) != null){
                    recordMatch = false;
                }
                if (notebook.getMemory().equals(selectedNotebook.get(filterParams[5]))){
                    addRecord = true;
                } else if (selectedNotebook.get(filterParams[5]) != null){
                    recordMatch = false;
                }
                if (notebook.getScreenSize().equals(selectedNotebook.get(filterParams[3]))){
                    addRecord = true;
                } else if (selectedNotebook.get(filterParams[3]) != null){
                    recordMatch = false;
                }
                if (notebook.getStorageSize().equals(selectedNotebook.get(filterParams[6]))){
                    addRecord = true;
                } else if (selectedNotebook.get(filterParams[6]) != null){
                    recordMatch = false;
                }
                if (notebook.getStorageType().equals(selectedNotebook.get(filterParams[7]))){
                    addRecord = true;
                } else if (selectedNotebook.get(filterParams[7]) != null){
                    recordMatch = false;
                }
                if (notebook.getOs().equals(selectedNotebook.get(filterParams[8]))){
                    addRecord = true;
                } else if (selectedNotebook.get(filterParams[8]) != null){
                    recordMatch = false;
                }
            }

            if (addRecord && recordMatch){
                result.add(notebook); // Добавляем текущий ноутбук в список результатов
                addRecord = false;  // Сбрасываем для следующей итерации
            }
        }

        if (result.isEmpty()) {
            System.out.println("Нет ни одного ноутбука с выбранными параметрами. Измените запрос");
        } else {
            for(int i = 0; i < result.size(); i++){
                System.out.println(result.get(i).toString().trim()); // Выводим информацию о каждом ноутбуке в результате
            }
        }

    }

    static Map<String, String> getFilterParams(Map<String,List<String>> dictionary, String[] filterParams){
        Map<String, String> result = new TreeMap<>(); // Создаем новый объект TreeMap для хранения результатов
        Boolean notResult = true; // определение продолжения цикла
        String input = ""; // Для хранения введенных пользователем данных

        while(notResult) {
            System.out.println("Введите номера полей для поиска по одному. Или 0 для окончания выбора");
            
            for (int i = 1; i < filterParams.length;i++){
                System.out.printf("%d. %s",i,filterParams[i]);
                if (result.get(filterParams[i]) != null){
                    System.out.printf(" (%s)",result.get(filterParams[i]));
                }
                System.out.println();
            }
            
            System.out.printf("0. %s\n",filterParams[0]);

            input = makeChoice(); // Получаем выбор пользователя

            if (input.trim().isEmpty() || input.trim().equals("0")){
                notResult = false; // Если введен 0 или пустая строка то завершаем цикл
            } else if (Integer.valueOf(input.trim()) < filterParams.length){
                String newChoice = getValue(filterParams[Integer.valueOf(input.trim())], dictionary);
                result.put(filterParams[Integer.valueOf(input.trim())], newChoice);
            }
        }

        return result; // Возвращаем собранные параметры фильтрации
    }

    public static String makeChoice(){
        System.out.print("Ваш выбор: ");
        String result = scanner.nextLine().trim(); // Считываем введенные пользователем данные и удаляем лишние пробелы
        return result; // Возвращаем выбор пользователя
    }

    static String getValue(String choice, Map<String,List<String>> dictionary){
        String result = ""; // Для хранения выбранного значения
        Boolean notResult = true; //Для определения продолжения цикла
        String input = ""; // Для хранения введенных пользователем данных
        List<String> values = dictionary.get(choice); // Получаем список значений для выбранного параметра

        while(notResult) {
            
            System.out.printf("Выберите %s или нажмите ENTER для возврата в основное меню\n", choice);

            for (int i = 0; i < values.size(); i++){
                System.out.printf("%d. %s\n", i+1, values.get(i)); // Вывод списка значений для выбора
            }
            
            input = makeChoice(); // Получаем выбор пользователя

            if (input.trim().isEmpty() || input.trim().equals("0")){
                notResult = false; // Если введен 0 или пустая строка, завершаем цикл
            } else if (Integer.valueOf(input.trim()) <= values.size()){
                result = values.get(Integer.valueOf(input.trim()) - 1); // Получаем выбранное значение из списка
                notResult = false; // Завершаем цикл
            }
        }

        return result; // Возвращаем выбранное значение
    }

    static List<String> getList(String choice, Map<String,List<String>> dictionary){
        System.out.println(dictionary.get(choice)); // Вывод списка значений для выбранного параметра

        return dictionary.get(choice); // Возвращаем список значений
    }

    static ArrayList<String> readFile(String filePath){

        File file = new File(filePath); // Создаем объект File для указанного пути
        ArrayList<String> result = new ArrayList<>(); // Создаем новый ArrayList для хранения результатов

        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()) {
                result.add(scanner.nextLine()); // Считываем строки из файла и добавляем их в список результатов
            }
            logger.info("Успешно открыт: " + filePath); // Записываем информацию в лог о успешном открытии файла
        } catch (Exception e) {
            System.out.println("Файл не открыт");
            logger.warning("Не удалось открыть файл: " + filePath); // Записываем информацию об ошибке в лог
            closeLogger();
            System.exit(0);
        }

        return result; // Возвращаем список строк из файла

    }

    static void createLogger(){

        logger = Logger.getAnonymousLogger() ; // Создаем анонимный логгер
        FileHandler logHandler = null;
        
        try {
            logHandler = new FileHandler("logers.log", true); // Создаем обработчик для записи логов в файл "logers.log"
            logger.addHandler(logHandler); // Добавляем обработчик к логгеру
        } catch (Exception e){
            e.printStackTrace();
        }

        SimpleFormatter logFormatter = new SimpleFormatter();
        if (logHandler != null) {
            logHandler.setFormatter(logFormatter); // Устанавливаем форматтер для форматирования записей лога
        }
    }

    static void closeLogger(){
        for (Handler logHandler: logger.getHandlers()){
            logHandler.close(); // Закрываем обработчики логгера
        }
    }
    
}
