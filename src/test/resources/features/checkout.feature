Feature: Proceso de compra en SauceDemo

  @checkout @regresion
  Scenario: Completar una compra exitosamente hasta la confirmación
    Given que el usuario está en la página de login de SauceDemo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    And agrega el producto "Sauce Labs Backpack" al carrito
    And hace clic en el ícono del carrito de compras
    And procede al checkout
    And completa sus datos de envío con nombre "Pepito", apellido "Yaipen" y código postal "13000"
    And finaliza la orden de compra
    Then debería ver el mensaje de confirmación "Thank you for your order!"
