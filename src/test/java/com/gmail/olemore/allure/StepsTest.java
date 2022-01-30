package com.gmail.olemore.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {
    public static final String Repository = "eroshenkoam/allure-example";
    public static final int Number = 68;

    @Test
    public void LambdaStepsTest() {
        step("открываем гитхаб - главную страницу", () -> open("https://github.com"));
        step("Ищем репозиторий " + Repository, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(Repository);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + Repository, () -> $(By.linkText(Repository)).click());
        step("Открываем Issues и проверяем Issue c №" + Number, () -> {
            $(By.partialLinkText("Issues")).click();
            Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
            $(withText("#" + Number)).should(Condition.visible);
        });
    }

    @Test
    public void annotatedStepsTest() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(Repository);
        steps.openRepositoryPage(Repository);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(Number);
    }
}
