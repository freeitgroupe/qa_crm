package ru.stqa.pft.addressbook.lessons_48.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_48.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification() throws Exception{
    app.getNavigationHelper().gotoGroupPage();//переход на страницу группы

    //Проверка на наличие группы
    if(!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test4", null, "test4"));
    }

    //список групп до создания теста
    List<GroupData> before = app.getGroupHelper().getGroupList();
    //Выбор группы (before.size() - 1) - последний элемент в списке
    app.getGroupHelper().selectGroup(before.size() - 1);
    //переход на страницу редактирования группы
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size()-1).getId(),"testModifName", "testModifHeader", "testModifTester");
    //указываем необходимые поля заполнения  для группы
    app.getGroupHelper().fillGroupForm(group);
    //отправка сохранений
    app.getGroupHelper().submitGroupModification();
    // возвращаемся на страницу группы
    app.getGroupHelper().returnToGroupPage();
    //список групп после теста для создания группы
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //Проверяем размер списка до и после создания теста
    Assert.assertEquals(after.size(), before.size());

    //удалили элемент из списка
    before.remove(before.size()-1);
    //добавили элемент в список
    before.add(group);

    //Сортировка списка
    Comparator<? super GroupData> byId = (g1, g2)->Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    before.sort(byId);

    //преобразовали списки before и after в множества (неопорядчные списки)
    Assert.assertEquals(before, after);


  }
}
