package tech.lvjiawen.supermarket;

public class LittleSuperMarket {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public Merchandise[] merchandises;
    public int[] merchandiseSold;

    public Merchandise getBiggestProfitMerchandise() {
        Merchandise curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            Merchandise m = merchandises[i];
            if (curr == null) {
                curr = m;
                continue;
            }
            double currProfit = curr.calculateProfit();
            double newProfit = m.calculateProfit();
            if (currProfit < newProfit) {
                curr = m;
            }
        }
        return curr;
    }

}
