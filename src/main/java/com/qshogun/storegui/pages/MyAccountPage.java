package com.qshogun.storegui.pages;

import com.qshogun.storegui.common.BasePage;
import com.qshogun.storegui.components.NavigationMenu;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    public MyAccountPage isAt() {
        waitForVisibilityOf(NavigationMenu.getSignOutLink());
        Assert.assertTrue("Not logged in.", NavigationMenu.getSignOutLink().isDisplayed());
        return this;
    }

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
}
