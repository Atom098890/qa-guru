package com.demoqa.Allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class Attachments {

    static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "#80";

    @Test
    public void testAttachmentsStep() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        step("Open start page", () -> {
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });


    }

    @Test
    public void testAttachmentStep() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        WebTests steps = new WebTests();

        steps.openMainPage();
        //attachment написан в WebTests
        steps.takeScreenShot();
    }
}
