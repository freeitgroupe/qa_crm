package ru.stqa.project.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    // инициализируется хранилище потока
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start(){
        if(tlDriver.get() != null){
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
        }
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(caps);
        // привязали драйвер к текущему потоку
        tlDriver.set(driver);
        System.out.println( ((HasCapabilities) driver).getCapabilities()  );
        wait = new WebDriverWait(driver, 10);

        //ShutdownHook который выполняется в самом конце
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {driver.quit(); driver = null; })
        );
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
