package ru.stqa.pft.addressbook.lessons_45.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  protected WebDriver driver;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String browser;

  /* Конструктор в который передаем тип драйвера, который будем использовать */
  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if(browser.equals(BrowserType.FIREFOX)){
      //путь к драйверу в системе
      System.setProperty("webdriver.gecko.driver", "C:\\webdriver\\bin\\geckodriver.exe");
      driver = new FirefoxDriver();

    }else if(browser.equals(BrowserType.CHROME)){
      //путь к драйверу в системе
      System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\bin\\chromedriver.exe");
      driver = new ChromeDriver();
    }else if(browser.equals(BrowserType.IE)){
      //Если путь драйвера не указывать тогда драйвера надо поместить в системную папку, путь к которой прописан в системемную переменную PATH используя переменные среды системы
      driver = new InternetExplorerDriver();
    }

    //System.setProperty("webdriver.gecko.driver", "C:\\webdriver\\bin\\geckodriver.exe");
    //System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\bin\\chromedriver.exe");
    //driver = new FirefoxDriver();

    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    //Logging in CRM
    //driver.get("http://addressbook/");
    driver.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(driver);
    contactHelper = new ContactHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    //close browser
    try {
      sessionHelper.logout();//Выйти с личного кабинета
      Thread.sleep(3000);
      driver.close();
    }
    catch (Exception e)    {
      System.out.println("Caught message " + e.getMessage());
      driver.close();
    }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}

