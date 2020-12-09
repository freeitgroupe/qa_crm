package ru.stqa.pft.addressbook.lessons_41.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_41.model.GroupData;

public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification() throws Exception{
    app.getNavigationHelper().gotoGroupPage();//переход на страницу группы
    //количество групп до создания теста
    int before = app.getGroupHelper().getGroupCount();
    //Проверка на наличие группы
    if(!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test4", null, "test4"));
    }
    app.getGroupHelper().selectGroup();//Выбор группы
    app.getGroupHelper().initGroupModification();//переход на страницу редактирования группы
    app.getGroupHelper().fillGroupForm(new GroupData("testModifName", "testModifHeader", "testModifTester"));//указываем еобходимые поля группы
    app.getGroupHelper().submitGroupModification();//отправка сохранений
    app.getGroupHelper().returnToGroupPage();// возвращаемся на страницу группы
    //количество групп после теста для создания группы
    int after = app.getGroupHelper().getGroupCount();
    //Проверякм количество групп до и после создания теста
    Assert.assertEquals(after, before);
  }
}
