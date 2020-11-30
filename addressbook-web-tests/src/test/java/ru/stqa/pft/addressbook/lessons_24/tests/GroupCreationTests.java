package ru.stqa.pft.addressbook.lessons_24.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_24.model.GroupData;

public class GroupCreationTests extends TestBase {

  //Тест для создания группы
  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();//переход а страницу группы
    app.initGroupCreation();//переход на форму создания группы
    app.fillGroupForm(new GroupData("test4", "test4", "test4"));//заполнение полей группы
    app.submitGroupCreation();//отправка
    app.returnToGroupPage();// возвращаемся на страницу группы
  }


}
