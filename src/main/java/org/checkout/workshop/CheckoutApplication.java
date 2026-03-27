package org.checkout.workshop;

import org.checkout.workshop.command.OrderInvoker;
import org.checkout.workshop.command.PlaceOrderCommand;
import org.checkout.workshop.facade.CheckoutFacade;
import org.checkout.workshop.model.Order;
import org.checkout.workshop.model.OrderItem;
import org.checkout.workshop.singleton.AppConfiguration;
import org.checkout.workshop.strategy.DiscountStrategy;
import org.checkout.workshop.strategy.LoyalCustomerDiscount;
import org.checkout.workshop.strategy.NewCustomerDiscount;

import java.util.List;
import java.util.Scanner;

public class CheckoutApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. SINGLETON: Configuración personalizada
        AppConfiguration config = AppConfiguration.getInstance();
        System.out.print("Nombre de la sucursal: ");
        config.setBusinessName(scanner.nextLine()); // Tú escribes el nombre del negocio

        System.out.println("\n🔧 Bienvenido a: " + config.getBusinessName());
        System.out.println("========================================");

        // --- DATOS DEL CLIENTE ---
        System.out.print("Nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        // --- DATOS DEL PRODUCTO ---
        System.out.print("Producto a comprar (ej. Amortiguador): ");
        String prodNombre = scanner.nextLine();
        System.out.print("Precio unitario: ");
        double precio = scanner.nextDouble();
        System.out.print("Cantidad: ");
        int cant = scanner.nextInt();

        // --- SELECCIÓN DE PATRONES (MÉTODO Y ESTRATEGIA) ---
        System.out.println("\n[PAGO] 1.PAYPAL, 2.CASH, 3.EXTERNAL:");
        int p = scanner.nextInt();
        String mPago = (p == 1) ? "PAYPAL" : (p == 3) ? "EXTERNAL" : "CASH";

        System.out.println("[DESCUENTO] 1.Nuevo, 2.Leal:");
        int d = scanner.nextInt();
        DiscountStrategy estrategia = (d == 2) ? new LoyalCustomerDiscount() : new NewCustomerDiscount();

        // 2. BUILDER: Construimos la orden con todo lo que escribiste
        Order myOrder = Order.builder()
                .customerName(nombreCliente)
                .customerEmail(nombreCliente.toLowerCase().replace(" ", "") + "@mail.com")
                .shippingAddress("Direccion General #1")
                .paymentMethod(mPago)
                .items(List.of(
                        OrderItem.builder()
                                .productName(prodNombre)
                                .quantity(cant)
                                .price(precio)
                                .build()
                ))
                .build();

        // 3. FACADE: Orquestador
        CheckoutFacade facade = new CheckoutFacade();

        // 4. COMMAND: Encolar
        PlaceOrderCommand command = new PlaceOrderCommand(facade, myOrder, estrategia);

        // 5. INVOKER: Procesar
        OrderInvoker invoker = new OrderInvoker();
        invoker.takeOrder(command);

        System.out.println("\n⏳ [SISTEMA]: Ejecutando comandos de venta...\n");
        invoker.processOrders();

        scanner.close();
    }
}