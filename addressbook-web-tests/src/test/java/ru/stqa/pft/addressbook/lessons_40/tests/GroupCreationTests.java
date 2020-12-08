package ru.stqa.pft.addressbook.lessons_40.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_40.model.GroupData;

public class GroupCreationTests extends TestBase {

  //Тест для создания группы
  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();//переход а страницу группы
    //шаги по созданию группы
    app.getGroupHelper().createGroup(new GroupData("test4", null, "test4"));
  }


}
