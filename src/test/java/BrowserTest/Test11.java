package BrowserTest;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;

import static BrowserTest.SetupDriver.driverNames;
import static org.openqa.selenium.Keys.ENTER;

public class Test11 {
    @Test
    public void runPageTest() {
        SetupDriver setupDriver = new SetupDriver();
        for (String driverName : driverNames) {
            regisration(setupDriver.getDriver(driverName));
        }
//        regisration(setupDriver.getDriver("chrome"));
    }

    public void regisration(WebDriver driver) {

        String email = generateEmail();
        String password = "asdzxc";
        driver.get("http://localhost/litecart/en/create_account");
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement lastNameInput = driver.findElement(By.xpath("//input[@name='lastname']"));
        WebElement addresOneInput = driver.findElement(By.xpath("//input[@name='address1']"));
        WebElement postCodeInput = driver.findElement(By.xpath("//input[@name='postcode']"));
        WebElement cityInput = driver.findElement(By.xpath("//input[@name='city']"));
        WebElement countryInput = driver.findElement(By.xpath("//select[@name='country_code']/../span[2]"));

        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement phoneInput = driver.findElement(By.xpath("//input[@name='phone']"));
        WebElement desiredPasswordInput = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement confirmPasswordInput = driver.findElement(By.xpath("//input[@name='confirmed_password']"));
        WebElement buttonCreateAccount = driver.findElement(By.xpath("//button[@name='create_account']"));

        firstNameInput.sendKeys("John");
        lastNameInput.sendKeys("Wick");
        addresOneInput.sendKeys("qwe");
        postCodeInput.sendKeys("52123");
        cityInput.sendKeys("ololo");

        countryInput.click();
        WebElement countrySearch = driver.findElement(By.xpath("//input[@type='search']"));
        countrySearch.sendKeys("United States");
        countrySearch.sendKeys(ENTER);

        emailInput.sendKeys(email);
        phoneInput.sendKeys("1565253545");
        desiredPasswordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);

        buttonCreateAccount.click();

        logout(driver);

        WebElement emailLoginInput = driver.findElement(By.xpath("//input[@name='email']"));
        emailLoginInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        logout(driver);

        driver.quit();
    }

    public String generateEmail() {
        String time = LocalDateTime.now().toString();
        time = time.replace(":", "").replace(".", "").replace("-", "");
        return time + "@mail.ru";
    }

    public void logout(WebDriver driver) {
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id='box-account']/div/ul/li[4]/a"));
        logoutButton.click();
    }
}

