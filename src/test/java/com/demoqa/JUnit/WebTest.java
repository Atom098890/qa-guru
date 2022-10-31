package com.demoqa.JUnit;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WebTest {

    @ValueSource(strings = {"Selenide", "Allure"})
    @ParameterizedTest(name = "Тест проверяет ввод текста и выдачу поиска {0}")
    void commonSearchTest(String testData) {
        open("https://ya.ru");
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item").shouldBe(CollectionCondition.sizeGreaterThan(0));
    }


    @CsvSource(value = {
            "Selenide, лаконичные и стабильные UI тесты на Java",
            "Allure java, test frameworks. Contribute to"
    })
    @ParameterizedTest(name = "Тест проверяет ввод текста и выдачу поиска {0}")
    void commonComplexSearchTest(String testData, String expectedResult) {
        open("https://ya.ru");
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item").first().shouldHave(text(expectedResult));
    }

    static Stream<Arguments> dataProviderSelenideSiteMenuTest() {
    return Stream.of(
            Arguments.of("RU", List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы")),
            Arguments.of("EN", List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes"))
    );
    }

    @MethodSource("dataProviderSelenideSiteMenuTest")
    @ParameterizedTest(name = "Проверяем переключение языка на сайте Selenide")
    void selenideSiteMenuTest(String lang, List<String> expectedButtons) {
        open("https://selenide.org");
        $$("#languages a").find(text(lang)).click();
        $$(".main-menu-pages a").filter(visible).shouldHave(CollectionCondition.texts(expectedButtons));
    }

    @ParameterizedTest
    @EnumSource(Lang.class)
    void selenideEnumMenuTest(Lang lang) {
        open("https://selenide.org");
        $$("#languages a").find(text(lang.name())).click();
        $("#selenide-logo").shouldBe(visible);
    }
}
