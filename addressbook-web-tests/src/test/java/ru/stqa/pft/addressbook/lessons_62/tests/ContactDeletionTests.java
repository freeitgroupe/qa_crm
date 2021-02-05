package ru.stqa.pft.addressbook.lessons_62.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
  @Test(enabled = false)
  public void testGroupDeletion() throws Exception {
    app.contact().returnToHomePage();//переход на страницу контактов
    //Проверка на наличие контактов
    if (!app.contact().isThereContact()){
     // app.contact().creationContact(new ContactData("test_name", "test_surname", "test4"), true);
    }
    app.contact().selectContact();//выбор группы
    app.contact().deleteSelectedContact();//удаление выбранной группы
    app.contact().returnToHomePage();//возвращаеися на страницу группы
  }
}
