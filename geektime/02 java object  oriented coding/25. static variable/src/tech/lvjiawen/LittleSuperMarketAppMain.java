package tech.lvjiawen;

import tech.lvjiawen.supermarket.*;
import static tech.lvjiawen.supermarket.Merchandise.*;

public class LittleSuperMarketAppMain {
    public static void main(String[] args) {
        Merchandise merchandise = new Merchandise
                ("书桌", "DESK9527", 40, 999.9, 500);

        merchandise.describe();

        // >> TODO 使用import static来引入一个静态变量，就可以直接用静态变量名访问了
        //    TODO import static也可以使用通配符*来引入一个类里所有静态变量
        System.out.println(DISCOUNT_FOR_VIP);
    }
}
