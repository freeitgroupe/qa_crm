package ru.stqa.pft.addressbook.lessons_59.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_59.model.ContactData;

import java.io.File;

public class ContactCreationTests extends TestBase {

  //Тест для создания группы
  @Test(enabled = true)
  public void testContactCreation() {
    //test4 - указываем так как есть такая группа в списке в противном случае тест упадет
    //app.getContactHelper().creationContact(new ContactData().all(), true);
    app.goTo().gotoHomePage();//переход на домашний адрес сайта
    app.contact().initContactCreation(); //click on btn "add new"
    File photo = new File("src/test/resources/test.jpg");
    app.contact()
            .fillContactForm(
            new ContactData()
                    .withFirstname("test_name")
                    .withLastname("test_surname")
                    .withPhoto(photo), true);
    app.contact().submitContactCreation();
    app.contact().returnToHomePage();

  }

/*  @Test
  public void testCurrentDir(){
    File currentDir = new File("."); //Current directory of project
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/test.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }*/

}
