package org.checkout.patterns.workshop.decorator;

import org.checkout.patterns.factory.PaymentProcessor;

/**
 * Decorador que añade una capa de Logging.
 * Registra eventos en la consola sin modificar la lógica de pago original.
 */
public class LoggerPaymentDecorator extends PaymentDecorator {

    public LoggerPaymentDecorator(PaymentProcessor processor) {
        super(processor);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("📝 [LOG]: Verificando estado del procesador...");
        System.out.println("📝 [LOG]: Iniciando transacción por $" + amount);

        // Llamada al objeto real (PayPal, Tarjeta, etc.)
        super.processPayment(amount);

        System.out.println("✅ [LOG]: Registro de auditoría completado.");
    }
}