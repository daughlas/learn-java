package tech.lvjiawen.supermarket;

public class MerchandiseDescAppMain {
    public static void main(String[] args) {
        Merchandise merchandise = new Merchandise();

        merchandise.name = "书桌";
        merchandise.soldPrice = 999.9;
        merchandise.purchasePrice = 500;
        merchandise.count = 40;
        merchandise.id = "DESK9527";
        merchandise.madeIn = "China";

        merchandise.describe();

    }
}
