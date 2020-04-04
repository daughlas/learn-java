package com.lvjiawen;

import com.lvjiawen.person.Customer;
import com.lvjiawen.supermarket.Merchandise;
import com.lvjiawen.supermarket.LittleSuperMarket;

import java.util.Scanner;

public class RunLittleSuperMarketAppMain {
    public static void main(String[] args) {
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        littleSuperMarket.superMarketName = "带来快乐的超市";
        littleSuperMarket.address = "光明区天堂大道幸福小区123号";
        littleSuperMarket.parkingCount = 200;
        littleSuperMarket.merchandises = new Merchandise[200];
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];

        Merchandise[] all = littleSuperMarket.merchandises;

        for (int i = 0; i < all.length; i++) {
            Merchandise m = new Merchandise();
            m.count = 200;
            m.id = "ID" + i;
            m.name = "商品" + i + "号";
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = (1 + Math.random()) * 200;
            all[i] = m;
        }

        System.out.printf("超时开门啦！");

        boolean open = true;
        Scanner scanner = new Scanner(System.in);

        while(open) {
            System.out.println("本店叫做" + littleSuperMarket.superMarketName);
            System.out.println("本店地址" + littleSuperMarket.address);
            System.out.println("本店公有停车位" + littleSuperMarket.parkingCount);
            System.out.println("今天的营业额" + littleSuperMarket.incomingSum);
            System.out.println("公有商品" + littleSuperMarket.merchandises.length + "种");

            Customer customer = new Customer();
            customer.name = "顾客编号" + ((int)(Math.random() * 10000));
            customer.money = (1 + Math.random()) * 1000;
            customer.isDrivingCar = Math.random() > 0.5;

            if (customer.isDrivingCar) {
                if (littleSuperMarket.parkingCount > 0) {
                    System.out.println("欢迎 " + customer.name + "驾车而来。本店已经为您安排了车位，停车免费。车位编号为" + littleSuperMarket.parkingCount);
                    littleSuperMarket.parkingCount--;
                } else {
                    System.out.println("不好意思，本店车位已满。欢迎下次光临。");
                    continue;
                }
            } else {
                System.out.println("欢迎 " + customer.name + " 光临本店");
            }

            double totalCost = 0;

            while(true) {
                System.out.println("本店提供" + all.length + "种商品，欢迎选购。请输入商品编号");
                int index = scanner.nextInt();

                if (index < 0) {
                    break;
                }

                if (index >= all.length) {
                    System.out.println("本店没有这种商品，请输入序号在 0 到" + (all.length) + "之间的商品编号。");
                }

                Merchandise m = all[index];

                System.out.println("您选购的商品是：" + m.name + "，单价是" + m.soldPrice + "。请问您要购买多少个？");

                int numToBuy = scanner.nextInt();

                if (numToBuy < 0) {
                    System.out.println("不买看看也好，欢迎继续挑选");
                    continue;
                }

                if (numToBuy > m.count) {
                    System.out.println("本店此商品库存没有这么多，欢迎继续选购");
                    continue;
                }

                if (numToBuy * m.soldPrice + totalCost > customer.money) {
                    System.out.println("哎呀，钱不够了，欢迎继续选购");
                    continue;
                }

                totalCost = m.soldPrice * numToBuy;
                m.count -= numToBuy;
                littleSuperMarket.merchandiseSold[index] +=numToBuy;
            }

            customer.money -= totalCost;

            if (customer.isDrivingCar) {
                littleSuperMarket.parkingCount++;
            }

            System.out.println("顾客 " + customer.name + "共消费了" + totalCost + "元");

            littleSuperMarket.incomingSum += totalCost;

            System.out.println("还要继续营业吗？");
            open = scanner.nextBoolean();
        }

        System.out.println("超市关门了！");
        System.out.println("今天总的营业额为" + littleSuperMarket.incomingSum + "。营业情况如下：");

        for (int i = 0; i < littleSuperMarket.merchandiseSold.length; i++) {
            Merchandise m = all[i];
            int numSold = littleSuperMarket.merchandiseSold[i];
            if (numSold > 0) {
                double incoming = m.soldPrice * numSold;
                double netIncoming = (m.soldPrice - m.purchasePrice) * numSold;
                System.out.println(m.name + "售出了" + numSold + "个，销售额为：" + incoming + "，净利润为：" + netIncoming);

            }
        }
    }
}
