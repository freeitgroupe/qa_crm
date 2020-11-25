package ru.stqa.pft.addressbook.lessons_23;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

  //Тест для создания группы
  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();//переход а страницу группы
    initGroupCreation();//переход на форму создания группы
    fillGroupForm(new GroupData("test4", "test4", "test4"));//заполнение полей группы
    submitGroupCreation();//отправка
    returnToGroupPage();// возвращаемся на страницу группы
  }


}
