package com.moo.pageobjects;

import com.moo.utils.WaitUntil;
import org.openqa.selenium.WebDriver;

public class BusinessCardPage {

    private WebDriver webDriver;

    public BusinessCardPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getPageURL() {
        WaitUntil.waitForVisibilityByClass(webDriver, "fnx-site");
        return webDriver.getCurrentUrl();
    }
}
