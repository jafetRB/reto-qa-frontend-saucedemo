Feature: Gestión del carrito de compras en SauceDemo

  @agregarProducto @regresion
  Scenario: Agregar un producto al carrito desde la página de productos
    Given que el usuario está en la página de login de SauceDemo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    Then el ícono del carrito debería mostrar "1" productos


  @verCarrito @regresion
  Scenario: Visualizar múltiples productos agregados en el carrito de compras
    Given que el usuario está en la página de login de SauceDemo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And agrega los siguientes productos al carrito:
      | Sauce Labs Bike Light    |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Fleece Jacket |
    And hace clic en el ícono del carrito de compras
    Then debería visualizar los siguientes productos en el carrito:
      | Sauce Labs Bike Light    |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Fleece Jacket |
