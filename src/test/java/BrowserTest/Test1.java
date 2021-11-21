package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test1 {

    @Test
    public void firstTest() {
        System.setProperty("Webdriver.chrome.driver", "path/to/tools");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.ru/");
        driver.quit();
    }

}
