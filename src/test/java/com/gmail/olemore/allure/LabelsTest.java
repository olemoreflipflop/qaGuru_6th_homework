package com.gmail.olemore.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    public void lambdaLabelsTest() {
        Allure.label("owner", "ofilippova");
        Allure.feature("Issues");
        Allure.story("Создание Issue для авторизованного пользователя");
        Allure.label("Severity", SeverityLevel.BLOCKER.value());
        Allure.link("GitHub", "https://github.com");
    }

    @Test
    @Owner("ofilippova")
    @Feature("Issues")
    @Story("Создание Issue")
//    @Stories({
//            @Story("Создание Issue"),
//            @Story("Удаление Issue")
//    })
    @DisplayName("Создание Issue для авторизованного пользователя")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "GitHub", url = "https://github.com")
    public void createIssueWithAuthTest() {
    }
}
