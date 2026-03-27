package org.checkout.patterns.workshop.adapter;

import org.checkout.patterns.workshop.factory.PaymentProcessor;

/**
 * Adaptador que hace que el ExternalPaySDK sea compatible con
 * nuestra interfaz PaymentProcessor.
 */
public class ExternalPaymentAdapter implements PaymentProcessor {

    // Composición: El adaptador contiene una instancia del SDK real
    private final ExternalPaySDK externalSDK;

    public ExternalPaymentAdapter() {
        this.externalSDK = new ExternalPaySDK();
    }

    /**
     * Implementamos nuestro metodo estándar,
     * pero por dentro llamamos al metodo "extraño" del SDK.
     */
    @Override
    public void processPayment(double amount) {
        // Traducimos processPayment -> authorizeAmount
        externalSDK.authorizeAmount(amount);
    }
}