package com.demoqa.homework.TestForm;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.executeJavaScript;


public class TestBase {

    void config() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1420x860";
    }

    void killJS() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
}
