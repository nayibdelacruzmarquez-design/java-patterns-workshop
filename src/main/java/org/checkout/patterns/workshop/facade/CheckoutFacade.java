package org.checkout.patterns.workshop.facade;

import org.checkout.patterns.factory.PaymentFactory;
import org.checkout.patterns.factory.PaymentProcessor;
import org.checkout.patterns.workshop.decorator.LoggerPaymentDecorator;
import org.checkout.patterns.workshop.decorator.SuccessNotificationDecorator;
import org.checkout.patterns.workshop.model.Order;
import org.checkout.patterns.workshop.strategy.DiscountStrategy;

/**
 * Fachada principal que simplifica el flujo de compra para el cliente.
 * Orquesta la aplicación de descuentos, el registro de auditoría y el pago final.
 */
public class CheckoutFacade {

    /**
     * Metodo principal que ejecuta todo el proceso de Checkout.
     *
     * @param order    La orden construida previamente.
     * @param strategy La estrategia de descuento a aplicar.
     */
    public void placeOrder(Order order, DiscountStrategy strategy) {
        System.out.println("--- 🛒 [FACADE] Iniciando Proceso de Compra ---");

        // 1. Calcular el total con descuento usando Strategy
        double finalAmount = strategy.applyDiscount(order.getTotal());
        System.out.println("💰 Monto final calculado: $" + finalAmount);

        // 2. Obtener el procesador base desde la Factory (PayPal, Tarjeta, etc.)
        PaymentProcessor baseProcessor = PaymentFactory.getPaymentProcessor(order.getPaymentMethod());

        // 3. Aplicar Decoradores (Logging y Notificación)
        // Envolvemos el procesador original en capas de funcionalidad extra
        PaymentProcessor decoratedProcessor = new SuccessNotificationDecorator(
                new LoggerPaymentDecorator(baseProcessor)
        );

        // 4. Ejecutar el pago final a través del procesador decorado
        decoratedProcessor.processPayment(finalAmount);

        System.out.println("--- ✅ [FACADE] Orden Finalizada con Éxito ---");
    }
}