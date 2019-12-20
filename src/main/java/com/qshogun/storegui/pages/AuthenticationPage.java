package com.qshogun.storegui.pages;

import com.github.javafaker.Faker;
import com.qshogun.storegui.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "email_create")
    private WebElement emailTextbox;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public AuthenticationPage isAt() {
        waitForVisibilityOf(createAccountButton);
        Assert.assertTrue("Couldn't find 'Create an account' button.", createAccountButton.isDisplayed());
        return this;
    }
    public AccountCreationPage createAccount() {
        emailTextbox.sendKeys(new Faker().internet().emailAddress());
        createAccountButton.click();
        return new AccountCreationPage(driver);
    }
}
