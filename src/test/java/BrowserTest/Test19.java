package BrowserTest;

import BrowserTest.app.LiteCartApp;
import org.junit.Test;

public class Test19 {
    @Test
    public void productCartTest() {
        LiteCartApp app = new LiteCartApp();
        app.openMainPage();
        app.addProductToCart(3);
        app.checkoutCart();
        app.removeProductFromCart();
        app.quit();
    }
}
