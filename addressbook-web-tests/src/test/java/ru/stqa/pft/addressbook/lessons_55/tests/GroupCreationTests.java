package ru.stqa.pft.addressbook.lessons_55.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_55.model.GroupData;
import ru.stqa.pft.addressbook.lessons_55.model.Groups;

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
    assertThat(app.group().count(), equalTo(before.size()+1));
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

    //Тест для создания группы
    @Test
    public void testBadGroupCreation() throws Exception {
        //переход а страницу группы
        app.goTo().groupPage();
        //список групп до создания теста
        Groups before = app.group().all();
        //Создадим переменную типа GroupData
        GroupData group =  new GroupData().withName("test'");
        //создание группы
        app.group().create(group);
        //Проверка предварительная
        assertThat(app.group().count(), equalTo(before.size()));
        //Список групп
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }
}
