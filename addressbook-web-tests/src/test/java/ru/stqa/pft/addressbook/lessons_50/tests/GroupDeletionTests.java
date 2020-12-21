package ru.stqa.pft.addressbook.lessons_50.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_50.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod//аннотация, которая говорит о том, что метод будет выполняться перед каждым тестом
  public void ensurePreconditons(){
    //переход на страницу группы
    app.goTo().groupPage();
    //Проверка на наличие группы
    if(app.group().list().size() == 0){
      app.group().create(new GroupData("test4", null, "test4"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {

    //список групп до создания теста
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);


    //Размер списка после теста для удаления группы
    List<GroupData> after = app.group().list();
    //Проверяем размер списка до и после создания теста
    Assert.assertEquals(after.size(), before.size() - 1);

    //сравнениваем списки групп до удаления и после
    before.remove(before.size()-1);//выполняем для удаления одного элемента из списка
    Assert.assertEquals(before, after);

  }

}
