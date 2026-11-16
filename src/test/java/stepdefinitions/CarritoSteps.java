package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.ProductsPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarritoSteps {

    private final ProductsPage productsPage = new ProductsPage(Hooks.page);
    private final CartPage cartPage = new CartPage(Hooks.page);

    @When("agrega el producto {string} al carrito")
    public void agregarProductoAlCarrito(String nombreProducto) {
        productsPage.addProductToCart(nombreProducto);
    }

    @Then("el ícono del carrito debería mostrar {string} productos")
    public void verificarContadorCarrito(String cantidadEsperada) {
        assertEquals(cantidadEsperada, productsPage.getCartBadgeCount());
    }

    @When("agrega los siguientes productos al carrito:")
    public void agregarMultiplesProductos(List<String> productos) {
        for (String producto : productos) {
            productsPage.addProductToCart(producto);
        }
    }

    @When("hace clic en el ícono del carrito de compras")
    public void abrirCarritoDeCompras() {
        productsPage.goToCart();
    }

    @Then("debería visualizar los siguientes productos en el carrito:")
    public void verificarProductosEnCarrito(List<String> productosEsperados) {
        List<String> productosActuales = cartPage.getProductNamesInCart();
        assertEquals(productosEsperados, productosActuales);
    }
}
