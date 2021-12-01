package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test13 {
    @Test

    public void productCartTest() {
        System.setProperty("Webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.get("http://localhost/litecart/en/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

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

        driver.manage().timeouts().implicitlyWait(Duration.ZERO);

        driver.quit();
    }

}
