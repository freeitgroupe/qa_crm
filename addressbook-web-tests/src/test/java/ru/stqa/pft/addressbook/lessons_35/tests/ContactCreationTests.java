package ru.stqa.pft.addressbook.lessons_35.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_35.model.ContactData;

public class ContactCreationTests extends TestBase {

  //Тест для создания группы
  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactCreation();
    //app.click(By.linkText("add new"));
    app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }


}
