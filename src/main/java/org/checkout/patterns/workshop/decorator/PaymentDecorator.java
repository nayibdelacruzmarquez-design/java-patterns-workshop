package org.checkout.patterns.workshop.decorator;

import org.checkout.patterns.factory.PaymentProcessor;

/**
 * Clase base abstracta para todos los decoradores de pago.
 * Implementa PaymentProcessor para "hacerse pasar" por uno,
 * pero contiene una instancia real dentro para delegar el trabajo.
 */
public abstract class PaymentDecorator implements PaymentProcessor {

    protected final PaymentProcessor decoratedProcessor;

    /**
     * Constructor que recibe cualquier procesador (PayPal, CreditCard, etc.)
     *
     * @param processor El procesador que vamos a envolver.
     */
    public PaymentDecorator(PaymentProcessor processor) {
        this.decoratedProcessor = processor;
    }

    @Override
    public void processPayment(double amount) {
        // Por defecto, le pide al procesador interno que haga su trabajo
        this.decoratedProcessor.processPayment(amount);
    }
}