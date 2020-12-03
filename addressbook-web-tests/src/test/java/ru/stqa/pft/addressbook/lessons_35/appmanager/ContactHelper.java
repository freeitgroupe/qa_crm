package ru.stqa.pft.addressbook.lessons_35.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.lessons_35.model.GroupData;

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
    click(By.cssSelector("img[alt='Edit']"));
  }

  /*Возврат к списку группы*/
  public void returnToGroupPage() {
    click(By.xpath("//div[@id='content']/div"));
    click(By.linkText("group page"));
  }
  /*Клик по кнопке создания группы*/
  public void submitContactCreation() {
    click(By.name("submit"));
  }

  /*Заполнение полей формы*/
  public void fillContactForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }



  /*Удаление группы а именно клик по кнопке удаления группы*/
  public void deleteSelectedContact() {
    click(By.name("delete"));
  }

  /*Выбор группы, а именно клик по указанному checkbox */
  public void selectContact() {
    click(By.name("selected[]"));
  }


  /*Клик по кнопке для сохранения результата*/
  public void submitContactModification() {
    click(By.name("update"));
  }



}
