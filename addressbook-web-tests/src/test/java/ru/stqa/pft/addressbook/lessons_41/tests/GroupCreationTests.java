package ru.stqa.pft.addressbook.lessons_41.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_41.model.GroupData;

public class GroupCreationTests extends TestBase {

  //Тест для создания группы
  @Test
  public void testGroupCreation() throws Exception {
    //переход а страницу группы
    app.getNavigationHelper().gotoGroupPage();
    //количество групп до создания теста
    int before = app.getGroupHelper().getGroupCount();
    //создание группы
    app.getGroupHelper().createGroup(new GroupData("test4", null, "test4"));
    //количество групп после теста для создания группы
    int after = app.getGroupHelper().getGroupCount();
    //Проверякм количество групп до и после создания теста
    Assert.assertEquals(after, before + 1);
  }


}
