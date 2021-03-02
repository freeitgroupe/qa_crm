package ru.stqa.pft.addressbook.lessons_70.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.lessons_70.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  //По факту создаем объект вспомогательного класса
  //ApplicationManager(BrowserType.CHROME) - передаем тип драйвера который будем использовать при тесте
  protected static final ApplicationManager
          //app = new ApplicationManager(BrowserType.OPERA);
          app = new ApplicationManager(System.getProperty("browser", BrowserType.OPERA));


  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void teardown(){
    app.stop();
  }

  /*
  * alwaysRun = true - говорит о том что метод всегда запустится внезависимости прошел тест или нет
  * Method m - информация о методе, который сейчас запускается
  * */
  @BeforeMethod(alwaysRun = true)
  public void logTestStart(Method m){
    logger.info("Start test " + m.getName());
  }

  /*
  * alwaysRun = true - говорит о том что метод всегда запустится внезависимости прошел тест или нет
  * Method m - информация о методе, который сейчас запускается
  * */
  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m, Object[] p){
    logger.info("Stop test" + m.getName() + " with parameters " + Arrays.asList(p));
  }

}
