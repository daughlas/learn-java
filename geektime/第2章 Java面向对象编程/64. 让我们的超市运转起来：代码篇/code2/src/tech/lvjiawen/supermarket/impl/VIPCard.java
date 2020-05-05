package tech.lvjiawen.supermarket.impl;

import tech.lvjiawen.supermarket.interfaces.Card;
import tech.lvjiawen.supermarket.interfaces.Customer;
import tech.lvjiawen.supermarket.interfaces.ShoppingCart;

public enum VIPCard implements Card {
    level10(1),
    level11(0.99),
    level12(0.95),
    level13(0.9),
    level14(0.85),
    level15(0.8);
    private double discount;

    VIPCard(double discount) {
        this.discount = discount;
    }


    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount, Customer customer, ShoppingCart shoppingCart) {
        return totalCostAfterDiscount * (1 - discount);
    }
}
