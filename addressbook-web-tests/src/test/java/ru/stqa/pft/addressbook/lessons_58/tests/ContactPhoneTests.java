package ru.stqa.pft.addressbook.lessons_58.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.lessons_58.model.ContactData;

import java.util.Arrays;
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

        /**/
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact){
        return Stream.of(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .filter((s)-> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    /*Очищаем номер телефона от сторонних символов а именно "()", "-", "[space]"  */
    /* replaceAll("\\s","") - убираем пробелы
     *  replaceAll("[-()]","") - убираем скобки и тире.
     *  */
    private static String cleaned(String phone)  {
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
