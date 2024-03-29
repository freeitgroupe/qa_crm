package ru.stqa.pft.addressbook.lessons_53.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_53.model.GroupData;
import ru.stqa.pft.addressbook.lessons_53.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  //Тест для создания группы
  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();//переход а страницу группы
    Groups before = app.group().all();//список групп до создания теста
    GroupData group =  new GroupData().withName("test4");//Создадим переменную типа GroupData
    app.group().create(group); //создание группы
    Groups after = app.group().all();//Список групп

    //Проверяем количество групп до и после создания теста
    Assert.assertEquals(after.size(), before.size() + 1);
    //Проверка
    assertThat(after.size(), equalTo(before.size()+1));
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
}
