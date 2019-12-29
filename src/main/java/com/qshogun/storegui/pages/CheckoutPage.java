package com.qshogun.storegui.pages;

import com.qshogun.storegui.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "cart_title")
    private WebElement cartTitle;

    @FindBy(className = "icon-minus")
    private WebElement decreaseQuantityOfProductButton;

    @FindBy(className = "icon-plus")
    private WebElement increaseQuantityOfProductButton;

    @FindBy(xpath = "//td[contains(@class,'quantity')]//input[contains(@class,'input')]")
    private WebElement quantityOfProductInput;

    @FindBy(xpath = "//td[@class='cart_unit']//span[@class='price']//span")
    private WebElement unitPrice;

    @FindBy(xpath = "//td[@class='cart_total']//span[@class='price']")
    private WebElement totalPrice;



    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage isAt() {
        waitForVisibilityOf(cartTitle);
        return this;
    }
    public CheckoutPage increaseQuantity() {
        waitToBeClickable(increaseQuantityOfProductButton);
        Integer productQuantity = Integer.parseInt(quantityOfProductInput.getText());
        increaseQuantityOfProductButton.click();
        Assert.assertEquals(productQuantity+1, Integer.parseInt(quantityOfProductInput.getText()));
        return this;
    }
    public CheckoutPage decreaseQuantity() {
        waitToBeClickable(decreaseQuantityOfProductButton);
        Integer productQuantity = Integer.parseInt(quantityOfProductInput.getText());
        decreaseQuantityOfProductButton.click();
        Assert.assertEquals(productQuantity-1, Integer.parseInt(quantityOfProductInput.getText()));
        return this;
    }
    public CheckoutPage typeQuantity() {
        waitForVisibilityOf(quantityOfProductInput);
        String quantity = "5";
        quantityOfProductInput.sendKeys(quantity);
        Assert.assertEquals(Integer.parseInt(quantity),Integer.parseInt(quantityOfProductInput.getText()));
        return this;
    }
}
