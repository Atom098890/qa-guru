package com.demoqa.Allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SelenideStepsTest {

    static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "#80";

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        step("Open start page", () -> {
            open("https://github.com");
        });

        step("Search repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Click link repository " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Open tab issues", () -> {
            $("#issues-tab").click();
        });

        step("Check subtitle issue " + ISSUE, () -> {
            $(withText(ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        WebTests steps = new WebTests();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickRepositoryOnLink(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithSubTitle(ISSUE);
    }
}
