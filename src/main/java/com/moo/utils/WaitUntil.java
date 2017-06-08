package com.moo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntil {

    private static Integer timeOutDuration = 5;

    public static void waitForVisibilityByClass(WebDriver webDriver, String className) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutDuration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    public static void waitForVisibilityByCssSelector(WebDriver webDriver, String cssSelector) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutDuration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }
}
