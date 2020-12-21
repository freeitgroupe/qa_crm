package ru.stqa.pft.addressbook.lessons_47.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_47.model.GroupData;

import java.util.Comparator;
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

    //Находим максимальный идентификатор
    //Первый метод
    int max = 0;
    for(GroupData g : after){
      if(g.getId() > max){
        max = g.getId();
      }
    }

    //Сравнение при помощи вспомогательного объекта компаратора
    //Сравнивателб для двух объектов
    Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());

    //Находим максимальный идентификатор
    //Второй метод с использование лямда выражения
    int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
    group.setId(max1);
    before.add(group);
    //Сортировка списка
    //Comparator<? super GroupData> byId = (g1, g2)->Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);

    //преобразовали списки before и after в множества (неопорядчные списки)
    Assert.assertEquals(before, after);


  }
}
