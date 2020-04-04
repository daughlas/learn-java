package tech.lvjiawen.supermarket;

public class Merchandise {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;
    String madeIn;

    void describe() {
        double netIncome = soldPrice - purchasePrice;
        System.out.println("商品名字叫做" + name + "，id是" + id + "。 商品售价是" + soldPrice
                + "。商品进价是" + purchasePrice + "。商品库存量是" + count +
                "。销售一个的毛利润是" + netIncome + "。制造地为" + madeIn);
    }
}
