package ru.stqa.pft.addressbook.lessons_27.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  /*
  *  Метод, который описывает клик по определенному локатору
  * */
  protected void click(By locator) {
     driver.findElement(locator).click();
   }

  /*
  * Метод который описывает использование определенного локатора,
  * событие выбора локатора и событие ввода определенного текста в выбранный
  * локатор
  * */
  protected void type(By locator, String text) {
    click(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }
}
