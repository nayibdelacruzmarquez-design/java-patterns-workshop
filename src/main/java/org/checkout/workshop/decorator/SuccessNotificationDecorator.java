package org.checkout.workshop.decorator;

import org.checkout.patterns.factory.PaymentProcessor;

/**
 * Decorador opcional que añade una notificación visual de éxito.
 */
public class SuccessNotificationDecorator extends PaymentDecorator {

    public SuccessNotificationDecorator(PaymentProcessor processor) {
        super(processor);
    }

    @Override
    public void processPayment(double amount) {
        super.processPayment(amount);
        // Añadimos una funcionalidad extra al final
        System.out.println("🎉 ... ¡Gracias por comprar tus refacciones con nosotros!");
    }
}