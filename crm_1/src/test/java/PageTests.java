import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PageTests {
    @Test
    void testAlfa(){
        open("https://alfabank.ru/"); // arrange
        $(byText("Вклады")).click(); // act

        // Selenide.$("div[data-test-id=Main-Header-Main-DesktopLayout] a[title=Вклады]").click();
        // SelenideElement textDiv = Selenide.$("div[data-test-id=Main-Header-Main-DesktopLayout] a[title=Вклады]");
        // actions().moveToElement(textDiv).click(textDiv).perform();

        $("body").shouldHave(Condition.text("Накопительные продукты")); // assert
        $("a[data-widget-name=\"Link\"][href=\"/make-money/deposits/\"]").click();
        $("body").shouldHave(Condition.exactTextCaseSensitive("Вклады в Альфа-Банке"));

         // $("body").parent().parent().click(); // обращение к вышейстоящему родителю родителя
         // $("a").closest("div").click(); // обращение к ближайшему закрывающему эл-ту div где есть тег а
         // $("a").closest("div").sibling(0).click(); // обращение к э-ту рядом от h1 вниз по дереву DOM
         // $("a").closest("div").preceding(0).click(); // обращение к э-ту рядом от h1 ввверх по дереву DOM
    }

}
