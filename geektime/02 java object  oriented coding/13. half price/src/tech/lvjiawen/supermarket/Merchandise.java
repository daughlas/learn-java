package tech.lvjiawen.supermarket;

public class Merchandise {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    public void describe() {
        System.out.println("商品名字叫做" + name + "，id是" + id + "。 商品售价是" + soldPrice
                + "。商品进价是" + purchasePrice + "。商品库存量是" + count +
                "。销售一个的毛利润是" + (soldPrice - purchasePrice));
    }

    public double calculateProfit(){
        double profit = soldPrice - purchasePrice;
        if (profit <= 0) {
            return 0;
        }
        return profit;

    }

    public double buy(int countToBuy, boolean printLeft) {
        if (count < countToBuy) {
            System.out.println("商品库存不够");
            return -1;
        }
        System.out.println("商品单价为" + soldPrice);

        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;

        double totalCost = fullPriceCount * soldPrice + halfPriceCount * soldPrice / 2;
        count -= countToBuy;

        if (printLeft) {
            System.out.println("商品剩余库存为：" + count + "件");
        }

        return totalCost;
    }

    public double getCurrentCount(){
        return count;
    }

    public int getIntSoldPrice(){
        return (int) soldPrice;
    }
}
