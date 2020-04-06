package tech.lvjiawen;

import tech.lvjiawen.supermarket.LittleSuperMarket;
import tech.lvjiawen.supermarket.Merchandise;

public class RunLittleSuperMarketAppMain {
    public static void main(String[] args) {
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        littleSuperMarket.superMarketName = "有家小超市";
        littleSuperMarket.address = "浦东新区世纪大道666号";
        littleSuperMarket.parkingCount = 100;
        littleSuperMarket.merchandises = new Merchandise[200];
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];

        Merchandise[] all = littleSuperMarket.merchandises;

        for (int i = 0; i < all.length; i++) {
            Merchandise m = new Merchandise();
            m.name = "商品" + i;
            m.count = 200;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = m.purchasePrice * (1 + Math.random());
            m.id = "ID" + i;
            all[i] = m;
        }

        System.out.println("下面请利润最高的商品自我介绍：");
        Merchandise m = littleSuperMarket.getBiggestProfitMerchandise();
        m.describe();

//        m.makeEnoughFor(900);
        System.out.println("调用makeEnoughForOneByOne");
        m.makeEnoughForOneByOne(900);
        m.describe();
    }
}
