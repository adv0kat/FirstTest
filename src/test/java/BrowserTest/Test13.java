package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test13 {
    @Test

    public void productCartTest() throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        // WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.get("http://localhost/litecart/en/");

        WebElement firstDuck = driver.findElement(By.xpath("//*[@id='box-most-popular']/div/ul/li[1]/a[1]"));
        firstDuck.click();

        WebElement addCart = driver.findElement(By.xpath("//button[@name='add_cart_product']"));
        addCart.click();

        WebElement homePage = driver.findElement(By.xpath("//li[@class='general-0']"));
        homePage.click();

        WebElement firstProduct1 = driver.findElement(By.xpath("//*[@id='box-most-popular']/div/ul/li[1]/a[1]"));
        firstProduct1.click();

        WebElement addCart1 = driver.findElement(By.xpath("//button[@name='add_cart_product']"));
        addCart1.click();

        WebElement homePage1 = driver.findElement(By.xpath("//li[@class='general-0']"));
        homePage1.click();

        WebElement firstProduct2 = driver.findElement(By.xpath("//*[@id='box-most-popular']/div/ul/li[1]/a[1]"));
        firstProduct2.click();

        WebElement addCart2 = driver.findElement(By.xpath("//button[@name='add_cart_product']"));
        addCart2.click();

        WebElement homePage2 = driver.findElement(By.xpath("//li[@class='general-0']"));
        homePage2.click();

        WebElement checkoutCart = driver.findElement(By.xpath("//div[@id='cart']/a[3]"));
        checkoutCart.click();

        WebElement removeProduct = driver.findElement(By.xpath("//button[@name='remove_cart_item']"));
        removeProduct.click();

        WebElement removeProduct1 = driver.findElement(By.xpath("//button[@name='remove_cart_item']"));
        removeProduct1.click();

        WebElement removeProduct2 = driver.findElement(By.xpath("//button[@name='remove_cart_item']"));
        removeProduct2.click();

        Thread.sleep(1000);
        driver.quit();
    }

}
