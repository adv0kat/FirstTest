package BrowserTest.cucumber;

import BrowserTest.app.LiteCartApp;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Steps {
    LiteCartApp app = new LiteCartApp();

    @Given("Open main page")
    public void openMainPage() {
        app.openMainPage();
    }

    @When("^Add \"(.*?)\" product to cart$")
    public void addProductToCart(int qty) {
        app.addProductToCart(qty);
    }

    @When("Checkout cart")
    public void checkout() {
        app.checkoutCart();
    }

    @When("Remove product from cart")
    public void removeProductFromCart() {
        app.removeProductFromCart();
    }

    @After
    public void quit() {
        app.quit();
    }

}
