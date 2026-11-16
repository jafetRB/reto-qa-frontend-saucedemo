package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage(Hooks.page);

    @Given("que el usuario está en la página de login de SauceDemo")
    public void abrirPaginaLogin() {
        loginPage.navigateTo();
    }

    @When("ingresa el usuario {string} y la contraseña {string}")
    public void ingresarCredenciales(String usuario, String password) {
        loginPage.login(usuario, password);
    }

    @Then("debería ingresar a la tienda y ver el título {string}")
    public void validarLoginExitoso(String tituloEsperado) {
        assertEquals(tituloEsperado, loginPage.getPageTitle());
        assertTrue(loginPage.getCurrentUrl().contains("/inventory.html"));
    }

    @Then("debería ver el mensaje de error {string}")
    public void validarMensajeError(String mensajeEsperado) {
        assertEquals(mensajeEsperado, loginPage.getErrorMessage());
    }
}
