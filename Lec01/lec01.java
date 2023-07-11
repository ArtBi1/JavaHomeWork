package lec01;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
public class lec01 {
  /*
   * В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида 
"Доброе утро, <Имя>!", если время от 05:00 до 11:59
"Добрый день, <Имя>!", если время от 12:00 до 17:59;
"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
"Доброй ночи, <Имя>!", если время от 23:00 до 4:59
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    LocalTime time = LocalTime.now();
    System.out.println("Write your name: ");
    String name = scanner.nextLine();
    int hour = time.getHour();
    if (hour >= 5 && hour < 12) {
      System.out.println("Доброе утро, " + name + "!");
    } else if (hour >= 12 && hour < 18){
      System.out.println("Добрый день, " + name + "!");
    } else if (hour >= 18 && hour < 23){
      System.out.println("Добрый вечер, " + name + "!");
    } else if (hour >= 23 && hour < 5){
      System.out.println("Доброй ночи, " + name + "!");
    }
    scanner.close();
  }
}