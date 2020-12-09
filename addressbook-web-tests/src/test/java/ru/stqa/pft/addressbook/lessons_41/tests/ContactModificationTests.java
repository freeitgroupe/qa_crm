package ru.stqa.pft.addressbook.lessons_41.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_41.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getNavigationHelper().gotoHomePage();
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

