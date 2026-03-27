package org.checkout.patterns.workshop.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Invocadora: Gestiona y dispara la ejecución de los comandos.
 * Puede almacenar una lista de comandos para ejecutarlos en lote (batch processing).
 */
public class OrderInvoker {
    // Lista para encolar pedidos (útil para sistemas asíncronos o reintentos)
    private List<Command> commandQueue = new ArrayList<>();

    /**
     * Registra un comando en la lista de espera.
     */
    public void takeOrder(Command command) {
        commandQueue.add(command);
    }

    /**
     * Recorre todos los comandos guardados y los ejecuta uno por uno.
     */
    public void processOrders() {
        System.out.println("🚀 [INVOKER]: Procesando cola de comandos...");
        for (Command command : commandQueue) {
            command.execute();
        }
        // Limpiamos la cola después de procesar
        commandQueue.clear();
    }
}
