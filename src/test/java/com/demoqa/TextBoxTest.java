package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {

    @BeforeAll
    static void config() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1420x860";
    }

    @Test
    void fillFormTest(){
        open("/text-box");
        $("#userName").setValue("Egor");
        $("#userEmail").setValue("example@gmail.com");
        $("#currentAddress").setValue("Test description");
        $("#permanentAddress").setValue("New York, St. Oxford 20");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#submit").click();
        //$("#output").$("#name").shouldHave(text("Egor"));
        $("#output #name").shouldHave(text("Egor"));
    }
}
