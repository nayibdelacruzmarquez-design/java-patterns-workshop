package org.checkout.patterns.workshop.strategy;

/**
 * Interfaz base para el patrón Strategy de descuentos.
 * Permite cambiar el algoritmo de cálculo de precio dinámicamente.
 */
public interface DiscountStrategy {
    /**
     * Calcula el monto final aplicando el descuento correspondiente.
     *
     * @param amount Monto original de la orden.
     * @return Monto con el descuento aplicado.
     */
    double applyDiscount(double amount);
}