package ru.stqa.pft.addressbook.lessons_53.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_53.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test(enabled = false)
    public void testContactModification(){
        app.goTo().gotoHomePage();
        //Проверка на наличие группы
        if (!app.getContactHelper().isThereContact()){
            app.getContactHelper().creationContact(new ContactData("test_name", "test_surname", "test4"), true);
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}

