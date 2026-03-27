package org.checkout.patterns.builder;

import org.checkout.patterns.workshop.model.Order;
import org.checkout.patterns.workshop.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación estándar del constructor de órdenes.
 * Mantiene un estado temporal hasta que se invoca el método build.
 */
public class StandardOrderBuilder implements OrderBuilder {

    private String name;
    private String email;
    private String address;
    private String method;
    private List<OrderItem> items;

    public StandardOrderBuilder() {
        this.reset();
    }

    @Override
    public OrderBuilder reset() {
        this.name = "";
        this.email = "";
        this.address = "";
        this.method = "";
        this.items = new ArrayList<>();
        return this;
    }

    @Override
    public OrderBuilder setCustomerInfo(String name, String email) {
        this.name = name;
        this.email = email;
        return this;
    }

    @Override
    public OrderBuilder setShippingAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public OrderBuilder addItem(String productName, int quantity, double price) {
        this.items.add(OrderItem.builder()
                .productName(productName)
                .quantity(quantity)
                .price(price)
                .build());
        return this;
    }

    @Override
    public OrderBuilder setPaymentMethod(String method) {
        this.method = method;
        return this;
    }

    @Override
    public Order build() {
        return Order.builder()
                .customerName(this.name)
                .customerEmail(this.email)
                .shippingAddress(this.address)
                .paymentMethod(this.method)
                .items(this.items)
                .build();
    }
}