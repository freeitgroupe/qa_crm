package ru.stqa.pft.addressbook.lessons_49.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_49.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod//аннотация, которая говорит о том, что метод будет выполняться перед каждым тестом
  public void ensurePreconditons(){
    //переход на страницу группы
    app.getNavigationHelper().gotoGroupPage();
    //Проверка на наличие группы
    if(!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test4", null, "test4"));
    }
  }

  @Test
  public void testGroupModification() throws Exception{
    app.getNavigationHelper().gotoGroupPage();//переход на страницу группы

    //список групп до создания теста
    List<GroupData> before = app.getGroupHelper().getGroupList();

    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(),"testModifName", "testModifHeader", "testModifTester");
    app.getGroupHelper().modifyGroup(index, group);


    //список групп после теста для создания группы
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //Проверяем размер списка до и после создания теста
    Assert.assertEquals(after.size(), before.size());

    //удалили элемент из списка
    before.remove(index);
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
