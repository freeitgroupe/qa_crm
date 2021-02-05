package ru.stqa.pft.addressbook.lessons_63.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_63.model.GroupData;
import ru.stqa.pft.addressbook.lessons_63.model.Groups;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws FileNotFoundException {
    List<Object[]> list = new ArrayList<Object[]>();
    Reader reader = new FileReader(new File("src/test/resource/groups.csv"));
    return list.iterator();
  }

  //Тест для создания группы
  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
      app.goTo().groupPage(); //переход а страницу группы
      Groups before = app.group().all(); //список групп до создания теста
      app.group().create(group);  //создание группы
      Groups after = app.group().all();  //Список групп
      //Проверяем количество групп до и после создания теста
      Assert.assertEquals(after.size(), before.size() + 1);
      //Проверка
      assertThat(app.group().count(), equalTo(before.size()+1));
      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

    //Тест для создания группы
    @Test(enabled = false)
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
