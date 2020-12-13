package ru.stqa.pft.addressbook.lessons_45.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_45.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  //Тест для создания группы
  @Test
  public void testGroupCreation() throws Exception {
    //переход а страницу группы
    app.getNavigationHelper().gotoGroupPage();
    //список групп до создания теста
    List<GroupData> before = app.getGroupHelper().getGroupList();
    //Создадим переменную типа GroupData
    GroupData group =  new GroupData("test4", null, null);
    //создание группы
    app.getGroupHelper().createGroup(group);
    //Список групп после создания группы
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //Проверяем количество групп до и после создания теста
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(group);
    //преобразовали списки before и after в множества (неопорядчные списки)
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}
