package com.demoqa.Allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Issue in Repository")
    @Story("Create Issue")
    @Owner("eroshenkoam")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для авторизованного пользователя")
        );
        Allure.feature("Issue in Repository");
        Allure.story("Create Issue");
        Allure.label("owner", "eroshenkoam");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.link("Testing","https://github.com");
    }
}
