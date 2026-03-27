package org.checkout.patterns.workshop.factory;

/**
 * Clase de prueba para el patrón de diseño Factory Method.
 * Esta clase demuestra cómo obtener diferentes implementaciones de procesadores
 * de pago de forma dinámica, sin conocer las clases concretas.
 */
public class FactoryMain {

    /**
     * Punto de entrada para ejecutar las pruebas del patrón Factory.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("--- Iniciando Taller de Patrones: Factory Method --- \n");

        /** * Simulamos el total de una orden que fue generada previamente
         * mediante el patrón Builder.
         */
        double orderTotal = 25701.00;

        /**
         * ESCENARIO A: El usuario selecciona Tarjeta de Crédito.
         * La fábrica retorna una instancia de CreditCardProcessor.
         */
        System.out.println("Escenario A: Usuario selecciona Crédito");
        PaymentProcessor cardProcessor = PaymentFactory.getPaymentProcessor("CREDIT_CARD");
        cardProcessor.processPayment(orderTotal);

        System.out.println("--------------------------------------------\n");

        /**
         * ESCENARIO B: El usuario cambia de opinión y selecciona PayPal.
         * La fábrica retorna una instancia de PayPalProcessor bajo la misma interfaz.
         */
        System.out.println("Escenario B: Usuario selecciona PayPal");
        PaymentProcessor paypalProcessor = PaymentFactory.getPaymentProcessor("PAYPAL");
        paypalProcessor.processPayment(orderTotal);

        /**
         * ESCENARIO C: Manejo de errores y robustez del sistema.
         * Se valida que la fábrica responda correctamente ante métodos de pago no soportados.
         */
        try {
            System.out.println("\nEscenario C: Método no soportado");
            PaymentFactory.getPaymentProcessor("BITCOIN");
        } catch (IllegalArgumentException e) {
            System.out.println("⚠️ Error controlado por la Factory: " + e.getMessage());
        }
    }
}