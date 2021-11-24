package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test9one {
    @Test
    public void countryTest() {
        System.setProperty("WebDriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        Login.loginLitecart(driver);
        String zoneLocator = "./td[position()=6]";
        String counryLocator = "./td/a";
        String rowLocator = "//tr[@class= 'row']";
        List<WebElement> rowElementsList = driver.findElements(By.xpath(rowLocator));
        ArrayList<String> countries = new ArrayList<>();
        HashMap<String, Integer> countriesZones = new HashMap<>();
        for (int i = 0; i < rowElementsList.size(); i++) {
            countries.add(rowElementsList.get(i).findElement(By.xpath(counryLocator)).getText());
            String zone = rowElementsList.get(i).findElement(By.xpath(zoneLocator)).getText();
            if (!zone.equals("0")) {
                Integer zonesCount = Integer.parseInt(zone);
                countriesZones.put(countries.get(i), zonesCount);
            }
        }

        compareCountries(countries);

        for (String country : countriesZones.keySet()) {
            WebElement countryElement = driver.findElement(By.xpath("//a[text()[contains(.,'" + country + "')]]"));
            countryElement.click();

            ArrayList<String> zonesNames = new ArrayList<>();

            List<WebElement> zonesElementList = driver.findElements(By.xpath("//td/input[contains(@name, 'zones') and contains(@name, 'name')]"));
            for (WebElement zoneElement : zonesElementList) {
                zonesNames.add(zoneElement.getAttribute("value"));
            }

            compareCountries(zonesNames);
            WebElement cancelButton = driver.findElement(By.xpath("// button[@name='cancel']"));
            cancelButton.click();
        }
        driver.quit();
    }

    public void compareCountries(List<String> countries) {
        ArrayList<String> sortedCountries = new ArrayList<>(countries);
        Collections.sort(sortedCountries);
        for (int i = 0; i < countries.size(); i++) {
            assertEquals(countries.get(i), sortedCountries.get(i));
        }
    }
}


