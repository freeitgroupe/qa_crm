package ru.stqa.pft.addressbook.lessons_59.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.lessons_59.model.ContactData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  /* Клик по кнопке создания контактов */
  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  /* Клик по кнопке модификации контактов */
  public void initContactModification(){
    click(By.xpath("//a[contains(@href,'edit.php?id=1')]"));
  }

  /*Возврат на главную страницу*/
  public void returnToHomePage(){click(By.linkText("home"));}

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
    attach(By.name("photo"), contactData.getPhoto());

    //проверка параметра creation на вид теста
    if(creation){
        //если используем тест создания  контактов чекаем поле группы
        new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }else{
        //проверяем на отсутствие поля new group в форме в случае теста модификации
        Assert.assertFalse(isElementPresent(By.name("new group")));
    }
  }

  /* Метод который включает шаги создания контактов */
  public void creationContact(ContactData contact, boolean creation){
    initContactCreation();
    fillContactForm(contact, creation);
    submitContactCreation();
    returnToHomePage();
  }


  public boolean isThereContact() {
    return isElementPresent(By.cssSelector("img[alt='Edit']"));
  }

  public void selectContact() {
    click(By.cssSelector("img[alt='Edit']"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }


  public Set<ContactData> all(){
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = driver.findElements(By.name("entry"));
    for(WebElement row : rows){
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      //String[] phones = cells.get(5).getText().split("\n");
      String allPhones = cells.get(5).getText();

      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
      .withAllPhones(allPhones));
    }
    return contacts;
  }

  /*Получаем данные формы*/
  public ContactData infoFromEditForm(ContactData contact){
    initContactModificationById(contact.getId());
    String firstName = driver.findElement(By.name("firstname")).getAttribute("value");
    String lastName = driver.findElement(By.name("lastname")).getAttribute("value");
    String home = driver.findElement(By.name("home")).getAttribute("value");
    String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
    String work = driver.findElement(By.name("work")).getAttribute("value");
    driver.navigate().back();

    return new ContactData().withId(contact.getId()).withFirstname(firstName).withLastname(lastName).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

  /*Находим элемент или тег по которому необходимо кликнуть для перехода на страницу редактирования */
  private void initContactModificationById(int id){
    WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));//получили значение id
    WebElement row = checkbox.findElement(By.xpath("./../.."));//нашли нужную > ячейук > строку
    List<WebElement> cells = row.findElements(By.tagName("td"));//находим все элементы с тегом td
    cells.get(7).findElement(By.tagName("a")).click();// В этих элементах находим 7-й по счету тег с тегом "a" и кликаем по нему
  }




}
