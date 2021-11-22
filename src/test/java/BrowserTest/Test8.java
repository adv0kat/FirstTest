package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.xpath;

public class Test8 {

    @Test
    public void stickerTest() {
        System.setProperty("WebDriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost/litecart/en/");

        List<WebElement> products = driver.findElements(xpath("//ul[@class='listing-wrapper products']/li"));
        for (WebElement product : products) {
            List<WebElement> stickers = product.findElements(By.xpath(".//div[contains(@class,'sticker')]"));
            assertEquals(1, stickers.size());
        }
        driver.quit();
    }

}


