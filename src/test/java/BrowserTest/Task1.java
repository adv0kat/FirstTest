package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Task1 {

    @Test
    public void firstTest() {
        System.setProperty("Webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.ru/");

        driver.quit();
    }

}
