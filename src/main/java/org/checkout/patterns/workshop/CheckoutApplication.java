package org.checkout.patterns.workshop;

import org.checkout.patterns.workshop.command.OrderInvoker;
import org.checkout.patterns.workshop.command.PlaceOrderCommand;
import org.checkout.patterns.workshop.facade.CheckoutFacade;
import org.checkout.patterns.workshop.model.Order;
import org.checkout.patterns.workshop.model.OrderItem;
import org.checkout.patterns.workshop.singleton.AppConfiguration;
import org.checkout.patterns.workshop.strategy.DiscountStrategy;
import org.checkout.patterns.workshop.strategy.LoyalCustomerDiscount;
import org.checkout.patterns.workshop.strategy.NewCustomerDiscount;

import java.util.List;
import java.util.Scanner;

public class CheckoutApplication {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // 1. SINGLETON: Configuración global
        AppConfiguration config = AppConfiguration.getInstance();
        config.setBusinessName("Refaccionaria Nayib - Professional Systems");
        System.out.println("🔧 Bienvenido a: " + config.getBusinessName());
        System.out.println("========================================");

        // --- INTERACCIÓN CON EL USUARIO ---

        // Elección de Pago
        System.out.println("\n[1] Seleccione método de pago:");
        System.out.println("1. PAYPAL");
        System.out.println("2. CASH");
        System.out.println("3. EXTERNAL (Adapter)");
        System.out.print("Opción: ");
        int opPago = lector.nextInt();
        String metodoSeleccionado = switch (opPago) {
            case 1 -> "PAYPAL";
            case 3 -> "EXTERNAL";
            default -> "CASH";
        };

        // Elección de Descuento (Patrón Strategy)
        System.out.println("\n[2] Seleccione tipo de cliente:");
        System.out.println("1. Cliente Nuevo (Sin descuento)");
        System.out.println("2. Cliente Leal (15% descuento)");
        System.out.print("Opción: ");
        int opDesc = lector.nextInt();
        DiscountStrategy estrategiaSeleccionada = (opDesc == 2)
                ? new LoyalCustomerDiscount()
                : new NewCustomerDiscount();

        // 2. MODEL & LOMBOK BUILDER: Creamos la orden con tus elecciones
        Order myOrder = Order.builder()
                .customerName("Nayib")
                .customerEmail("nayib@ejemplo.com")
                .shippingAddress("Av. Reforma 123")
                .paymentMethod(metodoSeleccionado)
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

        // 4. COMMAND: Encolamos la petición usando las elecciones del teclado
        PlaceOrderCommand command = new PlaceOrderCommand(
                facade,
                myOrder,
                estrategiaSeleccionada
        );

        // 5. INVOKER: Procesa la cola
        OrderInvoker invoker = new OrderInvoker();
        invoker.takeOrder(command);

        System.out.println("\n⏳ [SISTEMA]: Procesando pedidos en cola...\n");
        invoker.processOrders();

        lector.close();
    }
}