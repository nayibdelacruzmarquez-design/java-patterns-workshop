package org.checkout.patterns.workshop.singleton;

/**
 * Patrón Singleton: Asegura que solo exista una instancia de la configuración
 * en toda la ejecución del programa.
 */
public class AppConfiguration {

    // 1. La única instancia permitida (estática)
    private static AppConfiguration instance;

    // Propiedades de la aplicación
    private String businessName;
    private double taxRate;

    // 2. CONSTRUCTOR PRIVADO: Nadie puede hacer "new AppConfiguration()" desde fuera
    private AppConfiguration() {
        this.businessName = "Refaccionaria Axity - Workshop";
        this.taxRate = 0.16; // 16% de IVA
    }

    // 3. MeTODO GLOBAL: La única forma de obtener la instancia
    public static AppConfiguration getInstance() {
        if (instance == null) {
            instance = new AppConfiguration();
        }
        return instance;
    }

    // Getters y Setters para las configuraciones
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String name) {
        this.businessName = name;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}