package ru.stqa.pft.addressbook.lessons_69.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_69.model.GroupData;
import ru.stqa.pft.addressbook.lessons_69.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  Logger logger = LoggerFactory.getLogger(GroupDeletionTests.class);

  @DataProvider
  public Iterator<Object[]> validGroupsFromXml() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    // BufferedReader - буферизирует прочитанные символы
    try( BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml"))) ){
      String xml = "";
      // читаем строку и переходим на следующую
      String line = reader.readLine();
      // Чтобы прочитать все строки, надо пройтись циклом по буферу с данными
      while(line != null){
        xml+= line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(GroupData.class);
      List<GroupData> groups = (List<GroupData>)xstream.fromXML(xml);
      return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();

    }catch (IOException ex) {
      System.err.format("IOException: %s%n", ex);
    }
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    // BufferedReader - буферизирует прочитанные символы
    try( BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json"))) ){
      String json = "";
      // читаем строку и переходим на следующую
      String line = reader.readLine();
      // Чтобы прочитать все строки, надо пройтись циклом по буферу с данными
      while(line != null){
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType());
      return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }

  //Тест для создания группы
  @Test(dataProvider = "validGroupsFromJson")
  public void testGroupCreation(GroupData group) {
    logger.info("Start test testGroupCreation");
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
    logger.info("Stop test testGroupCreation");

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
