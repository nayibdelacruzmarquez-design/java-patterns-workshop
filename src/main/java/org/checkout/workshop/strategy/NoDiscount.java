package org.checkout.workshop.strategy;

/**
 * Estrategia por defecto que no aplica ningún descuento al monto original.
 */
public class NoDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        // Simplemente devolvemos el monto tal cual
        return amount;
    }
}