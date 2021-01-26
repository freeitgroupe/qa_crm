package ru.stqa.pft.addressbook.lessons_54.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_54.model.GroupData;
import ru.stqa.pft.addressbook.lessons_54.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  //Тест для создания группы
  @Test
  public void testGroupCreation() throws Exception {
    //переход а страницу группы
    app.goTo().groupPage();

    //список групп до создания теста
    Groups before = app.group().all();

    //Создадим переменную типа GroupData
    GroupData group =  new GroupData().withName("test4");

    //создание группы
    app.group().create(group);

    //Список групп
    Groups after = app.group().all();

    //Проверяем количество групп до и после создания теста
    Assert.assertEquals(after.size(), before.size() + 1);
    //Проверка
    assertThat(after.size(), equalTo(before.size()+1));
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
}
