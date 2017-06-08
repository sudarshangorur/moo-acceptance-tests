package com.moo.pageobjects;

import com.moo.utils.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MooLandingPage {

    private WebDriver webDriver;

    public MooLandingPage() {
        this.webDriver = new FirefoxDriver();
        webDriver.get("https://www.moo.com/uk/");
    }

    public SearchListingsPage searchFor(String product) {
        webDriver.findElement(By.id("query")).sendKeys(product);
        webDriver.findElement(By.id("query")).submit();
        return new SearchListingsPage(webDriver);
    }

    public BusinessCardPlusPage clickNFCBusinessCard() {
        WaitUntil.waitForVisibilityByCssSelector(webDriver, ".slideshow-nav > li:nth-child(5) > a:nth-child(1)");
        webDriver.findElement(By.cssSelector(".slideshow-nav > li:nth-child(5) > a:nth-child(1)")).click();
        WaitUntil.waitForVisibilityByClass(webDriver, "hero-list-margin");
        return new BusinessCardPlusPage(webDriver);
    }
}
