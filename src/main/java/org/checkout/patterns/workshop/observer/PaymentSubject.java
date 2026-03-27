package org.checkout.patterns.workshop.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Sujeto (Subject): Mantiene una lista de observadores y se encarga
 * de notificarles cuando el estado del pago cambia.
 */
public class PaymentSubject {
    private List<PaymentObserver> observers = new ArrayList<>();

    // Registra un nuevo interesado (ej. Email o Inventario)
    public void addObserver(PaymentObserver observer) {
        observers.add(observer);
    }

    // Notifica a todos los registrados recorriendo la lista
    public void notifyObservers(double amount) {
        for (PaymentObserver observer : observers) {
            observer.update(amount);
        }
    }
}
