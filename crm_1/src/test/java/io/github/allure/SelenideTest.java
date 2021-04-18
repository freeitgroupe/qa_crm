package io.github.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.github.allure.NamedBy.css;

public class SelenideTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String USER = "eroshenkoam";
    private final static int ISSUE_NUMBER = 68;

    @Test
    public void SearchForIssue(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(css(".header-search-input").as("Поисковая строка")).click();
        $(css(".header-search-input").as("Поисковая строка")).sendKeys(REPOSITORY);
        $(css(".header-search-input").as("Поисковая строка")).submit();

        $(By.linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
    }

}
