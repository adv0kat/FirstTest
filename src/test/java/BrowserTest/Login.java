package BrowserTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.xpath;

public class Login {
    public static void loginLitecart(WebDriver driver) {
        WebElement loginInput = driver.findElement(xpath("//input[@name='username']"));
        WebElement passwordInput = driver.findElement(xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(xpath("//button[@name='login']"));


        loginInput.sendKeys("admin");
        passwordInput.sendKeys("admin");
        loginButton.click();
    }
}
