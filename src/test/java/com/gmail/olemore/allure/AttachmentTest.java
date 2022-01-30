package com.gmail.olemore.allure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AttachmentTest {
    public static final String Repository = "eroshenkoam/allure-example";

    @Test
    public void LambdaAttachmentTest() {
        step("открываем гитхаб - главную страницу", () -> open("https://github.com"));
        step("Ищем репозиторий " + Repository, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(Repository);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + Repository, () -> $(By.linkText(Repository)).click());
        step("Откроем таб Issues", () -> {
            Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
            $(By.partialLinkText("Issues")).click();
        });
    }
}
