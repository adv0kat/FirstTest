package BrowserTest;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
public class FirstTest {

@Test
    public void firstTest() {
    System.setProperty ("Webdriver.chrome.driver", "path/to/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get("http://www.google.ru/");
   // driver.quit();
}

}
