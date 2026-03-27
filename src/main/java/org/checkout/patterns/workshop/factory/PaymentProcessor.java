package org.checkout.patterns.workshop.factory;

/**
 * Contrato base para cualquier estrategia de pago en el sistema.
 */
public interface PaymentProcessor {
    /**
     * Ejecuta la lógica necesaria para cobrar el monto especificado.
     *
     * @param amount Cantidad total a cobrar.
     */
    void processPayment(double amount);
}