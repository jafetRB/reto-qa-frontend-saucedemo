package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductsPage {
    private final Page page;

    // Locators de la página de inventario/productos
    private final Locator cartBadge;
    private final Locator cartLink;

    public ProductsPage(Page page) {
        this.page = page;
        this.cartBadge = page.locator(".shopping_cart_badge");
        this.cartLink = page.locator(".shopping_cart_link");
    }

    // Busca el contenedor del producto por su nombre y hace clic en su botón "Add to cart"
    public void addProductToCart(String productName) {
        Locator productCard = page.locator(".inventory_item").filter(new Locator.FilterOptions().setHasText(productName));
        productCard.locator("button").click();
    }

    // Obtiene el número que aparece sobre el ícono del carrito
    public String getCartBadgeCount() {
        return cartBadge.textContent();
    }

    public void goToCart() {
        cartLink.click();
    }
}
