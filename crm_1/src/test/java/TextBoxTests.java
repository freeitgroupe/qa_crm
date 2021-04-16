import com.codeborne.selenide.Configuration;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.lang.reflect.Array;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTests {


  @Test
  void fillFormTests1() {
    String  name = "userName",
            email = "userEmail",
            login = "tikhonenko_r_i",
            pass = "Asdf260688";
           // currentAddress = "currentAddress",
            //permanentAddress = "permanentAddress";
    Configuration.browser = "opera";

    open("https://ne-vm2.pstu/login");
    //user
    //password
    $("#user").setValue(login);
    $("#password").setValue(pass);
    $("#submit-form").click();
    $("#talk-panel").click();
    $(".top-bar .top-bar__button.top-bar__button.success").click();
    //waiting 2 seconds talk-panel
    $("#output").shouldHave(text(String
            .format(
                    "Name:%s\n" +
                            "Email:%s\n"
                    , name, email )));
    System.out.println("");
  }

  @Test
  void fillFormTests() {
    String  name = "userName",
            email = "userEmail",
            currentAddress = "currentAddress",
            permanentAddress = "permanentAddress";
    open("https://demoqa.com/text-box");
    $("#userName").setValue("userName");
    $("#userEmail").setValue("userEmail@gmail.com");
    $("#currentAddress").setValue("currentAddress");
    $("#permanentAddress").setValue("permanentAddress");
    $("#submit").pressEnter();

    $("#output").shouldHave(text(String
            .format(
            "Name:%s\n" +
            "Email:%s\n"
            , name, email )));
    System.out.println("");
  }

  @Test
  void fillPracticeFormTests() {
    Configuration.browser = "opera";
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

    $("#state").click();
    if($(".cs2613qy-menu").isDisplayed()){
      $(".cs2613qy-menu").$(byText(state)).click();
    }

    $("#submit").pressEnter();
  }

}
