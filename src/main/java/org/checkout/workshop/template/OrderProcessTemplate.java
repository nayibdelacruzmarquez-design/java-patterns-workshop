package org.checkout.workshop.template;

/**
 * Clase Abstracta que define el 'esqueleto' del algoritmo de validación.
 */
public abstract class OrderProcessTemplate {

    /**
     * Template Method: Define el orden estricto de los pasos.
     * Es 'final' para que las subclases no puedan alterar el flujo.
     */
    public final void executeProcess() {
        checkStock();             // Paso común
        validateSpecificRules();  // PASO VARIABLE (Abstracto)
        calculateTaxes();         // Paso común
        readyToShip();            // Paso común
    }

    private void checkStock() {
        System.out.println("📦 [TEMPLATE]: Verificando existencias en almacén central.");
    }

    private void calculateTaxes() {
        System.out.println("💰 [TEMPLATE]: Aplicando impuestos de ley (IVA).");
    }

    private void readyToShip() {
        System.out.println("🚚 [TEMPLATE]: Orden aprobada y lista para logística.");
    }

    // Metodo que cada tipo de orden (Local/Delivery) debe personalizar
    protected abstract void validateSpecificRules();
}