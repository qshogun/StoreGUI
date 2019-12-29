package com.qshogun.storegui.pages;

import com.qshogun.storegui.common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "slider_row")
    private WebElement carouselSlider;

    List<WebElement> listOfVisibleAddToCartProducts = new ArrayList<WebElement>
            (driver.findElements(By.className("product-container")));

    @FindBy(xpath = "//a[contains(@class,'add_to_cart')]//span")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(@class,'continue')]//i")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//span[contains(text(),'checkout')]")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//span[contains(@class,'quantity')]")
    private WebElement cartQuantity;

    @FindBy(xpath = "//span[@class='remove_link']")
    private WebElement removeProductFromCartButton;

    @FindBy(className = "ajax_cart_no_product")
    private WebElement cartEmpty;

    @FindBy(xpath = "//span[contains(@class,'ajax_cart_quantity')]")
    private WebElement cartNotEmpty;

    Actions action = new Actions(driver);
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> getListOfVisibleAddToCartProducts() {
        return listOfVisibleAddToCartProducts;
    }
    public HomePage printAllVisibleProducts() {
        String listOfVisibleProducts = getListOfVisibleAddToCartProducts().toString();
        for(WebElement webElement : listOfVisibleAddToCartProducts) {
            System.out.println(webElement.getText() + "\n");
        }
        return this;
    }
    public HomePage isAt() {
        waitForVisibilityOf(carouselSlider);
        Assert.assertTrue("Slider is not visible.", carouselSlider.isDisplayed());
        return this;
    }
    public HomePage printHowManyAllVisibleAddToCartProducts() {
        waitForVisibilityOf(carouselSlider);
        System.out.println(getListOfVisibleAddToCartProducts().size());
        return this;
    }
    public HomePage addProductToCart() {
        waitToBeClickable(listOfVisibleAddToCartProducts.get(0));
        action.moveToElement(listOfVisibleAddToCartProducts.get(0)).moveToElement(addToCartButton).click().build().perform();
        //Assert.assertEquals(1, Integer.parseInt(cartQuantity.getText()));
        return this;
    }
    public HomePage addProductToCartAndContinueShopping() {
        addProductToCart();
        waitToBeClickable(continueShoppingButton);
        continueShoppingButton.click();
        Assert.assertFalse("Cart is empty", cartEmpty.isDisplayed());
        return this;
    }
    public HomePage removeProductFromCart() {
        action.moveToElement(cartNotEmpty).build().perform();
        waitToBeClickable(removeProductFromCartButton);
        removeProductFromCartButton.click();
        waitForVisibilityOf(cartEmpty);
        Assert.assertTrue("Cart is not empty", cartEmpty.isDisplayed());
        return this;
    }
    public CheckoutPage goToCheckout() {
        waitToBeClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        return new CheckoutPage(driver);
    }
}
