package BrowserTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static BrowserTest.SetupDriver.driverNames;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test10 {
    @Test
    public void runPageTest() {
        SetupDriver setupDriver = new SetupDriver();
        for (String driverName : driverNames) {
            pageTest(setupDriver.getDriver(driverName));
        }
//    pageTest(setupDriver.getDriver("chrome"));
    }

    public void pageTest(WebDriver driver) {

        driver.get("http://localhost/litecart/en/");

        String priceLocator = "./div[@class='price-wrapper']/s";
        String salePriceLocator = "./div[@class='price-wrapper']/strong";

        WebElement productMainPage = driver.findElement(By.xpath("//div[@id='box-campaigns']/div/ul/li/a[@class='link']"));
        String productMainPageName = productMainPage.findElement(By.xpath("./div[@class= 'name']")).getText();

        WebElement mainPagePrice = productMainPage.findElement(By.xpath(priceLocator));
        String mainPagePriceValue = mainPagePrice.getText();

        WebElement mainPageSalePrice = productMainPage.findElement(By.xpath(salePriceLocator));
        String mainPageSalePriceValue = mainPageSalePrice.getText();

        checkPrice(mainPagePrice);
        checkSalePrice(mainPageSalePrice);
        compareFontSizes(mainPagePrice, mainPageSalePrice);

        productMainPage.click();

        WebElement productProductPage = driver.findElement(By.xpath("//div[@class='information']"));
        String productProductPageName = driver.findElement(By.xpath("//h1")).getText();

        WebElement productPagePrice = productProductPage.findElement(By.xpath(priceLocator));
        String productPagePriceValue = productPagePrice.getText();

        WebElement productPageSalePrice = productProductPage.findElement(By.xpath(salePriceLocator));
        String productPageSalePriceValue = productPageSalePrice.getText();

        assertEquals(productMainPageName, productProductPageName);
        assertEquals(mainPagePriceValue, productPagePriceValue);
        assertEquals(mainPageSalePriceValue, productPageSalePriceValue);

        checkPrice(productPagePrice);
        checkSalePrice(productPageSalePrice);
        compareFontSizes(productPagePrice, productPageSalePrice);

        driver.quit();
    }

    public void checkPrice(WebElement price) {
        String color = price.getCssValue("color");
        String textDecoration = price.getCssValue("text-decoration");

        int[] rgb = parseColor(color);
        assertEquals(rgb[0], rgb[1]);
        assertEquals(rgb[1], rgb[2]);
        assertTrue(textDecoration.contains("line-through"));
    }

    public int[] parseColor(String color) {
        String[] numbers;
        if (color.contains("rgba")) numbers = color.replace("rgba(", "").replace(")", "").split(",");
        else numbers = color.replace("rgb(", "").replace(")", "").split(",");
        int r = Integer.parseInt(numbers[0].trim());
        int g = Integer.parseInt(numbers[1].trim());
        int b = Integer.parseInt(numbers[2].trim());

        return new int[]{r, g, b};
    }

    public void checkSalePrice(WebElement price) {
        String color = price.getCssValue("color");
        String fontWeight = price.getCssValue("font-weight");

        int[] rgb = parseColor(color);

        assertEquals(0, rgb[1]);
        assertEquals(0, rgb[2]);
        int fontWeightValue = Integer.parseInt(fontWeight);
        assertTrue(fontWeightValue > 100);
    }

    public void compareFontSizes(WebElement price, WebElement salePrice) {
        String main = price.getCssValue("font-size");
        String sale = salePrice.getCssValue("font-size");

        double sizeMain = parseFontSize(main);
        double sizeSale = parseFontSize(sale);

        assertTrue(sizeSale > sizeMain);
    }

    public double parseFontSize(String fontSize) {
        String size = fontSize.replace("px", "");
        return Double.parseDouble(size);
    }
}