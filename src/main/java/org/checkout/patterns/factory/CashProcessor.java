package org.checkout.patterns.factory;

/**
 * Implementación de pago en efectivo.
 * Sigue la interfaz PaymentProcessor para ser compatible con la Factory.
 */
public class CashProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("💵 [PAGO EN EFECTIVO]: Preparando recibo para cobro en caja.");
        System.out.println("✅ [PAGO EN EFECTIVO]: Transacción de $" + amount + " registrada como 'Pendiente de Cobro'.");
    }
}