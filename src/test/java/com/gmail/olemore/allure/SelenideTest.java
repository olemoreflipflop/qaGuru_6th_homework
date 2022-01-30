package com.gmail.olemore.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    public static final String Repository = "eroshenkoam/allure-example";
    public static final int Number = 68;
    
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(Repository);
        $(".header-search-input").submit();

        $(By.linkText(Repository)).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("#" + Number)).should(Condition.visible);
    }
}
