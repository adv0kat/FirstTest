package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Test17 {
    @Test
    public void runPageTest() {
        SetupDriver setupDriver = new SetupDriver();
//        for (String driverName : driverNames) {
//            checkProduct(setupDriver.getDriver(driverName));
//        }
        checkProduct(setupDriver.getDriver("chrome"));
    }

    public void checkProduct(WebDriver driver) {

        driver.get(" http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        Login.loginLitecart(driver);


        List<WebElement> links = driver.findElements(By.xpath("//tr[@class='row']/td[3]/a[@href]"));
        for (int i = 2; i < links.size(); i++) {
            List<WebElement> product = driver.findElements(By.xpath("//tr[@class='row']/td[3]/a[@href]"));
            product.get(i).click();

            driver.manage().logs().get("browser")
                    .getAll().forEach(logEntry -> System.out.println("BROWSER: " + logEntry));

            driver.navigate().back();
        }
        driver.quit();
    }

}



