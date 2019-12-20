package com.qshogun.storegui.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private final int TIME_OUT_FOR_ELEMENT = 20;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    protected void waitForVisibilityOf(WebElement element) {
        new WebDriverWait(driver, TIME_OUT_FOR_ELEMENT)
                .until(ExpectedConditions.visibilityOf(element));
    }
    protected void waitToBeClickable(WebElement element) {
        new WebDriverWait(driver, TIME_OUT_FOR_ELEMENT)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}