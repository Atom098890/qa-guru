package com.demoqa.homework.TestGitHub;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestsGithub {

    @Test
    void checkSoftAssertions(){
        open("https://github.com/");

        $("[name='q']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#wiki-tab").click();

        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));

        $("[data-filterable-for=wiki-pages-filter]").click();
        $("#wiki-body").shouldHave(Condition.text("Using JUnit5 extend test class"));
    }
}
