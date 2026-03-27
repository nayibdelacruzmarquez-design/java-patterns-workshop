package org.checkout.workshop.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * Clase principal que representa una Orden de Compra completa.
 * Aplica encapsulamiento y protección de datos mediante colecciones inmutables.
 */
@Getter
@ToString
@Builder
public class Order {
    private final String customerName;
    private final String customerEmail;
    private final String shippingAddress;
    private final String paymentMethod;
    private final List<OrderItem> items;

    /**
     * Proporciona una vista de solo lectura de los items para evitar modificaciones externas.
     *
     * @return Una lista no modificable de OrderItem.
     */
    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    /**
     * Suma los subtotales de todos los items en la orden.
     *
     * @return El monto total de la compra.
     */
    public double getTotal() {
        return items.stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
    }
}