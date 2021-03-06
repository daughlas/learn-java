package tech.lvjiawen.supermarket.impl;

import tech.lvjiawen.supermarket.interfaces.Category;
import tech.lvjiawen.supermarket.interfaces.Customer;
import tech.lvjiawen.supermarket.interfaces.ShoppingCart;

import static tech.lvjiawen.supermarket.util.ShoppingUtil.getRandomCategory;

public abstract class AbsCustomer implements Customer {

    private Category shouldBuy;
    private String custId;
    private double moneySpent;
    // 还能逛几类商品
    private int guangLeft = 0;
    // 逛 left 的初始值
    private int guangCount = 0;

    public static final int DEFAULT_GUANG_COUNT = 5;

    public AbsCustomer(String custId, Category shouldBuy, int guangCount) {
        this.shouldBuy = shouldBuy;
        this.custId = custId;
        this.guangCount = guangCount;
    }

    public AbsCustomer(String custId, Category shouldBuy) {
        this(custId, shouldBuy, DEFAULT_GUANG_COUNT);
    }

    public int getGuangCount() {
        return guangCount;
    }

    public void setGuangCount(int guangCount) {
        this.guangCount = guangCount;
    }

    @Override
    public String getCustId() {
        return custId;
    }

    @Override
    public void startShopping() {
        guangLeft = guangCount;
    }

    @Override
    public boolean wantToCheckout() {
        guangLeft--;
        return guangLeft <= 0;
    }

    @Override
    public double payFor(ShoppingCart shoppingCart, double totalCost) {
        // TODO 留给大家的思考题，买不起怎么办？
        moneySpent += totalCost;
        return totalCost;
    }

    public Category getShouldBuy() {
        return shouldBuy;
    }

    /**
     * 先看必须买的，没有必须买的就随便看看
     *
     * @return 想要购买的商品种类
     */
    @Override
    public Category chooseCategory() {
        // 有一次机会看需要买的东西
        if (guangLeft + 1 >= guangCount) {
            return shouldBuy;
        } else {
            return getRandomCategory();
        }
    }

    @Override
    public double getMoneySpent() {
        return moneySpent;
    }
}
