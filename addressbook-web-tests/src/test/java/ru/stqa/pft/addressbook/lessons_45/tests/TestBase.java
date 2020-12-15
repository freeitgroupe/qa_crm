package ru.stqa.pft.addressbook.lessons_45.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import ru.stqa.pft.addressbook.lessons_45.appmanager.ApplicationManager;

public class TestBase {
  //По факту создаем объект вспомогательного класса
  //ApplicationManager(BrowserType.CHROME) - передаем тип драйвера который будем использовать при тесте
  protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

  @BeforeClass
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void teardown(){
    app.stop();
  }

}
