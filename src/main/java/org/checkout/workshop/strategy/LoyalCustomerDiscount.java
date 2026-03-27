package org.checkout.workshop.strategy;

/**
 * Estrategia de descuento premium para clientes recurrentes.
 * Aplica una reducción del 20% sobre el total.
 */
public class LoyalCustomerDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.80;
    }
}
