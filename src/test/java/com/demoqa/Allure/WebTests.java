package com.demoqa.Allure;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebTests {

    @Step("Open start page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Search repository {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repo);
        $(".header-search-input").submit();
    }

    @Step("Click link repository {repo}")
    public void clickRepositoryOnLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Open tab issues")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Check subtitle issue {title}")
    public void shouldSeeIssueWithSubTitle(String title) {
        $(withText(title)).should(Condition.exist);
    }

    @Attachment(value = "ScreenShot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenShot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
