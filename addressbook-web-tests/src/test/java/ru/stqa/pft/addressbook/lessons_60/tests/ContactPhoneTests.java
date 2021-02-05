package ru.stqa.pft.addressbook.lessons_60.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_60.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @Test(enabled = true)
    public void testContactCreation() throws Exception {
        //test4 - указываем так как есть такая группа в списке в противном случае тест упадет
        //app.getContactHelper().creationContact(new ContactData().all(), true);
        app.goTo().gotoHomePage();//переход на домашний адрес сайта
        ContactData contact= app.contact().all().iterator().next();// получаем один из элемнтов contact
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);// получили данные формы

        /* equal two params (phones)
        * contact.getAllPhones() - one param on page contact
        * mergePhones(contactInfoFromEditForm)) - second param on page editContact
        *   */
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    /* Combine all phones in one string */
    private String mergePhones(ContactData contact){
        return Stream.of(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

     /* Clearing data from "()", "-", "[space]"
     *  replaceAll("\\s","") - clearing from space
     *  replaceAll("[-()]","") - clearing data from oval brackets and dash.
     *  */
    private static String cleaned(String phone)  {
        return phone
                .replaceAll("\\s","")
                .replaceAll("[-()]","");
    }
}
