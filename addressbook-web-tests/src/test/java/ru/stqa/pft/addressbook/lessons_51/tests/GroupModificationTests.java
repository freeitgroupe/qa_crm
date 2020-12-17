package ru.stqa.pft.addressbook.lessons_51.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_51.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod//аннотация, которая говорит о том, что метод будет выполняться перед каждым тестом
  public void ensurePreconditons(){
    //переход на страницу группы
    app.goTo().groupPage();
    //Проверка на наличие группы
    if(app.group().list().size() == 0){
      app.group().create(new GroupData().withName("test4"));
    }
  }

  @Test
  public void testGroupModification() throws Exception{
    app.goTo().groupPage();//переход на страницу группы
    //список групп до создания теста
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group = new GroupData()
            .withId(before.get(index).getId())
            .withName("test4")
            .withHeader( "testModifHeader")
            .withFooter("testModifTester");
    app.group().modify(index, group);

    //список групп после теста для создания группы
    List<GroupData> after = app.group().list();
    //Проверяем размер списка до и после создания теста
    Assert.assertEquals(after.size(), before.size());

    //удалили элемент из списка
    before.remove(index);
    //добавили элемент в список
    before.add(group);

    //Сортировка списка
    Comparator<? super GroupData> byId = (g1, g2)->Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    before.sort(byId);
    Assert.assertEquals(before, after);


  }


}
