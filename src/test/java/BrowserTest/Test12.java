package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class Test12 {
    @Test
        public void productAddTest() throws InterruptedException {


        System.setProperty("Webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin/");
        Login.loginLitecart(driver);

        WebElement catalogMenu = driver.findElement(By.xpath("//span[text()='Catalog']"));
        catalogMenu.click();
        WebElement addProduct = driver.findElement(By.xpath("//*[@id='content']/div[1]/a[2]"));
        addProduct.click();

        WebElement nameInput = driver.findElement(By.xpath("//input[@name='name[en]']"));
        nameInput.click();
        nameInput.sendKeys("krolic");

        WebElement codeInput = driver.findElement(By.xpath("//input[@name='code']"));
        codeInput.click();
        codeInput.sendKeys("0123");

        WebElement categoriesCheckBox = driver.findElement(By.xpath("//*[@id='tab-general']/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td[1]/input"));
        categoriesCheckBox.click();

        WebElement defaultCategory = driver.findElement(By.xpath("//*[@id=\"tab-general\"]/table/tbody/tr[5]/td/select/option[2]"));
        defaultCategory.click();

        WebElement genderGroups= driver.findElement(By.xpath("//input[@value='1-3']"));
        genderGroups.click();


        WebElement quantityInput= driver.findElement(By.xpath("//input[@name='quantity']"));
        quantityInput.clear();
        quantityInput.sendKeys("500");

        WebElement uploadImagesInput = driver.findElement(By.xpath("//input[@type='file']"));
        uploadImagesInput.sendKeys("");


        Thread.sleep(1000);
        driver.quit();
    }
}
