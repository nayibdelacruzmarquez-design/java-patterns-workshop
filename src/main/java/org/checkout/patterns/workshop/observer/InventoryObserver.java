package org.checkout.patterns.workshop.observer;

public class InventoryObserver implements PaymentObserver {
    @Override
    public void update(double amount) {
        System.out.println("📦 [OBSERVER - STOCK]: Reduciendo existencias en la base de datos de refacciones.");
    }
}