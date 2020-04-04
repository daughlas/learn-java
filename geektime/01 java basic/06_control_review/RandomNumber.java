/**
 * RandomNumber
 */
import java.util.Scanner;
public class RandomNumber {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int rangeStart = 30;
    int rangeEnd = 90;
    double randNum = 0;

    // 要生成一个 > 0.5 的随机数，然后退出循环
    while (randNum < 0.5) {
      randNum = Math.random();
      System.out.println(randNum);
    }

    

    if (rangeStart < 0 || rangeEnd < 0) {
      System.out.println("开始和结束必须是正数:("+ rangeStart + ',' + rangeEnd + ')');
      return;
    }

    int mod = rangeEnd - rangeStart;
    if (mod <= 1) {
      System.out.println("非法的数字范围:("+ rangeStart + ',' + rangeEnd + ')');
      return;
    }
    int bigRandom = (int)(Math.random() * (rangeEnd * 100));
    System.out.println("mod="+mod+ "，bigRandom=" + bigRandom);
    
    int numberToGuess = (bigRandom % mod) + rangeStart;
    if(numberToGuess <= rangeStart) {
      numberToGuess = rangeStart + 1;
    } else if (numberToGuess > rangeEnd) {
      numberToGuess = rangeEnd;
    }
    System.out.println("numberToGuess="+numberToGuess);

    
  }
}