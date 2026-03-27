package org.checkout.patterns.builder;

/**
 * Clase que orquesta la construcción de órdenes siguiendo recetas predefinidas.
 * Reduce la complejidad para el cliente final.
 */
public class OrderDirector {

    private OrderBuilder builder;

    /**
     * Constructor que recibe la implementación del builder a utilizar.
     *
     * @param builder Implementación de OrderBuilder.
     */
    public OrderDirector(OrderBuilder builder) {
        this.builder = builder;
    }

    /**
     * Construye una orden configurada para productos digitales.
     */
    public void buildDigitalOrder(String name, String email, String product, double price) {
        builder.reset()
                .setCustomerInfo(name, email)
                .setShippingAddress("DIGITAL_DELIVERY")
                .addItem(product, 1, price)
                .setPaymentMethod("PAYPAL");
    }
}