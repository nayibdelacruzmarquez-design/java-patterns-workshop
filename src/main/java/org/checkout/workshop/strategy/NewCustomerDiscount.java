package org.checkout.workshop.strategy;

/**
 * Estrategia de descuento para clientes que realizan su primera compra.
 * Aplica una reducción del 10% sobre el total.
 */
public class NewCustomerDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.90;
    }
}