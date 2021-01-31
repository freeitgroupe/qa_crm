package ru.stqa.pft.addressbook.lessons_58.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_58.model.GroupData;
import ru.stqa.pft.addressbook.lessons_58.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    //Проверяем размер списка до и после создания теста
    assertThat(app.group().count(), equalTo(before.size()));
    //список групп после теста для создания группы
     Groups after = app.group().all();
    assertThat(after, equalTo(before.without(modifieGroup).withAdded(group)));
  }


}
