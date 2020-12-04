package ru.stqa.pft.addressbook.lessons_35.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.lessons_35.model.ContactData;

public class ContactHelper extends HelperBase {
  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  /* Клик по кнопке создания контактов */
  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  /* Клик по кнопке модификации контактов */
  public void initContactModification(){
    click(By.xpath("//a[contains(@href,'edit.php?id=1')]"));
  }

  /*Возврат на главную страницу*/
  public void returnToHomePage(){click(By.linkText("home page"));}

  /*Клик по кнопке создания группы*/
  public void submitContactCreation() {
    click(By.name("submit"));
  }

  /*Клик по кнопке для сохранения результата*/
  public void submitContactModification() {
    click(By.name("update"));
  }

  /*Заполнение полей формы*/
  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
  }





}
