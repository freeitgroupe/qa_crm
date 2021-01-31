package ru.stqa.pft.addressbook.lessons_58.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test(enabled = false)
    public void testContactModification(){
        app.goTo().gotoHomePage();
        //Проверка на наличие группы
        if (!app.contact().isThereContact()){
            //app.contact().creationContact(new ContactData("test_name", "test_surname", "test4"), true);
        }
        app.contact().initContactModification();
        //app.contact().fillContactForm(new ContactData("test_name", "test_surname", null), false);
        app.contact().submitContactModification();
        app.contact().returnToHomePage();
    }
}

