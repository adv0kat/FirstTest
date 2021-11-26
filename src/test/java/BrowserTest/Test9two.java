package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static BrowserTest.Test9one.compareNames;

public class Test9two {
    @Test
    public void geoZoneTest() {

        System.setProperty("Webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost/litecart/admin/");
        Login.loginLitecart(driver);
        WebElement geoZoneMenu = driver.findElement(By.xpath("//span[contains(text(),'Geo Zones')]/.."));
        geoZoneMenu.click();

        List<WebElement> countryList = driver.findElements(By.xpath("//tr[@class='row']/td[3]/a"));
        for (int i = 1; i <= countryList.size(); i++) {
            WebElement zone = driver.findElement(By.xpath("//tr[@class='row'][" + i + "]/td[3]/a"));
            zone.click();

            List<WebElement> zones = driver.findElements(By.xpath("//tr/td[3]/select/option[@selected='selected']"));
            List<String> zoneNames = new ArrayList<>();
            for (int j = 0; j < zones.size(); j++) {
                zoneNames.add(zones.get(j).getText());
            }

            compareNames(zoneNames);

            WebElement cancelButton = driver.findElement(By.xpath("// button[@name='cancel']"));
            cancelButton.click();
        }
        driver.quit();
    }
}
