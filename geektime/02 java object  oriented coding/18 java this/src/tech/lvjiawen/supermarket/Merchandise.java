package tech.lvjiawen.supermarket;

public class Merchandise {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    public void describe() {
        System.out.println("商品名字叫做" + name + "，商品 ID 为 " + id + "。 售价 " + soldPrice
                + "。进价 " + purchasePrice + "。库存 " + count +
                "。毛利润 " + (soldPrice - purchasePrice));
    }

    public double calculateProfit() {
        return (soldPrice - purchasePrice);
    }

    public int getCount() {
        return count;
    }

    public boolean hasEnoughCountFor(int count) {
        return this.count >= count;
    }

    public void addCount(int count) {
        this.count += count;
    }

    public void makeEnoughFor(int count) {
        boolean hasEnough = hasEnoughCountFor(count);
        if (!hasEnough) {
            addCount(count - this.count);
        }
    }

    public void makeEnoughForOneByOne(int count) {
        boolean hasEnough = hasEnoughCountFor(count);
        if (!hasEnough) {
            addCount(1);
            makeEnoughForOneByOne(count);
        }
    }

}
