package com.demoqa.regitsterForm.tests;

import com.demoqa.regitsterForm.pages.RegistrationFromPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestRegistrationForm {
    RegistrationFromPage registrationFromPage = new RegistrationFromPage();

    @Test
    void setForm() {
        registrationFromPage
                .openPage()
                .setFirstName("Andi")
                .setLastName("Ivanov")
                .setEmail("example@gmail.com")
                .setGender("[for='gender-radio-1']")
                .setPhone("9992223344")
                .setBirthday("20", "July", "1993")
                .setSubject("English")
                .setCheckBox();

        $("#uploadPicture").uploadFile(new File("src/test/resources/test.jpg"));
        $("#currentAddress").setValue("Address");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Andi Ivanov"),
                text("example@gmail.com"),
                text("Male"),
                text("9992223344"),
                text("20 July,1993"),
                text("English"),
                text("Music"),
                text("test.jpg"),
                text("Haryana")
        );
        $(".modal-body").shouldHave(text("Haryana Karnal"));
        $(".modal-footer").shouldHave(text("Close"));

    }

    @Test
    void setMinimumDataForm() {
        registrationFromPage.openPage();

        $("#firstName").setValue("Andi");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("example@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("9992223344");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(9);
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--020").click();
        $("#subjectsInput").setValue("English").pressEnter();

        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/test.jpg"));
        $("#currentAddress").setValue("Address");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Andi Ivanov"),
                text("example@gmail.com"),
                text("Male"),
                text("9992223344"),
                text("20 October,1993"),
                text("English"),
                text("Music"),
                text("test.jpg"),
                text("Haryana")
        );
        $(".modal-body").shouldHave(text("Haryana Karnal"));
        $(".modal-footer").shouldHave(text("Close"));

    }
}
