package testProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testingChrome {

    @Test

    public void TestingYoutubeButton() throws InterruptedException {

        System.setProperty( "webdriver.chrome.driver","C:\\Users\\Milena\\Desktop\\Milena\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://youtube.com");
        Thread.sleep(2000);
        driver.findElement(By.id("buttons")).click();
        Thread.sleep(2000);
        driver.quit();




    }
}
