package ru.stqa.pft.addressbook.lessons_54.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_54.model.ContactData;

public class ContactDeletionTests extends TestBase {
  @Test(enabled = false)
  public void testGroupDeletion() throws Exception {
    app.getContactHelper().returnToHomePage();//переход на страницу контактов
    //Проверка на наличие контактов
    if (!app.getContactHelper().isThereContact()){
      app.getContactHelper().creationContact(new ContactData("test_name", "test_surname", "test4"), true);
    }
    app.getContactHelper().selectContact();//выбор группы
    app.getContactHelper().deleteSelectedContact();//удаление выбранной группы
    app.getContactHelper().returnToHomePage();//возвращаеися на страницу группы
  }
}
