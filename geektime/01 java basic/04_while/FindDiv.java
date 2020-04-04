/**
 * FindDiv
 */
public class FindDiv {

  public static void main(String[] args) {
    int n = 10;

    int dividend = 100;
    int divisor = 2000000000;

    int found = 0;
    String start = "从" + dividend + "开始";
    while (found < n) {
      if (dividend < 0) {
        System.out.println("被除数溢出，未找到足够的树，循环结束");
        break;
      }
      if (dividend % divisor == 0) {
        found++;
        System.out.println(dividend + "可以整出" + divisor + ',');
      }
      dividend++;
    }
    System.out.println(start + "共找到" + found + "个可以整除" + divisor + "的整数");

    System.out.println("do while");
    do {
      System.out.println("会执行一次");
    } while (false);
  }
}