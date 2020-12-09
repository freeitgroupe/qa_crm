package ru.stqa.pft.addressbook.lessons_41.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_41.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();//переход на страницу группы
    //количество групп до создания теста
    int before = app.getGroupHelper().getGroupCount();
    //Проверка на наличие группы
    if(!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test4", null, "test4"));
    }
    app.getGroupHelper().selectGroup();//выбор группы
    app.getGroupHelper().deleteSelectedGroups();//удаление выбранной группы
    app.getGroupHelper().returnToGroupPage();//возвращаеися на страницу группы
    //количество групп после теста для создания группы
    int after = app.getGroupHelper().getGroupCount();
    //Проверякм количество групп до и после создания теста
    Assert.assertEquals(after, before - 1);
  }

}
