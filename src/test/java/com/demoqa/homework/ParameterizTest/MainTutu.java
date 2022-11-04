package com.demoqa.homework.ParameterizTest;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainTutu {

    static Stream<Arguments> checkLinks() {
        return Stream.of(
                Arguments.of(List.of("Авиабилеты Ж/д билеты Автобусы Электрички Отели Туры Приключения Командировки Аэроэкспрессы"))
        );
    }

    @MethodSource("checkLinks")
    @ParameterizedTest(name = "Проверяем отображение ссылок на главной странице Туту.ру")
    void checkLinksTest(List<String> link) {
        open("https://www.tutu.ru/");
        $$(".b-visible_tabs").filter(visible).shouldHave(CollectionCondition.texts(link));;
    }
}
