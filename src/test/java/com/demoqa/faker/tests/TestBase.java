package com.demoqa.faker.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.regitsterForm.pages.RegistrationFromPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {
    RegistrationFromPage registrationFromPage = new RegistrationFromPage();
    Faker faker = new Faker();

    @BeforeAll
    static void configure() {
        Configuration.browserSize = "1420x860";
    }
}
