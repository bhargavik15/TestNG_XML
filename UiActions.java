package testng_xml;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class UiActions {
    static WebDriver driver;
    static WebElement isElementPresent;
    String url="https://www.facebook.com";
    String user_Id="email";
    String user_password="pass";
    String login_button="//button[@type='submit']";
      @BeforeTest
        public  void openUrl() throws IOException {


            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(url);
          System.out.println(driver.getTitle());
        }
            @Test
             public  boolean enterUserName() {

                isElementPresent = driver.findElement(By.id(user_Id));
                boolean flag = false;
                if (isElementPresent.isEnabled()) {
                    isElementPresent.sendKeys("chinni");
                    flag = true;
                }
                return flag;
            }
            @Test
            public boolean enterUserPassword() {

          isElementPresent = driver.findElement(By.id(user_password));
                boolean flag = false;
                if (isElementPresent.isEnabled()) {
                    isElementPresent.sendKeys("123456789");
                    flag = true;
                }
                return flag;
            }
            @Test
           public boolean Login() throws InterruptedException {

                isElementPresent = driver.findElement(By.xpath(login_button));
                isElementPresent.click();
                Thread.sleep(2000);
                boolean flag = false;
                if (isElementPresent.isEnabled()) {
                    flag = true;
                }
                return flag;
            }

            @AfterTest
            void close(){
            driver.quit();
        }
}



















