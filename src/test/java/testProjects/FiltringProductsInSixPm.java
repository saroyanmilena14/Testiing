package testProjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FiltringProductsInSixPm {
    @Test
    public void testPricesFiltring() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.6pm.com");
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement menuAccessories = driver.findElement(By.xpath("//a[@href='/c/accessories']"));
        actions.moveToElement(menuAccessories).build().perform();
        Thread.sleep(2000);
        WebElement sunglasses = driver.findElement(By.xpath("//a[text()='Sunglasses']"));
        actions.moveToElement(sunglasses);
        actions.click().build().perform();
        Thread.sleep(3000);
        WebElement pricesUnder25 = driver.findElement(By.xpath("//span[text()='$25.00 and Under']"));
        pricesUnder25.click();
        Thread.sleep(2000);
        List<WebElement> pricesSunglasses = driver.findElements(By.cssSelector("#searchPage article span[itemprop=price]"));

        for (WebElement elem : pricesSunglasses) {
            String price = elem.getText();
            String priceWithout$ = price.substring(1);
            System.out.println(Double.parseDouble(priceWithout$));
            Assert.assertTrue(Double.parseDouble(priceWithout$) <= 25.00, "Price should be under $25.00");
        }
        driver.quit();

    }
}
