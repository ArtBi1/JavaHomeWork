package lec01;

import java.util.Arrays;
import java.util.Random;

public class lec02 {
  /*
   * Дан массив двоичных чисел, например [1,1,0,1,1,1], 
   * вывести максимальное количество подряд идущих 1.
   */
  public static void main(String[] args) {
    int[] arr = random(0,2,10);
    System.out.println(Arrays.toString(arr));;
    System.out.println(count(arr));
  }
  static int[] random(int min, int max, int capacity){
    int[] arr = new int[capacity];
    Random random = new Random();
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(min, max);
    }
    return arr;
  }
  static int count(int[] arr){
    int count = 0;
    int max_count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 1) {
        count += 1;
        if (max_count < count){
          max_count = count;
        }
      } else {
        count = 0;
      }
    }
    return max_count;
  }
}