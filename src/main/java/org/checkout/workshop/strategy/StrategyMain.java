package org.checkout.workshop.strategy;

/**
 * Clase para probar de forma independiente el patrón Strategy.
 * Aquí verás cómo el mismo monto cambia según la estrategia elegida.
 */
public class StrategyMain {

    /**
     * Ejecuta la simulación de cálculo de descuentos.
     *
     * @param args Argumentos de consola.
     */
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE ESTRATEGIAS DE DESCUENTO ===\n");

        double carritoTotal = 1000.00;

        // Probamos con Cliente Nuevo
        DiscountStrategy nuevo = new NewCustomerDiscount();
        System.out.println("Precio para Cliente Nuevo (10% desc): $" + nuevo.applyDiscount(carritoTotal));

        // Probamos con Cliente Leal
        DiscountStrategy leal = new LoyalCustomerDiscount();
        System.out.println("Precio para Cliente Leal (20% desc): $" + leal.applyDiscount(carritoTotal));

        // Probamos sin descuento
        DiscountStrategy sinDesc = new NoDiscount();
        System.out.println("Precio sin descuento: $" + sinDesc.applyDiscount(carritoTotal));
    }
}