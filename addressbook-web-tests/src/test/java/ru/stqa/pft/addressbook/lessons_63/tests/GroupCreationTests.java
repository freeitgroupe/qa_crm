package ru.stqa.pft.addressbook.lessons_63.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_63.model.GroupData;
import ru.stqa.pft.addressbook.lessons_63.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    // BufferedReader - буферизирует прочитанные символы
    try( BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv"))) ){
      // читаем строку и переходим на следующую строку
      String line = reader.readLine();
      // Чтобы прочитать все строки, надо пройтись циклом по буферу с данными
      while(line != null){
        // Разбиваем строку на отдельные подстроки и формируем массив
        String[] split =  line.split(";");
        list.add(new Object[]{
                new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])
        });
        line = reader.readLine();
      }
    }catch (IOException ex) {
        System.err.format("IOException: %s%n", ex);
      }
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
