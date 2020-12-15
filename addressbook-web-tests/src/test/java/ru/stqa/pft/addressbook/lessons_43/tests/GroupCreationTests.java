package ru.stqa.pft.addressbook.lessons_43.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_43.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

  //Тест для создания группы
  @Test
  public void testGroupCreation() throws Exception {
    //переход а страницу группы
    app.getNavigationHelper().gotoGroupPage();
    //список групп до создания теста
    List<GroupData> before = app.getGroupHelper().getGroupList();
    //создание группы
    app.getGroupHelper().createGroup(new GroupData("test4", null, null));
    //Список групп после создания группы
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //Проверяем количество групп до и после создания теста
    Assert.assertEquals(after.size(), before.size() + 1);
  }


}
