package org.checkout.patterns.factory;

/**
 * Implementación del procesador de pagos para Tarjetas de Crédito.
 * Contiene la lógica específica para validar y realizar cargos a plásticos bancarios.
 */
public class CreditCardProcessor implements PaymentProcessor {

    /**
     * Procesa la transacción simulando una conexión con un gateway bancario.
     *
     * @param amount El monto total a cargar a la tarjeta.
     */
    @Override
    public void processPayment(double amount) {
        System.out.println("💳 Procesando pago de $" + amount + " con Tarjeta de Crédito/Débito.");
        System.out.println("Verificando fondos y validando CVV...");
    }
}