package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;

    // Locators exactos de saucedemo.com
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator productsTitle;
    private final Locator errorMessage;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.locator("#user-name");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("#login-button");
        this.productsTitle = page.locator(".title");
        this.errorMessage = page.locator("[data-test='error']");
    }

    public void navigateTo() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }

    public String getPageTitle() {
        return productsTitle.textContent();
    }

    public String getCurrentUrl() {
        return page.url();
    }

    public String getErrorMessage() {
        return errorMessage.textContent();
    }
}
