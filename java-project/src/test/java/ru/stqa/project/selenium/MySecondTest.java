package ru.stqa.project.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MySecondTest extends TestBase {
    @Test
    public void myFirstTest() throws UnsupportedEncodingException {
        String str = new String("webdriver - Поиск в Google".getBytes(), StandardCharsets.UTF_8);
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
        wait.until(titleIs(str));
    }

    @Test
    public void mySecondTest() throws UnsupportedEncodingException {
        String str = new String("webdriver - Поиск в Google".getBytes(), StandardCharsets.UTF_8);
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
        wait.until(titleIs(str));
    }
}
