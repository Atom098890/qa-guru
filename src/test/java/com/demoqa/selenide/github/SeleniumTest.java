package com.demoqa.selenide.github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Disabled
public class SeleniumTest {

    @Test
    void contributeTest(){
        open("https://github.com/selenide/selenide");
        $(".Layout-sidebar").$(byText("Contributors"))
                .ancestor(".BorderGrid-cell")
                .$$("ul li").first()
                .hover();

        $$(".Popover span").first().shouldHave(text("Andrei Solntsev"));
    }

    @Test
    void dragAndDropTest(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldNotHave(text("A"));
    }
}
