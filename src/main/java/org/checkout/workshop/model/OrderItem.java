package org.checkout.workshop.model;

import lombok.Builder;
import lombok.Value;

/**
 * Representa un producto individual dentro de una orden de compra.
 * Utiliza la anotación @Value para garantizar la inmutabilidad de los datos.
 */
@Value
@Builder
public class OrderItem {
    String productName;
    int quantity;
    double price;

    /**
     * Calcula el subtotal del item multiplicando cantidad por precio.
     *
     * @return El costo total de este producto específico.
     */
    public double getSubtotal() {
        return quantity * price;
    }
}