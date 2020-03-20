/**
 * MultiDimensionArray
 */
public class MultiDimensionArray {

  public static void main(String[] args) {
    double[][] multiDimensionArr = new double[3][5];

    for (int i = 0; i< multiDimensionArr.length; i++) {
      String s = "[";
      for (int j = 0; j < multiDimensionArr[i].length; j++) {
        if (j == multiDimensionArr[i].length - 1) {
          s += multiDimensionArr[i][j] +"]";
        } else {
          s += multiDimensionArr[i][j] + ", ";
        }
        // System.out.println("multiDimensionArr["+ i + "]["+ j + "]=" + multiDimensionArr[i][j]);
      }
      System.out.println(s);
    }
  }
}