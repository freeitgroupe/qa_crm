package ru.stqa.pft.addressbook.lessons_46.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_46.model.ContactData;

public class ContactCreationTests extends TestBase {

  //Тест для создания группы
  @Test
  public void testContactCreation() throws Exception {
    //test4 - указываем так как есть такая группа в списке в противном случае тест упадет
    app.getContactHelper().creationContact(new ContactData("test_name", "test_surname", "test4"), true);
  }
}
