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
        String s1 = parsestring(json);
        String filePath = "C:\\GitGeekBrains\\JavaCourse\\JavaHomeWork\\HomeWork02\\st.txt";
 System.out.println(s1);
        createLogger();

        writeToFile(s1, filePath);
        System.out.println(readInFile(filePath));

        closeLogger();
    }

    private static void closeLogger() {
        for (Handler handler: logger.getHandlers()){
            handler.close();
        }
    }

    private static void createLogger() {
        logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("C:\\GitGeekBrains\\JavaCourse\\JavaHomeWork\\HomeWork02\\ log.txt", true);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleFormatter formatter = new SimpleFormatter();
        if (fileHandler != null){
            fileHandler.setFormatter(formatter);
        }
    }

    static String readInFile(String filePath) {
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    static void writeToFile(String s1, String filePath) {

        try (FileWriter writer = new FileWriter(filePath, true)){
            writer.write(s1);
            writer.write("\n");
            writer.flush();
            logger.info("шалость удалась");
        } catch (Exception e){
            e.printStackTrace();
            logger.warning("печаль»");
        }
    }

    static String parsestring(String s) {
        s = s.replace("[","");
        s= s.replace("{","");
        s = s.replace("]","");
        s= s.replace("}","");
         s= s.replace(",","");
         s= s.replace("\""," ");
         s= s.replace("фамилия","\nСтудент");
        s= s.replace(":","");
         s= s.replace("оценка","получил"); 
        s= s.replace("предмет","по предмету"); 


         
         
        return s ;
}
}