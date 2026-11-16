Feature: Inicio de sesión en SauceDemo

  @loginExitoso @regresion
  Scenario: Iniciar sesión con credenciales válidas
    Given que el usuario está en la página de login de SauceDemo
    When ingresa el usuario "standard_user" y la contraseña "secret_sauce"
    Then debería ingresar a la tienda y ver el título "Products"

  @loginFallido @regresion
  Scenario: Iniciar sesión con usuario bloqueado
    Given que el usuario está en la página de login de SauceDemo
    When ingresa el usuario "locked_out_user" y la contraseña "secret_sauce"
    Then debería ver el mensaje de error "Epic sadface: Sorry, this user has been locked out."
