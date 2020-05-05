package tech.lvjiawen.supermarket;

public interface Card {
    double processCardDiscount(
        double totalCost,
        double totalCostAfterDiscount,
        Customer customer,
        ShoppingCart shoppingCart
    );
}
