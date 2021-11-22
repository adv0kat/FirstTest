package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test9one {
    @Test
    public void countryTest() {
        System.setProperty("WebDriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        Login.loginLitecart(driver);

        List<WebElement> countriesElementsList = driver.findElements(By.xpath("//td/a[text()]"));
        ArrayList<String> countries = new ArrayList();
        for (int i = 0; i < countriesElementsList.size(); i++) {
            countries.add(i, countriesElementsList.get(i).getText());
            System.out.print(countries);
        }
        ArrayList<String> sortedCountries = new ArrayList<>(countries);
        Collections.sort(sortedCountries);
        for (int i = 0; i < countries.size(); i++) {
            assertEquals(countries.get(i), sortedCountries.get(i));
        }
        driver.quit();
    }
}
