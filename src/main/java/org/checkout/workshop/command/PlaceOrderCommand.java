package org.checkout.workshop.command;

import org.checkout.workshop.facade.CheckoutFacade;
import org.checkout.workshop.model.Order;
import org.checkout.workshop.strategy.DiscountStrategy;

/**
 * Comando concreto que encapsula la petición de procesar una orden.
 * Permite que la orden se ejecute en cualquier momento (ahora o después).
 */
public class PlaceOrderCommand implements Command {
    private CheckoutFacade facade;
    private Order order;
    private DiscountStrategy strategy;

    // El constructor guarda el estado necesario para la ejecución futura
    public PlaceOrderCommand(CheckoutFacade facade, Order order, DiscountStrategy strategy) {
        this.facade = facade;
        this.order = order;
        this.strategy = strategy;
    }

    @Override
    public void execute() {
        // Delega el trabajo real a la Fachada
        facade.placeOrder(order, strategy);
    }
}