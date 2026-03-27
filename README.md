# 🔧 Refaccionaria Nayib - Workshop de Patrones de Diseño

Este proyecto es una implementación práctica de los patrones de diseño más utilizados en la industria, aplicada a un
sistema de **Checkout y Gestión de Pedidos** para una refaccionaria. El objetivo es demostrar cómo transformar un código
monolítico con múltiples `if/else` en una arquitectura escalable, desacoplada y profesional.

## 🚀 Tecnologías Utilizadas

* **Java 17**
* **Lombok**: Para reducir el código repetitivo (Boilerplate) mediante `@Builder`, `@Getter` y `@Value`.
* **IntelliJ IDEA**: Entorno de desarrollo con optimización de código.

## 🏗️ Arquitectura y Patrones Aplicados

Siguiendo el "Caso Guía" del curso, el sistema se divide en las siguientes capas de diseño:

### 1. Patrones Creacionales (Instanciación)

* **Singleton (`AppConfiguration`)**: Garantiza una única instancia global para la configuración del negocio (nombre,
  impuestos, etc.).
* **Builder (Lombok `@Builder`)**: Implementado en las clases `Order` y `OrderItem` para una construcción de objetos
  clara y segura, evitando constructores sobrecargados.
* **Factory Method (`PaymentFactory`)**: Centraliza la lógica de creación de procesadores de pago (`PayPal`, `Cash`,
  `CreditCard`) basándose en el tipo solicitado.

### 2. Patrones Estructurales (Organización)

* **Facade (`CheckoutFacade`)**: Simplifica la interacción del sistema. El cliente solo llama a un método y la fachada
  coordina el descuento, el pago y las notificaciones.
* **Decorator (`LoggerPaymentDecorator`, `SuccessNotificationDecorator`)**: Permite añadir funcionalidades extra (como
  auditoría y alertas) de forma dinámica sin modificar las clases de pago originales.
* **Adapter (`ExternalPaymentAdapter`)**: Integra un SDK de terceros (`ExternalPaySDK`) que tiene métodos incompatibles,
  adaptándolo a nuestra interfaz estándar de pagos.

### 3. Patrones de Comportamiento (Interacción)

* **Strategy (`DiscountStrategy`)**: Permite intercambiar algoritmos de descuento (`LoyalCustomer`, `NewCustomer`,
  `NoDiscount`) en tiempo de ejecución.
* **Command (`PlaceOrderCommand`)**: Encapsula la solicitud de compra como un objeto, permitiendo su almacenamiento y
  ejecución posterior.
* **Invoker (`OrderInvoker`)**: Gestiona la cola de comandos, permitiendo procesar pedidos de forma organizada.

## 🛠️ Cómo ejecutar el proyecto

1. Abre el proyecto en **IntelliJ IDEA**.
2. Asegúrate de tener instalado el plugin de **Lombok**.
3. Ejecuta la clase principal `CheckoutApplication.java`.
4. Verifica en la consola el mensaje de éxito: `Process finished with exit code 0`.

## 📈 Cumplimiento de Principios SOLID

* **S (Single Responsibility)**: Cada clase tiene una única razón para cambiar.
* **O (Open/Closed)**: Podemos agregar nuevos métodos de pago o descuentos sin tocar el código existente.
* **L (Liskov Substitution)**: Los adaptadores y decoradores pueden usarse indistintamente donde se espere un
  `PaymentProcessor`.

---
*Desarrollado como parte del Taller de Patrones de Diseño - Grupo Intermedio 2.*