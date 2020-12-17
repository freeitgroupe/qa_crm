package ru.stqa.pft.addressbook.lessons_53.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_53.model.GroupData;

import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod//аннотация, которая говорит о том, что метод будет выполняться перед каждым тестом
  public void ensurePreconditons(){
    //переход на страницу группы
    app.goTo().groupPage();
    //Проверка на наличие группы
    if(app.group().all().size() == 0){
      app.group().create(new GroupData().withName("test4"));
    }
  }

  @Test
  public void testGroupDeletion() {
    //список групп до создания теста
    Set<GroupData> before = app.group().all();
    //получаем у множества итератор и получаем какой либо элемент
    GroupData deleteGroup = before.iterator().next();
    //передаем удаляемую группу
    app.group().delete(deleteGroup);

    //Размер списка после теста для удаления группы
    Set<GroupData> after = app.group().all();

    //Проверяем размер списка до и после создания теста
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deleteGroup);//выполняем для удаления одного элемента из списка
    Assert.assertEquals(before, after);

  }

}
