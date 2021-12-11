package BrowserTest.app;

import BrowserTest.pages.CartPage;
import BrowserTest.pages.MainPage;
import BrowserTest.pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LiteCartApp {
    private final WebDriver driver;
    private final ProductPage productPage;
    private final MainPage mainPage;
    private final CartPage cartPage;

    public LiteCartApp() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    public void setImplicitTimeout(int timeout) {
        if (timeout == 0) {
            driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        } else {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
        }
    }

    public void quit() {
        driver.quit();
    }

    public void openMainPage() {
        mainPage.open();
    }

    public void openCartPage() {
        cartPage.open();
    }

    public void addProductToCart(int productCount) {
        for (int i = 0; i < productCount; i++) {

            int qtyBeforeAdd = mainPage.getQuantityFromCart();

            mainPage.firstProduct.click();
            productPage.selectSize();
            productPage.addCartButton.click();
            productPage.getQtyWithTimeOut(qtyBeforeAdd);
            productPage.homePage.click();
        }
    }

    public void removeProductFromCart() {
        setImplicitTimeout(4);
        List<WebElement> qtyList = driver.findElements(By.xpath("//td[@class='item']/../td[1]"));
        for (int i = 0; i < qtyList.size(); i++) {
            int qtyBeforeRemove = cartPage.getQtySum();
            cartPage.removeProductButton.click();
            cartPage.getQtyWithTimeOut(qtyBeforeRemove);
        }
        setImplicitTimeout(0);
    }

    public void checkoutCart() {
        cartPage.checkoutCartButton.click();
    }

}
