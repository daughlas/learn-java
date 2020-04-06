package tech.lvjiawen;

import tech.lvjiawen.supermarket.LittleSuperMarket;
import tech.lvjiawen.supermarket.Merchandise;

public class RunLittleSupermarketAppMain {
    public static void main(String[] args) {
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        littleSuperMarket.init("有家小超市", "浦东新区世纪大道666号",
                100, 200, 200);

        System.out.println("打印全部商品:");
        littleSuperMarket.printAllGoods();

        System.out.println("下面请利润最高的商品自我介绍：");
        littleSuperMarket.getBiggestProfitMerchandise().describe();
    }
}
