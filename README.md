# Automatización E2E - SauceDemo (Playwright + Cucumber + Java)

Proyecto de automatización de pruebas End-to-End (E2E) para la aplicación web [SauceDemo](https://saucedemo.com), implementado con **Playwright for Java**, **Cucumber (BDD)** y **JUnit 5** bajo el patrón de diseño **Page Object Model (POM)**.

---

## 🛠️ Tecnologías utilizadas

* **Lenguaje:** Java 17+
* **Gestor de dependencias:** Apache Maven
* **Motor de automatización:** Playwright for Java
* **Framework BDD:** Cucumber Java
* **Ejecutor de pruebas:** JUnit 5 Platform Suite

---

## 📁 Estructura del proyecto

```text
src/
└── test/
    ├── java/
    │   ├── hooks/
    │   │   └── Hooks.java              # Inicialización, cierre del navegador y capturas de error
    │   ├── pages/
    │   │   ├── CartPage.java           # Page Object de la vista del carrito
    │   │   ├── CheckoutPage.java       # Page Object del proceso de pago y confirmación
    │   │   ├── LoginPage.java          # Page Object de la pantalla de inicio de sesión
    │   │   └── ProductsPage.java       # Page Object del catálogo de productos
    │   ├── runners/
    │   │   └── TestRunner.java         # Ejecutor principal de Cucumber con JUnit 5
    │   └── stepdefinitions/
    │       ├── CarritoSteps.java       # Definición de pasos para el carrito de compras
    │       ├── CheckoutSteps.java      # Definición de pasos para el proceso de compra
    │       └── LoginSteps.java         # Definición de pasos para autenticación
    └── resources/
        └── features/
            ├── carrito.feature         # Escenarios de agregar y visualizar productos
            ├── checkout.feature        # Escenario E2E de compra completa
            └── login.feature           # Escenarios de login válido y usuario bloqueado
```

---

## ⚙️ Requisitos previos e instalación

1. Tener instalado **Java JDK 17** o superior.
2. Tener instalado **Apache Maven**.
3. Clonar el repositorio y descargar las dependencias del proyecto:
   ```bash
   mvn clean test-compile
   ```
4. Instalar los binarios de los navegadores requeridos por Playwright (ejecutar solo la primera vez):
   ```bash
   mvn exec:java -Dexec.mainClass="com.microsoft.playwright.CLI" -Dexec.args="install"
   ```

---

## 🚀 Ejecución de pruebas

### Ejecutar toda la suite de pruebas
```bash
mvn clean test
```

### Ejecutar escenarios por etiquetas (Tags)
* **Etiquetados para regresion (`@regresion`):**
  ```bash
  mvn clean test -Dcucumber.filter.tags="@regresion"
  ```
* **Flujo completo de compra (`@checkout`):**
  ```bash
  mvn clean test -Dcucumber.filter.tags="@checkout"
  ```
* **Combinar múltiples tags (`or` / `and`):**
  ```bash
  mvn clean test -Dcucumber.filter.tags="@carrito or @verCarrito"
  ```

### Ejecución desde IntelliJ IDEA
* **Configuración Maven:** En el campo `Run` / `Command line` escribir:
  ```text
  clean test -Dcucumber.filter.tags="@regresion"
  ```
* **Configuración JUnit (`TestRunner`):** En el campo `VM options` escribir:
  ```text
  -Dcucumber.filter.tags="@regresion"
  ```

---

## 📊 Reportes de ejecución

Al finalizar cualquier ejecución, Cucumber genera automáticamente un reporte visual en formato HTML con el detalle de cada paso y capturas de pantalla adjuntas en caso de fallo.

* **Ruta del reporte:** `target/cucumber-reports/reporte.html`
* Para visualizarlo, abre el archivo directamente en cualquier navegador web.

---

## 🧪 Escenarios automatizados

| Feature | Escenario | Tags |
| :--- | :--- | :--- |
| **Login** | Iniciar sesión con credenciales válidas (`standard_user`) | `@smoke`, `@loginExitoso` |
| **Login** | Iniciar sesión con usuario bloqueado (`locked_out_user`) | `@regresion`, `@loginFallido` |
| **Carrito** | Agregar un producto al carrito desde la página de productos | `@smoke`, `@carrito` |
| **Carrito** | Visualizar múltiples productos agregados mediante el ícono del carrito | `@regresion`, `@verCarrito` |
| **Checkout** | Completar una compra exitosamente hasta la confirmación | `@e2e`, `@checkout` |
