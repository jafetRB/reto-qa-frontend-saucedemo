package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutSteps {

    private final CartPage cartPage = new CartPage(Hooks.page);
    private final CheckoutPage checkoutPage = new CheckoutPage(Hooks.page);

    @When("procede al checkout")
    public void procederAlCheckout() {
        cartPage.clickCheckout();
    }

    @When("completa sus datos de envío con nombre {string}, apellido {string} y código postal {string}")
    public void completarDatosEnvio(String nombre, String apellido, String codigoPostal) {
        checkoutPage.fillShippingInformation(nombre, apellido, codigoPostal);
    }

    @When("finaliza la orden de compra")
    public void finalizarOrden() {
        checkoutPage.finishOrder();
    }

    @Then("debería ver el mensaje de confirmación {string}")
    public void validarConfirmacionCompra(String mensajeEsperado) {
        assertEquals(mensajeEsperado, checkoutPage.getConfirmationMessage());
    }
}
