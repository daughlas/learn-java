/**
 * MaxScore
 */
public class MaxScore {

  public static void main(String[] args) {
    int Yuwen = 0;
    int Shuxue = 1;
    int Waiyu = 2;
    int Wuli = 3;
    int Huaxue = 4;
    int Shengwu = 5;

    int totalScoreCount = 6;
    double[] scores = new double[totalScoreCount];
    String[] scoreNames = new String[totalScoreCount];

    scoreNames[Yuwen] = "语文";
    scoreNames[Shuxue] = "数学";
    scoreNames[Waiyu] = "外语";
    scoreNames[Wuli] = "物理";
    scoreNames[Huaxue] = "化学";
    scoreNames[Shengwu] = "生物";

    for (int i = 0; i < scores.length; i++) {
      scores[i] = Math.random() * 100;
      System.out.println(scoreNames[i] + "的成绩是" +scores[i]);
    }

    double MaxScore = 0;
    int maxScoreIndex = -1;

    for (int i = 0; i < scores.length; i++) {
      if (MaxScore < scores[i]) {
        MaxScore = scores[i];
        maxScoreIndex = i;
      }
    }
    // bug 两个科目成绩相同的话就是一个玩完
    System.out.println("成绩最高的学科是：" + scoreNames[maxScoreIndex]+ "，其成绩是：" + MaxScore);
  }
}