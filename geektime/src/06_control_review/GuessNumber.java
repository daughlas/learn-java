/**
 * RandomNumber
 */
import java.util.Scanner;
public class GuessNumber {

  public static void main(String[] args) {
    // 创建 Scanner 从控制台读取输入
    Scanner in = new Scanner(System.in);

    // 游戏设置
    int rangeStart = 30;
    int rangeEnd = 80;
    int guessTotal = 5;

    // 游戏统计
    int totalGameCount = 0;
    int totalCorrectCount = 0;

    // 是否结束游戏
    boolean gameEnd = false;
    
    while(!gameEnd) {
      // 生成指定范围内的随机数
      
      int mod = rangeEnd - rangeStart;
      if (mod <= 1) {
        System.out.println("非法的数字范围:("+ rangeStart + ',' + rangeEnd + ')');
        return;
      }
      int bigRandom = (int)(Math.random() * (rangeEnd * 100)); 
      int numberToGuess = (bigRandom % mod) + rangeStart;
      if(numberToGuess <= rangeStart) {
        numberToGuess = rangeStart + 1;
      } else if (numberToGuess > rangeEnd) {
        numberToGuess = rangeEnd;
      }

      // 剩余的猜测次数
      int leftToGuess = guessTotal;

      boolean currentGameCounted = false;

      boolean correctGuess = false;
      System.out.println("请输入猜测的数字范围是("+rangeStart + "," + rangeEnd + ")，输入-1代表结束游戏");
      while(leftToGuess > 0) {
        System.out.println("剩余游戏次数：" + leftToGuess + "次");
        int guess = in.nextInt();
        if (guess < 0) {
          gameEnd = true;
          System.out.println("用户选择结束游戏");
          break;
        }
        if (!currentGameCounted) {
          totalGameCount++;
          currentGameCounted = true;
        }
        // 只要猜了，就要减
        leftToGuess--;
        if (guess > numberToGuess) {
          System.out.println("输入的数字" + guess + "比目标数字大");
        } else if (guess < numberToGuess) {
          System.out.println("输入的数字" + guess + "比目标数字小");
        } else {
          correctGuess = true;
          System.out.println("猜中了！就是" + guess);
          totalCorrectCount++;
          break;
        }
      }
      if (!correctGuess) {
        System.out.println("正确答案是：" + numberToGuess);
      }
      System.out.println("共进行了" +totalGameCount + "次游戏，其中猜中的次数为" + totalCorrectCount);
    }
  }
} 