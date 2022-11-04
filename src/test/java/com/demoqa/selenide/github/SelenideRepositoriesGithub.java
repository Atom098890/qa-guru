package com.demoqa.selenide.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Disabled
public class SelenideRepositoriesGithub {

    @BeforeAll
    static void start() {
        Configuration.browserSize = "1420x860";
    }

    @Test
    void shouldFindSelenide(){
        open("https://github.com/");
        $("[data-test-selector='nav-search-input']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

        sleep(5000);
    }
}
