package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.xpath;

public class Test7 {
    @Test
    public void PanelTest() {
        System.setProperty("WebDriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost/litecart/admin/");

        Login.loginLitecart(driver);

        List<WebElement> menuElements = driver.findElements(xpath("//ul[@id='box-apps-menu']/li"));

        String subMenuLocator = "//ul[@id='box-apps-menu']/li/ul/li";
        String headerLocator = "//h1";

        for (int i = 1; i <= menuElements.size(); i++) {
            WebElement menuElement = driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[" + i + "]"));
            menuElement.click();

            assertTrue(areElementsPresent(driver, headerLocator));

            List<WebElement> subMenu = driver.findElements(xpath(subMenuLocator));
            if (subMenu.size() > 0) {
                for (int j = 1; j <= subMenu.size(); j++) {
                    WebElement subMenuElement = driver.findElement(xpath("//ul[@id='box-apps-menu']/li/ul/li[" + j + "]"));
                    subMenuElement.click();
                    assertTrue(areElementsPresent(driver, headerLocator));
                }
            }
        }

        driver.quit();
    }
    boolean areElementsPresent(WebDriver driver, String headerLocator) {
        return driver.findElements(By.xpath(headerLocator)).size() > 0;

    }
}

