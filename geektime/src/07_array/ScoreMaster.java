import java.util.Scanner;

/**
 * ScoreMaster
 */
public class ScoreMaster {

  public static void main(String[] args) {
    int Yuwen = 0;
    int Shuxue = 1;
    int Waiyu = 2;
    int Wuli = 3;
    int Huaxue = 4;
    int Shengwu = 5;

    int totalScoreCount = 6;
    String[] names = new String[totalScoreCount];

    names[Yuwen] = "语文";
    names[Shuxue] = "数学";
    names[Waiyu] = "外语";
    names[Wuli] = "物理";
    names[Huaxue] = "化学";
    names[Shengwu] = "生物";

    Scanner in = new Scanner(System.in);

    System.out.println("请问要保存你见的成绩");

    int yearToStore = in.nextInt();

    double[][] scores = new double[yearToStore][names.length];

    for (int i = 0; i < yearToStore; i++) {
      for (int j = 0; j < names.length; j++) {
        scores[i][j] = 80 + Math.random()*20;
      }
    }
  }
}