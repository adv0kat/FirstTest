package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static BrowserTest.SetupDriver.driverNames;

public class Test13 {

    @Test
    public void runPageTest() {
        SetupDriver setupDriver = new SetupDriver();
        for (String driverName : driverNames) {
            productCartTest(setupDriver.getDriver(driverName));
        }
        //productAddTest(setupDriver.getDriver("chrome"));
    }

    public void productCartTest(WebDriver driver) {
        driver.get("http://localhost/litecart/en/");

        for (int i = 0; i < 3; i++) {

            int qtyBeforeAdd = getQuantityFromCart(driver);
            WebElement firstProduct = driver.findElement(By.xpath("//*[@id='box-most-popular']/div/ul/li[1]/a[1]"));
            firstProduct.click();

            selectSize(driver);

            WebElement addCart = driver.findElement(By.xpath("//button[@name='add_cart_product']"));
            addCart.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until((ExpectedCondition<Boolean>) driver1 -> getQuantityFromCart(driver1) > qtyBeforeAdd);
            WebElement homePage = driver.findElement(By.xpath("//li[@class='general-0']"));
            homePage.click();
        }

        WebElement checkoutCart = driver.findElement(By.xpath("//div[@id='cart']/a[3]"));
        checkoutCart.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        List<WebElement> qtyList = driver.findElements(By.xpath("//td[@class='item']/../td[1]"));

        for (int i = 0; i < qtyList.size(); i++) {
            int qtyBeforeRemove = getQtySum(driver);
            WebElement removeProduct = driver.findElement(By.xpath("//button[@name='remove_cart_item']"));
            removeProduct.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until((ExpectedCondition<Boolean>) driver12 -> getQtySum(driver12) < qtyBeforeRemove);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        driver.quit();
    }

    private int getQtySum(WebDriver driver) {
        String qtyLocator = "//td[@class='item']/../td[1]";
        List<WebElement> qtyList = driver.findElements(By.xpath(qtyLocator));
        int qantity = 0;
        for (WebElement qty : qtyList) {
            qantity = qantity + Integer.parseInt(qty.getText());
        }
        return qantity;
    }

    private int getQuantityFromCart(WebDriver driver) {
        String qtyLocator = "//span[@class='quantity']";
        WebElement quantity = driver.findElement(By.xpath(qtyLocator));
        return Integer.parseInt(quantity.getText());
    }

    private void selectSize(WebDriver driver) {
        if (!driver.findElements(By.xpath("//select[@required='required']")).isEmpty()) {
            WebElement selectSize = driver.findElement(By.xpath("//option[@value='Medium']"));
            selectSize.click();
        }
    }

}
