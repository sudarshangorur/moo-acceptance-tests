package com.moo.pageobjects;

import com.moo.utils.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchListingsPage {

    private WebDriver webDriver;

    SearchListingsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public String findBusinessCardURL() {
        WaitUntil.waitForVisibilityByClass(webDriver, "gsc-expansionArea");
        return webDriver.findElement(By.className("gsc-url-top")).getText();
    }

    public String findProductNotFoundMessage() {
        WaitUntil.waitForVisibilityByClass(webDriver, "gs-snippet");
        return webDriver.findElement(By.className("gs-snippet")).getText();
    }

    public void close() {
        webDriver.quit();
    }

    public BusinessCardPage goToBusinessCardsPage() {
        WaitUntil.waitForVisibilityByClass(webDriver, "gsc-expansionArea");
        webDriver.findElement(By.className("gs-title")).click();
        return new BusinessCardPage(webDriver);
    }
}
