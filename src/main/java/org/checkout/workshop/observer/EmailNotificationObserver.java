package org.checkout.workshop.observer;

public class EmailNotificationObserver implements PaymentObserver {
    @Override
    public void update(double amount) {
        System.out.println("📧 [OBSERVER - EMAIL]: Enviando ticket de compra por $" + amount + " al cliente.");
    }
}