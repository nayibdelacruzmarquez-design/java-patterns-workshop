package org.checkout.patterns.workshop;

import org.checkout.patterns.workshop.command.OrderInvoker;
import org.checkout.patterns.workshop.command.PlaceOrderCommand;
import org.checkout.patterns.workshop.facade.CheckoutFacade;
import org.checkout.patterns.workshop.model.Order;
import org.checkout.patterns.workshop.model.OrderItem;
import org.checkout.patterns.workshop.singleton.AppConfiguration;
import org.checkout.patterns.workshop.strategy.LoyalCustomerDiscount;

import java.util.List;

public class CheckoutApplication {
    public static void main(String[] args) {
        // 1. SINGLETON: Configuración global
        AppConfiguration config = AppConfiguration.getInstance();
        config.setBusinessName("Refaccionaria Nayib - Workshop");
        System.out.println("🔧 Bienvenido a: " + config.getBusinessName());

        // 2. MODEL & LOMBOK BUILDER: Creamos la orden con items
        // Nota: El total se calculará automáticamente como (2 * 500) = 1000
        Order myOrder = Order.builder()
                .customerName("Nayib")
                .customerEmail("nayib@ejemplo.com")
                .shippingAddress("Av. Reforma 123")
                .paymentMethod("PAYPAL") // Puedes cambiar a "CASH" o "EXTERNAL"
                .items(List.of(
                        OrderItem.builder()
                                .productName("Amortiguador Delantero")
                                .quantity(2)
                                .price(500.0)
                                .build()
                ))
                .build();

        // 3. FACADE: Nuestra interfaz simplificada
        CheckoutFacade facade = new CheckoutFacade();

        // 4. COMMAND: Encolamos la petición
        PlaceOrderCommand command = new PlaceOrderCommand(
                facade,
                myOrder,
                new LoyalCustomerDiscount()
        );

        // 5. INVOKER: Procesa la cola
        OrderInvoker invoker = new OrderInvoker();
        invoker.takeOrder(command);

        System.out.println("⏳ [SISTEMA]: Procesando pedidos en cola...\n");
        invoker.processOrders();
    }
}