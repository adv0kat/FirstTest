package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

    @Test
    public void loginTest() {
        System.setProperty("Webdriver.chrome.driver", "path/to/tools");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin/");

        WebElement loginInput = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginInput.sendKeys("admin");
        passwordInput.sendKeys("admin");
        loginButton.click();

        driver.quit();
    }

}
