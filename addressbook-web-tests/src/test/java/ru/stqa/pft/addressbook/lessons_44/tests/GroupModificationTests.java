package ru.stqa.pft.addressbook.lessons_44.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_44.model.GroupData;

import java.util.HashSet;
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
    //преобразовали списки before и after в множества (неопорядчные списки)
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));





  }
}
