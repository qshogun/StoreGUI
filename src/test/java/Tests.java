import com.qshogun.storegui.components.NavigationMenu;
import com.qshogun.storegui.models.User;
import com.qshogun.storegui.pages.ContactUsPage;
import com.qshogun.storegui.pages.HomePage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.qshogun.storegui.provider.DataFactory.getUser;

public class Tests extends TestsSuite {

    private HomePage homePage;
    private NavigationMenu navigationMenu;
    private ContactUsPage contactUsPage;

    @Before
    public void initPages() {
        homePage = new HomePage(driver);
        navigationMenu = new NavigationMenu(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @Test
    public void doesWebsiteOpenTest() {
        homePage.isAt();
    }

    @Test
    public void doesContactUsPageOpenTest() {
        doesWebsiteOpenTest();
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
    public void isNumberOfProductsShownInCartTheSameAsAddedToCart() {
        homePage.isAt()
                .addToCartProducts(3);
    }

}
