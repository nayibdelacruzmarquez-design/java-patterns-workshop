package org.checkout.patterns.factory;

/**
 * Implementación del procesador de pagos a través de la plataforma PayPal.
 * Gestiona la redirección y autenticación mediante tokens digitales.
 */
public class PayPalProcessor implements PaymentProcessor {

    /**
     * Ejecuta el flujo de pago digital mediante la API de PayPal.
     *
     * @param amount El monto total de la orden.
     */
    @Override
    public void processPayment(double amount) {
        System.out.println("🅿️ Redirigiendo a la pasarela de PayPal para pago de $" + amount);
        System.out.println("Autenticando cuenta y procesando token de seguridad...");
    }
}