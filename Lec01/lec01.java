// в консоли запостить время текущее и имя пользователя

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime time = LocalTime.now();
        System.out.println("Введите имя пользователя:");
        String name = scanner.nextLine();
        int hour = time.getHour();
        if (hour >= 5 && hour < 12){
            System.out.println("Доброе утро," + name + "!");
        } else if (hour >= 12 && hour < 18){
            System.out.println("Добрый день," + name + "!");
        } else if (hour >= 12 && hour < 18){
            System.out.println("Добрый вечер," + name + "!");
        } else {
            System.out.println("Доброй ночи," + name + "!");
        }
    }
}
