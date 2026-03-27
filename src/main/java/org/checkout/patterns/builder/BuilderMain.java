package org.checkout.patterns.builder;

import org.checkout.workshop.model.Order;

/**
 * Clase de prueba para el patrón de diseño Builder.
 * Esta clase demuestra cómo construir objetos complejos de forma manual
 * y mediante el uso de un Director para procesos automatizados.
 */
public class BuilderMain {

    /**
     * Punto de entrada para ejecutar las pruebas del patrón Builder.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("--- Iniciando Taller de Patrones: Builder --- \n");

        // 1. Instanciamos nuestro obrero (el Builder)
        // Se utiliza la interfaz para mantener el desacoplamiento
        OrderBuilder builder = new StandardOrderBuilder();

        /**
         * ESCENARIO A: Construcción Manual (Paso a paso)
         * Se aprovecha la Fluent API (return this) para encadenar los métodos
         * de configuración de la orden.
         */
        Order manualOrder = builder.reset()
                .setCustomerInfo("Nayib", "nayib@ejemplo.com")
                .setShippingAddress("Calle Principal 123, Veracruz")
                .addItem("Laptop Gaming", 1, 25000.00)
                .addItem("Mouse Pad", 2, 350.50)
                .setPaymentMethod("CREDIT_CARD")
                .build();

        System.out.println("Orden Manual Creada:");
        System.out.println(manualOrder);
        System.out.println("Total de la orden: $" + manualOrder.getTotal());
        System.out.println("--------------------------------------------\n");


        /**
         * ESCENARIO B: Usando al Director (Recetas predefinidas)
         * El Director abstrae la lógica de construcción para configuraciones comunes,
         * como en este caso una orden de productos digitales.
         */
        OrderDirector director = new OrderDirector(builder);

        // El director se encarga de llamar a los métodos del builder internamente
        director.buildDigitalOrder("Dani", "dani@ejemplo.com", "Curso Java Full Stack", 499.00);

        // El builder entrega el objeto final ya configurado por el director
        Order digitalOrder = builder.build();

        System.out.println("Orden Digital (vía Director) Creada:");
        System.out.println(digitalOrder);
        System.out.println("Total: $" + digitalOrder.getTotal());
    }
}