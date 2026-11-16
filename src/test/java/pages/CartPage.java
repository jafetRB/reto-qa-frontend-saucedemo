package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.List;

public class CartPage {
    private final Page page;
    private final Locator cartItemNames;
    private final Locator checkoutButton;

    public CartPage(Page page) {
        this.page = page;
        // Selector de los títulos de cada producto dentro del carrito
        this.cartItemNames = page.locator(".cart_item .inventory_item_name");
        this.checkoutButton = page.locator("#checkout");
    }

    // Devuelve una lista con los nombres de todos los productos presentes en el carrito
    public List<String> getProductNamesInCart() {
        return cartItemNames.allTextContents();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}
