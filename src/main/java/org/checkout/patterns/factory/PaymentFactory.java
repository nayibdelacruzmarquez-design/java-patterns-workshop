package org.checkout.patterns.factory;

import org.checkout.patterns.workshop.adapter.ExternalPaymentAdapter;

/**
 * Fábrica encargada de instanciar el procesador de pago correcto.
 * Ahora incluye la integración con el patrón Adapter.
 */
public class PaymentFactory {

    /**
     * Retorna un procesador de pago basado en el tipo solicitado.
     *
     * @param type El metodo de pago (PAYPAL, CASH, EXTERNAL, etc.)
     * @return Una instancia que implementa PaymentProcessor.
     */
    public static PaymentProcessor getPaymentProcessor(String type) {
        if (type == null) {
            return null; // O podrías retornar un procesador por defecto
        }

        switch (type.toUpperCase()) {
            case "PAYPAL":
                return new PayPalProcessor();

            case "CASH":
                return new CashProcessor();

            // 🚀 INTEGRACIÓN CON ADAPTER:
            // Aquí usamos el adaptador para que el sistema crea que
            // el SDK externo es un PaymentProcessor normal.
            case "EXTERNAL":
                return new ExternalPaymentAdapter();

            default:
                throw new IllegalArgumentException("Método de pago no soportado: " + type);
        }
    }
}