package ru.stqa.pft.addressbook.lessons_59.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_59.model.GroupData;
import ru.stqa.pft.addressbook.lessons_59.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Groups before = app.group().all();
    //получаем у множества итератор и получаем какой либо элемент
    GroupData deletedGroup = before.iterator().next();
    //передаем удаляемую группу
    app.group().delete(deletedGroup);
    //Проверяем размер списка до и после создания теста
    assertThat(app.group().count(), equalTo(before.size() - 1));
    //Размер списка после теста для удаления группы
    Groups after = app.group().all();
    assertThat(after, equalTo(before.without(deletedGroup)));
  }

}
