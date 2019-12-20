package com.qshogun.storegui.pages;

import com.github.javafaker.Faker;
import com.qshogun.storegui.common.BasePage;
import com.qshogun.storegui.models.User;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class AccountCreationPage extends BasePage {

    @FindBy(id = "id_gender1")
    private WebElement mrRadioButton;

    @FindBy(id = "id_gender2")
    private WebElement mrsRadioButton;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameTextbox;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameTextbox;

    @FindBy(id = "passwd")
    private WebElement passwordTextbox;

    @FindBy(id = "days")
    private WebElement dayOfBirthSelector;

    @FindBy(id = "months")
    private WebElement monthOfBirthSelector;

    @FindBy(id = "years")
    private WebElement yearOfBirthSelector;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(id = "address1")
    private WebElement addressMainTextbox;

    @FindBy(id = "city")
    private WebElement cityTextbox;

    @FindBy(id = "id_state")
    private WebElement stateSelector;

    @FindBy(id = "postcode")
    private WebElement postcodeTextbox;

    @FindBy(id = "id_country")
    private WebElement countrySelector;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobileTextbox;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public AccountCreationPage(WebDriver driver) {
        super(driver);
    }

    public AccountCreationPage isAt() {
        waitForVisibilityOf(registerButton);
        Assert.assertTrue("Register button not found.", registerButton.isDisplayed());
        return this;
    }

    public MyAccountPage registerAccountWithValidRequiredData(User user) {
        mrRadioButton.click();
        firstNameTextbox.sendKeys(user.getFirstName());
        lastNameTextbox.sendKeys(user.getLastName());
        passwordTextbox.sendKeys(user.getPassword());
        dayOfBirthSelector.sendKeys(user.getDayOfBirth());
        monthOfBirthSelector.sendKeys(user.getMonthOfBirth());
        yearOfBirthSelector.sendKeys(user.getYearOfBirth());
        newsletterCheckbox.click();
        specialOffersCheckbox.click();
        addressMainTextbox.sendKeys(user.getAddressMain());
        cityTextbox.sendKeys(user.getCity());
        stateSelector.sendKeys(user.getState());
        postcodeTextbox.sendKeys(user.getPostcode());
        countrySelector.sendKeys(user.getCountry());
        phoneMobileTextbox.sendKeys(user.getPhoneMobileNumber());
        registerButton.click();
        return new MyAccountPage(driver);
    }
}
