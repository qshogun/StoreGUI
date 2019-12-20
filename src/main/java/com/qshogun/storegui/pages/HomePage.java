package com.qshogun.storegui.pages;

import com.qshogun.storegui.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "slider_row")
    private WebElement carouselSlider;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage isAt() {
        waitForVisibilityOf(carouselSlider);
        Assert.assertTrue("Slider is not visible.", carouselSlider.isDisplayed());
        return this;
    }
}
