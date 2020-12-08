package ru.stqa.pft.addressbook.lessons_36.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.lessons_36.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  /* Клик по кнопке создания контактов */
  public void initContactCreation() {
    click(By.linkText("add new"));
    //click(By.name("groups"));
  }

  /* Клик по кнопке модификации контактов */
  public void initContactModification(){
    click(By.xpath("//a[contains(@href,'edit.php?id=1')]"));
  }

  /*Возврат на главную страницу*/
  public void returnToHomePage(){click(By.linkText("home page"));}

  /*Клик по кнопке создания группы*/
  public void submitContactCreation() {
    click(By.name("submit"));
  }

  /*Клик по кнопке для сохранения результата*/
  public void submitContactModification() {
    click(By.name("update"));
  }

  /*Заполнение полей формы*/
  //boolean creation - параметр по которому понимаем, какой тест используется (создания контакта или модификация контакта)
  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());

    if(creation){
        //если используем тест создания  контактов чекаем поле группы
        new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }else{
        //проверяем на отсутствие поля new group в форме в случае теста модификации
        Assert.assertFalse(isElementPresent(By.name("new group")));
    }

  }


}
