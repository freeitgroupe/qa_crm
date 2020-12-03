package ru.stqa.pft.addressbook.lessons_31.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_31.model.GroupData;

public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification() throws Exception{
    app.getNavigationHelper().gotoGroupPage();//переход на страницу группы
    app.getGroupHelper().selectGroup();//Выбор группы
    app.getGroupHelper().initGroupModification();//переход на страницу редактирования группы
    app.getGroupHelper().fillGroupForm(new GroupData("testModifName", "testModifHeader", "testModifTester"));//указываем еобходимые поля группы
    app.getGroupHelper().submitGroupModification();//отправка сохранений
    app.getGroupHelper().returnToGroupPage();// возвращаемся на страницу группы
  }
}
