package ru.stqa.pft.addressbook.lessons_27.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import ru.stqa.pft.addressbook.lessons_27.appmanager.ApplicationManager;

public class TestBase {
  //По факту создаем объект вспомогательного класса
  protected final ApplicationManager app = new ApplicationManager();

  @BeforeClass
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void teardown(){
    app.stop();
  }

}
