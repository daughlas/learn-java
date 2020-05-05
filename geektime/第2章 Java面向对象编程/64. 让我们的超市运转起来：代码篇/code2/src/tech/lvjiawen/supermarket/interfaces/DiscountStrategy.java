package tech.lvjiawen.supermarket.interfaces;

// >> TODO 某一个中类的商品，满多少减多少
// >> TODO 某一个中类的商品，第二件半价

/**
 * 超市折扣策略
 */
public interface DiscountStrategy {

    /**
     *
     * @param shoppingCart 购物车
     * @return 因为次折扣策略所折扣的钱，注意并非折扣总价格
     */
    double discount(ShoppingCart shoppingCart);
}
