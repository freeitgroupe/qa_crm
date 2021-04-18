package io.github.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AnnotationStepsTest {
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String USER = "eroshenkoam";
    private final static int ISSUE_NUMBER = 68;

    @Test
    @DisplayName("Тест 1")
    @Feature("Issues")
    @Story("User should see issues in existing  repository")
    @Link(url = "https://github.com", name = "Тестинг")
    @Owner("Tykhonenko")
    @Severity(SeverityLevel.CRITICAL)
    public void SearchForIssue(){
        final BaseSteps steps = new BaseSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.goToIssues();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }

    public static class BaseSteps{
        //all steps for test complete
        @Step("Открываем главную страницу")
        public void openMainPage(){
            open("https://github.com");
        }

        @Step("Ищем репозиторий ${name}")
        public void searchForRepository(final String name){
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(name);
            $(".header-search-input").submit();
        }

        @Step("Переходим в репозиторий ${name}")
        public void goToRepository(final String name){
            $(By.linkText(name)).click();
        }

        @Step("Переходим в раздел Issues")
        public void goToIssues(){
            $(withText("Issues")).click();
        }

        @Step("Проверяем наличие Issue с номером ${number}")
        public void shouldSeeIssueWithNumber(final int number){
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        }

    }
}
