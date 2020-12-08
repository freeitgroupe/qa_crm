package ru.stqa.pft.addressbook.lessons_40.appmanager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.lessons_40.model.GroupData;

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
  public void selectGroup() {
    click(By.name("selected[]"));
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
  public void createGroup(GroupData group) {
    initGroupCreation();//переход на форму создания группы
    fillGroupForm(group);//заполнение полей группы
    submitGroupCreation();//отправка
    returnToGroupPage();// возвращаемся на страницу группы
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }
}
