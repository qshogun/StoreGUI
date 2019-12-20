package com.qshogun.storegui.components;

import com.qshogun.storegui.common.BasePage;
import com.qshogun.storegui.pages.AuthenticationPage;
import com.qshogun.storegui.pages.ContactUsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationMenu extends BasePage {

    @FindBy(id = "contact-link")
    private WebElement contactUsLink;

    @FindBy(className = "login")
    private WebElement signInLink;

    @FindBy(className = "logout")
    private static WebElement signOutLink;

    public ContactUsPage clickContactUs() {
        waitToBeClickable(contactUsLink);
        contactUsLink.click();
        return new ContactUsPage(driver);
    }

    public AuthenticationPage clickSignIn() {
        waitToBeClickable(signInLink);
        signInLink.click();
        return new AuthenticationPage(driver);
    }

    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    public static WebElement getSignOutLink() {
        return NavigationMenu.signOutLink;
    }
}
