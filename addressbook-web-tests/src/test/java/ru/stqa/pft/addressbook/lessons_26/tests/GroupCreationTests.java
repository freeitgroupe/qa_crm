package ru.stqa.pft.addressbook.lessons_26.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_26.model.GroupData;

public class GroupCreationTests extends TestBase {

  //Тест для создания группы
  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();//переход а страницу группы
    app.getGroupHelper().initGroupCreation();//переход на форму создания группы
    app.getGroupHelper().fillGroupForm(new GroupData("test4", "test4", "test4"));//заполнение полей группы
    app.getGroupHelper().submitGroupCreation();//отправка
    app.getGroupHelper().returnToGroupPage();// возвращаемся на страницу группы
  }


}
