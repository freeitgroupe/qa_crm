package ru.stqa.pft.addressbook.lessons_45.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_45.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    //переход на страницу группы
    app.getNavigationHelper().gotoGroupPage();
    //Проверка на наличие группы
    if(!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test4", null, "test4"));
    }
    //список групп до создания теста
    List<GroupData> before = app.getGroupHelper().getGroupList();
    //выбор группы
    app.getGroupHelper().selectGroup(before.size() - 1);
    //удаление выбранной группы
    app.getGroupHelper().deleteSelectedGroups();
    //возвращаемся на страницу группы
    app.getGroupHelper().returnToGroupPage();
    //Размер списка после теста для удаления группы
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //Проверяем размер списка до и после создания теста
    Assert.assertEquals(after.size(), before.size() - 1);

    //сравнениваем списки групп до удаления и после
    before.remove(before.size()-1);//выполняем для удаления одного элемента из списка
    Assert.assertEquals(before, after);

  }

}
