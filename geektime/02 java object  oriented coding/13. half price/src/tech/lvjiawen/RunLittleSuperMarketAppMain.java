package tech.lvjiawen;
import java.util.*;

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
        littleSuperMarket.getBiggestProfitMerchandise().describe();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("今日超时大特惠，所有第二件商品半价！选择要购买的商品索引：");
            int index = scanner.nextInt();

            if (index < 0) {
                System.out.println("欢迎再次光临");
                break;
            }
            if (index >= all.length) {
                System.out.println("索引超出界限，请重新选择");
                continue;
            }

            Merchandise m = all[index];
            System.out.println("请问你要买几个？");

            int numToBuy = scanner.nextInt();

            double totalCost = m.buy(numToBuy, true);

            System.out.println("选购的商品总价为" + totalCost);
        }




    }
}
