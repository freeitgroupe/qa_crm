package ru.stqa.pft.addressbook.lessons_48.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.lessons_48.appmanager.ApplicationManager;

public class TestBase {
  //По факту создаем объект вспомогательного класса
  //ApplicationManager(BrowserType.CHROME) - передаем тип драйвера который будем использовать при тесте
  protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void teardown(){
    app.stop();
  }

}
