package com.qshogun.storegui.pages;

import com.qshogun.storegui.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id = "cart_title")
    private WebElement cartTitle;

    @FindBy(xpath = "//div[contains(@id,'order') and contains(@class,'table')]")
    private WebElement tableOfOrders;

    @FindBy(className = "icon-minus")
    private WebElement decreaseQuantityOfProductButton;

    @FindBy(className = "icon-plus")
    private WebElement increaseQuantityOfProductButton;

    @FindBy(xpath = "//td[contains(@class,'quantity')]//input[contains(@class,'input')]")
    private WebElement quantityOfProductInput;

    @FindBy(xpath = "//td[@class='cart_unit']//span[@class='price']//span")
    private WebElement unitPrice;

    @FindBy(xpath = "//td[@class='cart_total']//span[@class='price']")
    private WebElement totalProductPrice;

    @FindBy(id = "total_price")
    private WebElement totalPrice;

    Actions action = new Actions(driver);



    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage isAt() {
        waitForVisibilityOf(tableOfOrders);
        Assert.assertTrue("Shopping cart is not visible.", tableOfOrders.isDisplayed());
        return this;
    }
    public CheckoutPage increaseQuantity() {
        try {
            waitToBeClickable(increaseQuantityOfProductButton);
            Integer productQuantity = Integer.parseInt(quantityOfProductInput.getAttribute("value"));
            increaseQuantityOfProductButton.click();
            Thread.sleep(2000);
            Assert.assertEquals(productQuantity+1, Integer.parseInt(quantityOfProductInput.getAttribute("value")));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public CheckoutPage decreaseQuantity() {
        try {
            waitToBeClickable(decreaseQuantityOfProductButton);
            Integer productQuantity = Integer.parseInt(quantityOfProductInput.getAttribute("value"));
            decreaseQuantityOfProductButton.click();
            Thread.sleep(2000);
            Assert.assertEquals(productQuantity-1, Integer.parseInt(quantityOfProductInput.getAttribute("value")));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public CheckoutPage typeQuantity() {
        try {
            waitForVisibilityOf(quantityOfProductInput);
            String quantity = "5";
            action.moveToElement(quantityOfProductInput).doubleClick().sendKeys(quantity).build().perform();
            Thread.sleep(2000);
            Assert.assertEquals(Integer.parseInt(quantity),Integer.parseInt(quantityOfProductInput.getAttribute("value")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this;
    }
    public CheckoutPage checkTotalPrice() {
        float productPriceFloat = Float.parseFloat(unitPrice.getText().substring(1));
        float totalProductPriceFloat = Float.parseFloat(totalProductPrice.getText().substring(1));
        float totalPriceFloat = Float.parseFloat(totalPrice.getText().substring(1));
        Integer productQuantity = Integer.parseInt(quantityOfProductInput.getAttribute("value"));

        Assert.assertTrue(productPriceFloat*productQuantity==Float.parseFloat(totalProductPrice.getText().substring(1)));


        return this;
    }
}
