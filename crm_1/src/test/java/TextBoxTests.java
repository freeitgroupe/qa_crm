import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.io.File;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;



public class TextBoxTests {
  @Test
  void fillPracticeFormTests() {
    //Configuration.browser = "opera";
    String  firstName = "First Name",
            lastName = "Last Name",
            email = "name@gmail.com",
            genderValue = "Female",
            mobile = "0123456789",
            dateOfBirth = "08 Apr 1988",
            subjects = "subjects",
            pathForFile = "src/resources/photo.jpg",
            currentAddress = "currentAddress",
            state = "NCR",
            city = "Noida";
    String[] hobbies =  new String[] {"Sport", "Reading"};

    open("https://demoqa.com/automation-practice-form");
    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(email);
    //$("#genterWrapper .custom-radio").setValue(email);
    $(By.xpath("//div[contains(., '" + genderValue + "') and contains(@class, 'custom-control')]")).click();
    //$("name=gender").setSelected(true);
    $("#userNumber").setValue(mobile);
    $("#dateOfBirthInput").click();
    $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "a");
    $("#dateOfBirthInput").sendKeys(Keys.SPACE);
    $("#dateOfBirthInput").setValue(dateOfBirth);
    $("#subjectsContainer").click();
    $(".subjects-auto-complete__input input").setValue(subjects);

    if(hobbies.length > 0){
      for(int i = 0; i < hobbies.length; i++){
        $(By.xpath("//div[contains(., '" + hobbies[i] + "') and contains(@class, 'custom-control')]")).click();
      }
    }
    //$("#uploadPicture").click();
    $("#uploadPicture").uploadFile(new File("src/resources/photo.jpg"));
    $("#currentAddress").setValue(currentAddress);

    $("#state").scrollIntoView(true);
    actions().moveToElement($("#state")).click($("#state")).perform();

    SelenideElement elState = $(By.xpath("//div[contains(@class, 'css-26l3qy-menu')]//..//div[(text() = '" + state + "')]"));
    elState.waitUntil(visible, 2000);
    actions().moveToElement(elState).click(elState).perform();

    actions().moveToElement($("#city")).click($("#city")).perform();
    SelenideElement elCity = $(By.xpath("//div[contains(@class, 'css-26l3qy-menu')]//..//div[(text() = '" + city + "')]"));
    elCity.waitUntil(visible, 2000);
    actions().moveToElement(elCity).click(elCity).perform();


    $("#submit").pressEnter();
    System.out.println("");
  }

}
