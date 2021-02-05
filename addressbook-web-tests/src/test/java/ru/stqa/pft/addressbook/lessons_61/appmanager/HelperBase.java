package ru.stqa.pft.addressbook.lessons_61.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

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
    //если text = !null, тогда переходим к заполнению полей.
    if(text != null){
      //Если параметр в переменной text есть, то сначала посмотрим что за параметр лежит в поле ввода
      String existingText = driver.findElement(locator).getAttribute("value");
      //Проверим не совпадает ли этот параметр со старым параметром и тогда вводим данные
      if(! text.equals(existingText)){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
      }
    }
  }

  public void attach(By locator, File file) {
    //если text = !null, тогда переходим к заполнению полей.
    if(file != null){
        driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }
  }

  /*позволяет проверить наличие диалового окна в веб-приложении */
  public boolean isAlertPresent(){
    try{
      driver.switchTo().alert();
      return true;
    }catch(NoAlertPresentException e){
      return false;
    }
  }

    protected boolean isElementPresent(By locator) {
      try{
        driver.findElement(locator);
        return true;
      }catch (NoSuchElementException ex){
        return  false;
      }
    }
}
