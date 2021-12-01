package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.security.pkcs11.wrapper.Constants;

import java.util.List;

import static BrowserTest.SetupDriver.driverNames;


public class Test12 {
    Exception e
    WebElement priceUsd = driver.findElement(By.xpath("//input[@name='prices[USD]']"));catch(
    WebElement priceEur = driver.findElement(By.xpath("//input[@name='prices[EUR]']"));)
    WebElement saveButton = driver.findElement(By.xpath("//button[@name='save']"));`


    WebElement informationPage = driver.findElement(By.xpath("//a[@href='#tab-information']"));
        informationPage.click();

//        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

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

//        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

    WebElement purchasePriceInput = driver.findElement(By.xpath("//input[@name='purchase_price']"));
        purchasePriceInput.clear();
        purchasePriceInput.sendKeys("200");

    WebElement purchasePrice = driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']//descendant::option[3]"));
        purchasePrice.click();
    WebElement lastProduct = driver.findElement(By.xpath("//table[@class='dataTable']//tr[@class='row semi-transparent'][last()]"));
        priceUsd.sendKeys("1000");

    {
        return Constants.KEYWORD_FAIL + " -- Not able to select the date" + e.getMessage();
    }
        priceEur.sendKeys("500");

    @Test
    public void runPageTest() throws InterruptedException {
        SetupDriver setupDriver = new SetupDriver();
        for (String driverName : driverNames) {
            productAddTest(setupDriver.getDriver(driverName));
        }
//        regisration(setupDriver.getDriver("chrome"));
    }
        saveButton.click();

//        driver.manage().timeouts().pageLoadTimeout(10000,TimeUnit.MILLISECONDS);

    public void productAddTest(WebDriver driver) {

        String path = System.getProperty("user.dir");

//        System.setProperty("Webdriver.chrome.driver", "path/to/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
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

        WebElement defaultCategory = driver.findElement(By.xpath("//*[@id='tab-general']/table/tbody/tr[5]/td/select/option[2]"));
        defaultCategory.click();

        WebElement genderGroups = driver.findElement(By.xpath("//input[@value='1-3']"));
        genderGroups.click();

        WebElement quantityInput = driver.findElement(By.xpath("//input[@name='quantity']"));
        quantityInput.clear();
        quantityInput.sendKeys("500");

        WebElement uploadImagesInput = driver.findElement(By.xpath("//input[@type='file']"));
        String imgpath = path + "/src/main/resources/img/krolic.jpg";
        uploadImagesInput.sendKeys(imgpath);


//        WebElement dateFromInput = driver.findElement(By.xpath("//*[@id='tab-general']/table/tbody/tr[10]/td/input"));
//
//        WebElement dateToInput = driver.findElement(By.xpath("//*[@id='tab-general']/table/tbody/tr[11]/td/input"));
        WebElement dateWidget = driver.findElement(By.xpath(OR.getProperty(object)));

        List<WebElement> rows = dateWidget.findElements(By.tagName("tr"));
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

        for (WebElement cell : columns) {
            if (cell.getText().equals(data)) {
                cell.findElement(By.linkText(data)).click();
                break;
            }
        }
    }
        lastProduct.click();


        driver.quit();
}
}
