/**
 * Example
 */
public class Example {

  public static void main(String[] args) {
    int n = 5;
    String str = n + "对应的中文数字是：";
    // if (n == 1) {
    //   str += "一";
    // } else if (n == 2) {
    //   str += "二";
    // } else if (n == 3) {
    //   str += "三";
    // } else {
    //   System.out.println("错误的输入");
    // }

    switch(n) {
      case 1:
        str += "一";
        break;
      case 2:
        str += "二";
        break;
      case 3:
        str += "三";
        break;
      default:
        System.out.println("错误的输入");
    }
    System.out.println(str);
  }
}