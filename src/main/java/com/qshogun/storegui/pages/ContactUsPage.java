package com.qshogun.storegui.pages;

import com.qshogun.storegui.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

    private String customerService = "Customer service";
    private String webmaster = "Webmaster";

    @FindBy(id = "message")
    private WebElement messageTextForm;

    @FindBy(xpath = "//p[contains(@class,'success')]")
    private WebElement messageSentSuccessfullyAlert;

    @FindBy(id = "id_contact")
    private WebElement subjectHeading;

    @FindBy(id = "email")
    private WebElement emailTextbox;

    @FindBy(id = "id_order")
    private WebElement orderReferenceTextbox;

    @FindBy(id = "submitMessage")
    private WebElement submitMessageButton;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage isAt() {
        waitForVisibilityOf(messageTextForm);
        Assert.assertTrue("Contact us form is not visible.", messageTextForm.isDisplayed());
        return this;
    }
    private void sendMessage() {
        emailTextbox.sendKeys("sample@email.com");
        orderReferenceTextbox.sendKeys("random string");
        messageTextForm.sendKeys("random message");
        submitMessageButton.click();
    }

    public ContactUsPage sendMessageToCustomerService() {
        subjectHeading.sendKeys(customerService);
        sendMessage();
        return this;
    }
    public ContactUsPage sendMessageToWebmaster() {
        subjectHeading.sendKeys(webmaster);
        sendMessage();
        return this;
    }

    public ContactUsPage isMessageSentSuccessfully() {
        waitForVisibilityOf(messageSentSuccessfullyAlert);
        Assert.assertTrue("There is no confirmation of message to be sent", messageSentSuccessfullyAlert.isDisplayed());
        return this;
    }


}
