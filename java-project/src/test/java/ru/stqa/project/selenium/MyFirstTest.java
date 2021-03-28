package ru.stqa.project.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest extends TestBase {

    /*
      private WebDriver driver;
      private WebDriverWait wait;
     @Before
    public void start(){
        //путь к драйверу в системе
        //System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        //driver = new ChromeDriver(options);
        //or
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(caps);
        //driver = new FirefoxDriver( new FirefoxBinary(new Files()));

        System.out.println( ((HasCapabilities) driver).getCapabilities()  );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }
    */

    @Test
    public void myFirstTest() throws UnsupportedEncodingException {
        String str = new String("webdriver - Поиск в Google".getBytes(), StandardCharsets.UTF_8);
        //driver.get("http://www.google.com"); or
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
        //driver.findElement(By.name("btnK")).click();
        wait.until(titleIs(str));

    }

    @Test
    public void mySecondTest() throws UnsupportedEncodingException {
        String str = new String("webdriver - Поиск в Google".getBytes(), StandardCharsets.UTF_8);
        //driver.get("http://www.google.com"); or
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
        //driver.findElement(By.name("btnK")).click();
        wait.until(titleIs(str));
    }

    /*
    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
    * */




}
