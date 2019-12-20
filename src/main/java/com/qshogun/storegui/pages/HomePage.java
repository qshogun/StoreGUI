package com.qshogun.storegui.pages;

import com.qshogun.storegui.common.BasePage;
import com.qshogun.storegui.components.NavigationMenu;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class HomePage extends BasePage {

    @FindBy(id = "slider_row")
    private WebElement carouselSlider;

    ArrayList<WebElement> listOfVisibleAddToCartProducts = new ArrayList<WebElement>
            (driver.findElements(By.className("product-container")));

    @FindBy(xpath = "//a[contains(@class,'add_to_cart')]//span")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(@class,'continue')]//i")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//span[contains(@class,'quantity')]")
    private WebElement cartQuantity;


    Actions action = new Actions(driver);
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public ArrayList<WebElement> getListOfVisibleAddToCartProducts() {
        return listOfVisibleAddToCartProducts;
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
    public NavigationMenu addToCartProducts(int numberOfProductsToBeAddedToCart) {
        waitToBeClickable(listOfVisibleAddToCartProducts.get(0));
        for(int i=0;i<numberOfProductsToBeAddedToCart;i++) {
            action.moveToElement(listOfVisibleAddToCartProducts.get(i)).moveToElement(addToCartButton).click().build().perform();
            waitToBeClickable(continueShoppingButton);
            continueShoppingButton.click();
        }
        Assert.assertEquals(numberOfProductsToBeAddedToCart, Integer.parseInt(cartQuantity.getText()));
        return new NavigationMenu(driver);
    }
}
