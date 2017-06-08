package com.moo.pageobjects;

import org.openqa.selenium.WebDriver;

public class BusinessCardPlusPage {

    private WebDriver webDriver;

    public BusinessCardPlusPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getPageURL() {
        return webDriver.getCurrentUrl();
    }

    public void close() {
        webDriver.quit();
    }
}
