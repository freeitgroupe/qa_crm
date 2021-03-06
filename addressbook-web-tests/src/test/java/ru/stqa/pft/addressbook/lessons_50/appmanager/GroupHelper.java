package ru.stqa.pft.addressbook.lessons_50.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.lessons_50.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver driver) {
    super(driver);
  }

  /*Возврат к списку группы*/
  public void returnToGroupPage() {
    click(By.xpath("//div[@id='content']/div"));
    click(By.linkText("group page"));
  }
  /*Клик по кнопке создания группы*/
  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  /*Заполнение полей формы*/
  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  /*Создание группы а именно Клик по кнопке создания группы*/
  public void initGroupCreation() {
    click(By.name("new"));
  }

  /*Удаление группы а именно клик по кнопке удаления группы*/
  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  /*Выбор группы, а именно клик по указанному checkbox */
  public void selectGroup(int index) {
    driver.findElements(By.name("selected[]")).get(index).click();
  }

  /*Клик по кнопке модификации группы*/
  public void initGroupModification(){
    click(By.name("edit"));
  }

  /*Клик по кнопке для сохранения результата*/
  public void submitGroupModification() {
    click(By.name("update"));
  }

  /* метод, который включает шаги создания группы */
  public void create(GroupData group) {
    initGroupCreation();//переход на форму создания группы
    fillGroupForm(group);//заполнение полей группы
    submitGroupCreation();//отправка
    returnToGroupPage();// возвращаемся на страницу группы
  }

  /* Метод который включает шаги модификации данных в группе*/
  public void modify(int index, GroupData group) {
    //Выбор группы (before.size() - 1) - последний элемент в списке
    selectGroup(index);
    //переход на страницу редактирования группы
    initGroupModification();
    //указываем необходимые поля заполнения  для группы
    fillGroupForm(group);
    //отправка сохранений
    submitGroupModification();
    // возвращаемся на страницу группы
    returnToGroupPage();
  }
  /* шаги по удвлению группы */
  public void delete(int index) {
    //выбор группы
    selectGroup(index);
    //удаление выбранной группы
    deleteSelectedGroups();
    //возвращаемся на страницу группы
    returnToGroupPage();
  }

  /* Проверяем наличие групп */
  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  /* Подсчитываем количество элементов со следующем именем "selected[]" и возвращаем их количество */
  public int getGroupCount(){
    return driver.findElements(By.name("selected[]")).size();
  }

  /* Получаем список групп */
  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData(id, name, null, null);
      groups.add(group);
    }
    return groups;
  }
}
