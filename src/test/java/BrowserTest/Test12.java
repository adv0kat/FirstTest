package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test12 {

    @Test
//    public void runPageTest() throws InterruptedException {
//        SetupDriver setupDriver = new SetupDriver();
//        for (String driverName : driverNames) {
//            productAddTest(setupDriver.getDriver(driverName));
//        }
//        regisration(setupDriver.getDriver("chrome"));
//    }


//        driver.manage().timeouts().pageLoadTimeout(10000,TimeUnit.MILLISECONDS);

    public void productAddTest() throws InterruptedException {

        String path = System.getProperty("user.dir");

        System.setProperty("Webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
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

        Thread.sleep(1000);

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

        Thread.sleep(1000);

        WebElement dateFromInput = driver.findElement(By.xpath("//*[@id=\"tab-general\"]/table/tbody/tr[10]/td/input"));
        dateFromInput.sendKeys("05052005");

        WebElement dateToInput = driver.findElement(By.xpath("//*[@id=\"tab-general\"]/table/tbody/tr[11]/td/input"));
        dateToInput.sendKeys("05062006");

        Thread.sleep(1000);

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

        Thread.sleep(1000);
        driver.quit();
    }
}
