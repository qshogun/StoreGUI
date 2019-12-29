import com.qshogun.storegui.components.NavigationMenu;
import com.qshogun.storegui.listeners.ListenerTest;
import com.qshogun.storegui.pages.CheckoutPage;
import com.qshogun.storegui.pages.ContactUsPage;
import com.qshogun.storegui.pages.HomePage;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.qshogun.storegui.provider.DataFactory.getUser;

@Listeners(ListenerTest.class)

public class Tests extends TestsSuite {

    private HomePage homePage;
    private NavigationMenu navigationMenu;
    private ContactUsPage contactUsPage;
    private CheckoutPage checkoutPage;

    @BeforeClass
    public void initPages() {
        homePage = new HomePage(driver);
        navigationMenu = new NavigationMenu(driver);
        contactUsPage = new ContactUsPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void T1_doesWebsiteOpenTest() {
        homePage.isAt();
    }

    @Test
    public void doesContactUsPageOpenTest() {
        homePage.isAt();
        navigationMenu.clickContactUs()
                .isAt();
    }

    @Test
    public void isMessageToCustomerServiceSentTest() {
        homePage.isAt();
        navigationMenu.clickContactUs()
                .isAt()
                .sendMessageToCustomerService()
                .isMessageSentSuccessfully();
    }

    @Test
    public void isMessageToWebmasterSentTest() {
        homePage.isAt();
        navigationMenu.clickContactUs()
                .isAt()
                .sendMessageToWebmaster()
                .isMessageSentSuccessfully();
    }

    @Test
    public void doesAuthenticationPageOpenTest() {
        homePage.isAt();
        navigationMenu.clickSignIn()
                .isAt();
    }

    @Test
    public void canSignUpAndGoToAccountCreationWithValidEmailTest() {
        homePage.isAt();
        navigationMenu.clickSignIn()
                .isAt()
                .createAccount()
                .isAt();
    }
    @Test
    public void canRegisterAccountWithValidRequiredDataTest() {
        homePage.isAt();
        navigationMenu.clickSignIn()
                .isAt()
                .createAccount()
                .isAt()
                .registerAccountWithValidRequiredData(getUser())
                .isAt();
    }
    @Test
    public void isNumberOfVisibleAddToCartProductsCorrectTest() {
        homePage.isAt()
                .printHowManyAllVisibleAddToCartProducts();
        Assert.assertEquals(7, homePage.getListOfVisibleAddToCartProducts().size());
    }
    @Test
    public void T5_isProductAddedToCartVisibleInTheCartTest() {
        homePage.isAt()
                .addProductToCart();
    }
    @Test
    public void T6_isProductRemovedFromCartTest() {
        homePage.isAt()
                .addProductToCartAndContinueShopping()
                .removeProductFromCart();
    }
    @Test
    public void isProductQuantityChangeableAtCheckoutTest() {
        homePage.isAt()
                .addProductToCart()
                .goToCheckout();
        checkoutPage.isAt()
                .increaseQuantity()
                .decreaseQuantity()
                .typeQuantity();
    }
    @Test
    public void isTotalPriceCorrectAfterChangingQuantityOfProductsAtCheckoutTest() {
        homePage.isAt()
                .addProductToCart()
                .goToCheckout();
        checkoutPage.isAt()
                .increaseQuantity()
                .checkTotalPrice()
                .decreaseQuantity()
                .checkTotalPrice()
                .typeQuantity()
                .checkTotalPrice();
    }


}
