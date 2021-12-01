package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.LocalDateTime;

import static BrowserTest.SetupDriver.driverNames;
import static org.junit.Assert.assertTrue;


public class Test12 {

    @Test
    public void runPageTest() {
        SetupDriver setupDriver = new SetupDriver();
        for (String driverName : driverNames) {
            productAddTest(setupDriver.getDriver(driverName));
        }
        //productAddTest(setupDriver.getDriver("chrome"));
    }


//        driver.manage().timeouts().pageLoadTimeout(10000,TimeUnit.MILLISECONDS);

    public void productAddTest(WebDriver driver) {

        String path = System.getProperty("user.dir");
        String productName = generateName();

        driver.get("http://localhost/litecart/admin/");
        Login.loginLitecart(driver);

        WebElement catalogMenu = driver.findElement(By.xpath("//span[text()='Catalog']"));
        catalogMenu.click();
        WebElement addProduct = driver.findElement(By.xpath("//*[@id='content']/div[1]/a[2]"));
        addProduct.click();

        WebElement nameInput = driver.findElement(By.xpath("//input[@name='name[en]']"));
        nameInput.sendKeys(productName);

        WebElement codeInput = driver.findElement(By.xpath("//input[@name='code']"));
        codeInput.sendKeys("0123");


        WebElement categoriesCheckBox = driver.findElement(By.xpath("//*[@id='tab-general']/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td[1]/input"));
        categoriesCheckBox.click();

        WebElement defaultCategory = driver.findElement(By.xpath("//*[@id='tab-general']/table/tbody/tr[5]/td/select/option[2]"));
        defaultCategory.click();

        WebElement genderGroups = driver.findElement(By.xpath("//input[@value='1-3']"));
        genderGroups.click();

        WebElement quantityInput = driver.findElement(By.xpath("//input[@name='quantity']"));
        quantityInput.clear();
        quantityInput.sendKeys("500");

        WebElement uploadImagesInput = driver.findElement(By.xpath("//input[@type='file']"));
        String imgpath = path + "\\src\\main\\resources\\img\\krolic.jpg";
        uploadImagesInput.sendKeys(imgpath);


        String dateFrom = "input[type=date][name=date_valid_from]";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','2020-02-10')", driver.findElement(By.cssSelector(dateFrom)));

        String dateTo = "input[type=date][name=date_valid_to]";

        js.executeScript("arguments[0].setAttribute('value','2021-03-12')", driver.findElement(By.cssSelector(dateTo)));


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));


        WebElement informationPage = driver.findElement(By.xpath("//a[@href='#tab-information']"));
        informationPage.click();

        WebElement manufacturerInput = driver.findElement(By.xpath("//select[@name='manufacturer_id']/option[@value='1']"));
        manufacturerInput.click();

        WebElement keyWorsd = driver.findElement(By.xpath("//input[@name='keywords']"));
        keyWorsd.sendKeys("sadasd");

        WebElement shortDescription = driver.findElement(By.xpath("//input[@name='short_description[en]']"));
        shortDescription.sendKeys("zxczxc");

        WebElement descriptionInput = driver.findElement(By.xpath("//*[@class='trumbowyg-editor']"));
        descriptionInput.sendKeys("opiojlkjlkmk");

        WebElement headTitle = driver.findElement(By.xpath("//input[@name='head_title[en]']"));
        headTitle.sendKeys("oikkok");

        WebElement metaDescription = driver.findElement(By.xpath("//input[@name='meta_description[en]']"));
        metaDescription.sendKeys("bvcb");

        WebElement priceInput = driver.findElement(By.xpath("//a[@href='#tab-prices']"));
        priceInput.click();

        WebElement purchasePriceInput = driver.findElement(By.xpath("//input[@name='purchase_price']"));
        purchasePriceInput.clear();
        purchasePriceInput.sendKeys("200");

        WebElement purchasePrice = driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']//descendant::option[3]"));
        purchasePrice.click();

        WebElement priceUsd = driver.findElement(By.xpath("//input[@name='prices[USD]']"));
        priceUsd.sendKeys("520");

        WebElement prieceEur = driver.findElement(By.xpath("//input[@name='prices[EUR]']"));
        prieceEur.sendKeys("100");

        WebElement saveButton = driver.findElement(By.xpath("//button[@name='save']"));
        saveButton.click();

        WebElement lastProduct = driver.findElement(By.xpath("//a[text()='" + productName + "']"));
        assertTrue(lastProduct.isDisplayed());

        driver.manage().timeouts().implicitlyWait(Duration.ZERO);

        driver.quit();
    }

    public String generateName() {
        String time = LocalDateTime.now().toString();
        time = time.replace(":", "").replace(".", "").replace("-", "");
        return time;
    }

}

