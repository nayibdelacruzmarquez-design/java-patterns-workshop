package org.checkout.patterns.workshop.adapter;

/**
 * Clase que simula un SDK externo de pagos (por ejemplo, de un banco).
 * No podemos modificar este código porque es de un tercero.
 */
public class ExternalPaySDK {

    /**
     * El SDK usa su propio nombre de metodo y lógica.
     *
     * @param amount El monto a autorizar.
     */
    public void authorizeAmount(double amount) {
        System.out.println("🚀 [SDK EXTERNO] Autorizando transacción bancaria por: $" + amount);
        System.out.println("✅ [SDK EXTERNO] Transacción aprobada por el banco.");
    }
}