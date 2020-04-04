import java.util.Scanner;

/**
 * UseVariable
 */
public class UseVariable {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int a;
    System.out.println("创建变量a，请输入一个整数");
    a = in.nextInt();
    System.out.println("给 a 赋值，a 的值为:" + a + "，请再次输入一个整数");
    a = in.nextInt();
    System.out.println("再次给 a 赋值，现在 a 的值为:" + a);

  }
}