package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static BrowserTest.SetupDriver.driverNames;

public class Test14 {
    @Test
    public void runPageTest() throws InterruptedException {
        SetupDriver setupDriver = new SetupDriver();
        for (String driverName : driverNames) {
            checkCountries(setupDriver.getDriver(driverName));
        }
        //productAddTest(setupDriver.getDriver("chrome"));
    }
    //*[@id="content"]//td[1]//a[2] для аддресформат

    public void checkCountries(WebDriver driver) throws InterruptedException {

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        Login.loginLitecart(driver);


        WebElement newCountries = driver.findElement(By.cssSelector("a[class='button']"));
        newCountries.click();

        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();

        List<WebElement> links = driver.findElements(By.xpath("//i[@class='fa fa-external-link']/.."));
        for (WebElement link : links) {
            link.click();
            String newWindow = getString(driver, oldWindowsSet);
            driver.switchTo().window(newWindow);
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            driver.close();
            driver.switchTo().window(originalWindow);
        }
        driver.switchTo().window(originalWindow);
        driver.quit();
    }

    private String getString(WebDriver driver, Set<String> oldWindowsSet) {
        String newWindow = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        return newWindow;
    }
}