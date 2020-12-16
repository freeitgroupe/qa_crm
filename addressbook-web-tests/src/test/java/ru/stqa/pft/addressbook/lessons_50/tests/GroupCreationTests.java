package ru.stqa.pft.addressbook.lessons_50.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_50.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  //Тест для создания группы
  @Test
  public void testGroupCreation() throws Exception {
    //переход а страницу группы
    app.goTo().groupPage();
    //список групп до создания теста
    List<GroupData> before = app.group().list();
    //Создадим переменную типа GroupData
    GroupData group =  new GroupData("test4", null, null);
    //создание группы
    app.group().create(group);
    //Список групп после создания группы
    List<GroupData> after = app.group().list();
    //Проверяем количество групп до и после создания теста
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(group);
    //Сравнение при помощи вспомогательного объекта компаратора
    //Сравнивателб для двух объектов
    Comparator<? super GroupData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());

    before.sort(byId);
    after.sort(byId);

    //преобразовали списки before и after в множества (неопорядчные списки)
    Assert.assertEquals(before, after);
    
  }
}
