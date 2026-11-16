package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage {
    private final Page page;

    // Pantalla 1: Información del comprador
    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator postalCodeInput;
    private final Locator continueButton;

    // Pantalla 2: Resumen de compra
    private final Locator finishButton;

    // Pantalla 3: Confirmación
    private final Locator confirmationHeader;

    public CheckoutPage(Page page) {
        this.page = page;
        this.firstNameInput = page.locator("#first-name");
        this.lastNameInput = page.locator("#last-name");
        this.postalCodeInput = page.locator("#postal-code");
        this.continueButton = page.locator("#continue");
        this.finishButton = page.locator("#finish");
        this.confirmationHeader = page.locator(".complete-header");
    }

    public void fillShippingInformation(String firstName, String lastName, String postalCode) {
        firstNameInput.fill(firstName);
        lastNameInput.fill(lastName);
        postalCodeInput.fill(postalCode);
        continueButton.click();
    }

    public void finishOrder() {
        finishButton.click();
    }

    public String getConfirmationMessage() {
        return confirmationHeader.textContent();
    }
}
