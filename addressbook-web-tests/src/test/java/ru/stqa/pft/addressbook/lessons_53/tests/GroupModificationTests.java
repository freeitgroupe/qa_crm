package ru.stqa.pft.addressbook.lessons_53.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_53.model.GroupData;
import ru.stqa.pft.addressbook.lessons_53.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Groups before = app.group().all();
    GroupData modifieGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifieGroup.getId())
            .withName("test4")
            .withHeader( "testModifHeader")
            .withFooter("testModifTester");
    app.group().modify(group);
    //список групп после теста для создания группы
     Groups after = app.group().all();
    //Проверяем размер списка до и после создания теста
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifieGroup).withAdded(group)));
  }


}