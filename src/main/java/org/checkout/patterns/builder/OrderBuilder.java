package org.checkout.patterns.builder;

import org.checkout.patterns.workshop.model.Order;

/**
 * Interfaz que define el contrato para la construcción de objetos Order.
 * Sigue el patrón Fluent API para encadenamiento de métodos.
 */
public interface OrderBuilder {

    /**
     * Reinicia el estado interno para comenzar una nueva construcción.
     */
    OrderBuilder reset();

    /**
     * Registra la información básica del cliente.
     */
    OrderBuilder setCustomerInfo(String name, String email);

    /**
     * Define la dirección de entrega del pedido.
     */
    OrderBuilder setShippingAddress(String address);

    /**
     * Agrega un producto a la lista de construcción.
     */
    OrderBuilder addItem(String productName, int quantity, double price);

    /**
     * Especifica el metodo de pago seleccionado.
     */
    OrderBuilder setPaymentMethod(String method);

    /**
     * Ensambla y retorna el objeto Order final.
     */
    Order build();
}
