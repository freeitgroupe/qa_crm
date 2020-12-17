package ru.stqa.pft.addressbook.lessons_53.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_53.model.GroupData;

import java.util.Set;

public class GroupCreationTests extends TestBase {

  //Тест для создания группы
  @Test
  public void testGroupCreation() throws Exception {
    //переход а страницу группы
    app.goTo().groupPage();

    //список групп до создания теста
    Set<GroupData> before = app.group().all();

    //Создадим переменную типа GroupData
    GroupData group =  new GroupData().withName("test4");

    //создание группы
    app.group().create(group);

    //Список групп
    Set<GroupData> after = app.group().all();

    //Проверяем количество групп до и после создания теста
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    //преобразовали списки before и after в множества (неопорядчные списки)
    Assert.assertEquals(before, after);
    
  }
}
