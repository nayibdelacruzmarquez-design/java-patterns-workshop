package org.checkout.patterns.workshop.observer;

/**
 * Interfaz que define el metodo de actualización para los observadores.
 */
public interface PaymentObserver {
    void update(double amount);
}