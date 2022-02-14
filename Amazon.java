package testng_xml;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon {
    WebDriver driver;

    @BeforeTest
    public void openUrl(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");


    }
    @Test
    public void verifyTodaysDeals(){
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).click();
        System.out.println(driver.getTitle());
    }
    @Test
    public void verifyUserInfo(){
        System.out.println(driver.findElement(By.id("nav-swmslot")).isDisplayed());


    }
    @AfterTest
    public void close(){
        driver.close();
    }
}
