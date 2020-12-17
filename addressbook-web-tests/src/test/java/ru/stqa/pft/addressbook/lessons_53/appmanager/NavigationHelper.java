package ru.stqa.pft.addressbook.lessons_53.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void groupPage() {
    //проверяем есть ли элементы следующих типов, если да, то тогда завершаем условия и выходим
    if(isElementPresent(By.tagName("h1"))
            && driver.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new")) ){
      return;
    }else{
      //Если не найдены выше перечисленные элементы тогда переходим по ссылке с текстом groups
      click(By.linkText("groups"));
    }


  }

  public void gotoHomePage() {
    if(isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
  }
}
