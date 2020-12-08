package ru.stqa.pft.addressbook.lessons_40.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_40.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();//переход на страницу группы
    //Проверка на наличие группы
    if(!app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test4", null, "test4"));
    }
    app.getGroupHelper().selectGroup();//выбор группы
    app.getGroupHelper().deleteSelectedGroups();//удаление выбранной группы
    app.getGroupHelper().returnToGroupPage();//возвращаеися на страницу группы
  }

}
