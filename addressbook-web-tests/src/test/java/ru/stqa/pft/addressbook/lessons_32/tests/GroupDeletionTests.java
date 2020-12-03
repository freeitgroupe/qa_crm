package ru.stqa.pft.addressbook.lessons_32.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();//переход на страницу группы
    app.getGroupHelper().selectGroup();//выбор группы
    app.getGroupHelper().deleteSelectedGroups();//удаление выбранной группы
    app.getGroupHelper().returnToGroupPage();//возвращаеися на страницу группы
  }

}
