package ru.stqa.pft.addressbook.lessons_52.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_52.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

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
  public void testGroupModification() throws Exception{
    app.goTo().groupPage();//переход на страницу группы
    //список групп до создания теста
    Set<GroupData> before = app.group().all();
    GroupData modifieGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifieGroup.getId())
            .withName("test4")
            .withHeader( "testModifHeader")
            .withFooter("testModifTester");
    app.group().modify(group);

    //список групп после теста для создания группы
    Set<GroupData> after = app.group().all();

    //Проверяем размер списка до и после создания теста
    Assert.assertEquals(after.size(), before.size());

    //удалили элемент из списка
    before.remove(modifieGroup);

    //добавили элемент в список
    before.add(group);

    Assert.assertEquals(before, after);


  }


}
