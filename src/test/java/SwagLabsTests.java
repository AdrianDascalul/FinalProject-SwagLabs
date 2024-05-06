import pages.BasePage;
import pages.SwagLabs;
import pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLabsTests extends BasePage
{
    private SwagLabs swagLabs;

//The login account on which the tests will be run on can be changed here anytime.
    String username="standard_user";
    String password="secret_sauce";
    //A list of available usernames that can be used in the username field:
    //standard_user
    //locked_out_user
    //problem_user
    //performance_glitch_user
    //error_user
    //visual_user

//A BeforeMethod that logs-in before every test.
    @BeforeMethod
    public void setUp(){
        super.setUp();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        swagLabs =new SwagLabs(driver);}

//Check the presence and functionality of the "Remove" item button on items present on the Home Page.
    @Test
    public void backpackRemoveButton() {
        swagLabs.clickAddBackpack();
        swagLabs.removeButtonPresence();
        swagLabs.clickRemoveButton();
        swagLabs.clickHomePageCart();
        swagLabs.checkBackpackInCartFalse();}
    @Test
    public void bikeLightRemoveButton() {
        swagLabs.clickAddBikeLight();
        swagLabs.removeButtonPresence();
        swagLabs.clickRemoveButton();
        swagLabs.clickHomePageCart();
        swagLabs.checkBikeLightInCartFalse();}
    @Test
    public void boltTShirtRemoveButton() {
        swagLabs.clickAddBoltTShirt();
        swagLabs.removeButtonPresence();
        swagLabs.clickRemoveButton();
        swagLabs.clickHomePageCart();
        swagLabs.checkBoltTShirtInCartFalse();}
    @Test
    public void fleeceJacketRemoveButton() {
        swagLabs.clickAddFleeceJacket();
        swagLabs.removeButtonPresence();
        swagLabs.clickRemoveButton();
        swagLabs.clickHomePageCart();
        swagLabs.checkFleeceJacketInCartFalse();}
    @Test
    public void onesieRemoveButton() {
        swagLabs.clickAddOnesie();
        swagLabs.removeButtonPresence();
        swagLabs.clickRemoveButton();
        swagLabs.clickHomePageCart();
        swagLabs.checkOnesieInCartFalse();}
    @Test
    public void redTShirtRemoveButton() {
        swagLabs.clickAddRedTShirt();
        swagLabs.removeButtonPresence();
        swagLabs.clickRemoveButton();
        swagLabs.clickHomePageCart();
        swagLabs.checkRedTShirtInCartFalse();}

//Check the presence and functionality of the "Your Cart" button in the Home Page.
    @Severity(SeverityLevel.BLOCKER)
    @Story("View cart availability")
    @Test
    public void homePageCartButtonFunction() {
        swagLabs.clickHomePageCart();
        String ActualResult = driver.getCurrentUrl();
        Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/cart.html"));}

//Check the functionality of the "Add to cart" buttons on items present on the Home Page.
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void addBackpackToCart() {
        swagLabs.clickAddBackpack();
        swagLabs.clickHomePageCart();
        swagLabs.checkBackpackInCartTrue();}
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void addBikeLightToCart() {
        swagLabs.clickAddBikeLight();
        swagLabs.clickHomePageCart();
        swagLabs.checkBikeLightInCartTrue();}
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void addBoltTShirtToCart() {
        swagLabs.clickAddBoltTShirt();
        swagLabs.clickHomePageCart();
        swagLabs.checkBoltTShirtInCartTrue();}
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void addFleeceJacketToCart() {
        swagLabs.clickAddFleeceJacket();
        swagLabs.clickHomePageCart();
        swagLabs.checkFleeceJacketInCartTrue();}
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void addAddOnesieToCart() {
        swagLabs.clickAddOnesie();
        swagLabs.clickHomePageCart();
        swagLabs.checkOnesieInCartTrue();}
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void addAddRedTShirtToCart() {
        swagLabs.clickAddRedTShirt();
        swagLabs.clickHomePageCart();
        swagLabs.checkRedTShirtInCartTrue();}

//Check the presence and functionality of the "Remove" item button on items present on the Your Cart Page.
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void backpackRemoveButtonYourCart() {
        swagLabs.clickAddBackpack();
        swagLabs.clickAddBikeLight();
        swagLabs.clickAddBoltTShirt();
        swagLabs.clickAddFleeceJacket();
        swagLabs.clickAddOnesie();
        swagLabs.clickAddRedTShirt();
        swagLabs.clickHomePageCart();
        swagLabs.removeButtonPresence();
        swagLabs.clickRemoveButtonUntilNotClickable();
        swagLabs.checkRedTShirtInCartFalse();
        swagLabs.checkBackpackInCartFalse();
        swagLabs.checkBoltTShirtInCartFalse();
        swagLabs.checkFleeceJacketInCartFalse();
        swagLabs.checkOnesieInCartFalse();
        swagLabs.checkRedTShirtInCartFalse();}

//Check the presence of images on items on the Home Page.
    @Test
    public void imagesPresentOnItemsOnHomePage() {
        swagLabs.checkBackpackImageHomePage();
        swagLabs.checkBikeLightImageHomePage();
        swagLabs.checkBoltTShirtImageHomePage();
        swagLabs.checkFleeceJacketImageHomePage();
        swagLabs.checkOnesieImageHomePage();
        swagLabs.checkRedTShirtImageHomePage();}

//Check the presence of prices and their intended value on items on the Home Page.
    @Test
    public void checkPricesOnItemsOnHomePage() {
        swagLabs.checkBackpackPriceHomePage();
        swagLabs.checkBikeLightPriceHomePage();
        swagLabs.checkBoltTShirtPriceHomePage();
        swagLabs.checkFleeceJacketPriceHomePage();
        swagLabs.checkOnesiePriceHomePage();
        swagLabs.checkRedTShirtPriceHomePage();}

//Check the presence of descriptions on items on the Home Page.
    @Test
    public void checkItemsDescriptionsOnHomePage() {
        swagLabs.checkBackpackDescriptionHomePage();
        swagLabs.checkBikeLightDescriptionHomePage();
        swagLabs.checkBoltTShirtDescriptionHomePage();
        swagLabs.checkFleeceJacketDescriptionHomePage();
        swagLabs.checkOnesieDescriptionHomePage();
        swagLabs.checkRedTShirtDescriptionHomePage();}

//Check the functionality of the hyperlink of items on the Home Page.
    @Test
    public void checkBackpackHyperlinkHomePage() {
        swagLabs.checkBackpackHyperlinkHomePage();}
    @Test
    public void checkBikeLightHyperlinkHomePage() {
        swagLabs.checkBikeLightHyperlinkHomePage();}
    @Test
    public void checkBoltTShirtHyperlinkHomePage() {
        swagLabs.checkBoltTShirtHyperlinkHomePage();}
    @Test
    public void checkFleeceJacketHyperlinkHomePage() {
        swagLabs.checkFleeceJacketHyperlinkHomePage();}
    @Test
    public void checkOnesieHyperlinkHomePage() {
        swagLabs.checkOnesieHyperlinkHomePage();}
    @Test
    public void checkRedTShirtHyperlinkHomePage() {
        swagLabs.checkRedTShirtHyperlinkHomePage();}

//Check the presence of images, descriptions and prices on individual items.
    @Test
    public void checkBackpackItemPage() {
        swagLabs.clickBackpackHyperlinkHomePage();
        swagLabs.checkBackpackDescriptionItemPage();
        swagLabs.checkBackpackImageItemPage();
        swagLabs.checkBackpackPriceItemPage();}
    @Test
    public void checkBikeLightItemPage() {
        swagLabs.clickBikeLightHyperlinkHomePage();
        swagLabs.checkBikeLightDescriptionItemPage();
        swagLabs.checkBikeLightImageItemPage();
        swagLabs.checkBikeLightPriceItemPage();}
    @Test
    public void checkBoltTShirtItemPage() {
        swagLabs.clickBoltTShirtHyperlinkHomePage();
        swagLabs.checkBoltTShirtDescriptionItemPage();
        swagLabs.checkBoltTShirtImageItemPage();
        swagLabs.checkBoltTShirtPriceItemPage();}
    @Test
    public void checkFleeceJacketItemPage() {
        swagLabs.clickFleeceJacketHyperlinkHomePage();
        swagLabs.checkFleeceJacketDescriptionItemPage();
        swagLabs.checkFleeceJacketItemPage();
        swagLabs.checkFleeceJacketPriceItemPage();}
    @Test
    public void checkOnesieItemPage() {
        swagLabs.clickOnesieHyperlinkHomePage();
        swagLabs.checkOnesieDescriptionItemPage();
        swagLabs.checkOnesieImageItemPage();
        swagLabs.checkOnesiePriceItemPage();}
    @Test
    public void checkRedTShirtItemPage() {
        swagLabs.clickRedTShirtHyperlinkHomePage();
        swagLabs.checkRedTShirtDescriptionItemPage();
        swagLabs.checkRedTShirtImageItemPage();
        swagLabs.checkRedTShirtPriceItemPage();}

//Check the presence and functionality of the "Add to cart" button present on individual item pages.
    @Test
    public void checkBackpackAddToCartItemPage() {
        swagLabs.clickBackpackHyperlinkHomePage();
        swagLabs.clickAddToCartItemPage();
        swagLabs.clickHomePageCart();
        swagLabs.checkBackpackInCartTrue();}
    @Test
    public void checkBikeLightAddToCartItemPage() {
        swagLabs.clickBikeLightHyperlinkHomePage();
        swagLabs.clickAddToCartItemPage();
        swagLabs.clickHomePageCart();
        swagLabs.checkBikeLightInCartTrue();}
    @Test
    public void checkBoltTShirtAddToCartItemPage() {
        swagLabs.clickBoltTShirtHyperlinkHomePage();
        swagLabs.clickAddToCartItemPage();
        swagLabs.clickHomePageCart();
        swagLabs.checkBoltTShirtInCartTrue();}
    @Test
    public void checkFleeceJacketAddToCartItemPage() {
        swagLabs.clickFleeceJacketHyperlinkHomePage();
        swagLabs.clickAddToCartItemPage();
        swagLabs.clickHomePageCart();
        swagLabs.checkFleeceJacketInCartTrue();}
    @Test
    public void checkOnesieAddToCartItemPage() {
        swagLabs.clickOnesieHyperlinkHomePage();
        swagLabs.clickAddToCartItemPage();
        swagLabs.clickHomePageCart();
        swagLabs.checkOnesieInCartTrue();}
    @Test
    public void checkRedTShirtAddToCartItemPage() {
        swagLabs.clickRedTShirtHyperlinkHomePage();
        swagLabs.clickAddToCartItemPage();
        swagLabs.clickHomePageCart();
        swagLabs.checkRedTShirtInCartTrue();}

//Check the presence and functionality of the "Remove" button present on individual item pages.
    @Test
    public void checkBackpackRemoveItemPage() {
        swagLabs.clickBackpackHyperlinkHomePage();
        swagLabs.clickAddToCartItemPage();
        swagLabs.clickAndCheckRemoveItemPage();}
    @Test
    public void checkBikeLightRemoveItemPage() {
        swagLabs.clickBikeLightHyperlinkHomePage();
        swagLabs.clickAddToCartItemPage();
        swagLabs.clickAndCheckRemoveItemPage();}
    @Test
    public void checkBoltTShirtRemoveItemPage() {
        swagLabs.clickBoltTShirtHyperlinkHomePage();
        swagLabs.clickAddToCartItemPage();
        swagLabs.clickAndCheckRemoveItemPage();}
    @Test
    public void checkFleeceJacketRemoveItemPage() {
        swagLabs.clickFleeceJacketHyperlinkHomePage();
        swagLabs.clickAddToCartItemPage();
        swagLabs.clickAndCheckRemoveItemPage();}
    @Test
    public void checkOnesieRemoveItemPage() {
        swagLabs.clickOnesieHyperlinkHomePage();
        swagLabs.clickAddToCartItemPage();
        swagLabs.clickAndCheckRemoveItemPage();}
    @Test
    public void checkRedTShirtRemoveItemPage() {
        swagLabs.clickRedTShirtHyperlinkHomePage();
        swagLabs.clickAddToCartItemPage();
        swagLabs.clickAndCheckRemoveItemPage();}

//Check the accuracy of the indicator representing the number of items present in the cart.
    @Test
    public void checkNumberIndicator() {
        swagLabs.clickAddBackpack();
        swagLabs.clickAddBikeLight();
        swagLabs.clickAddBoltTShirt();
        swagLabs.clickAddFleeceJacket();
        swagLabs.clickAddOnesie();
        swagLabs.clickAddRedTShirt();
        swagLabs.checkNumberIndicator();}

//Test to verify the presence and functionality of the "Checkout" button.
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Checkout button availability")
    @Test
    public void clickAndCheckTheCheckoutButton() {
        swagLabs.clickHomePageCart();
        swagLabs.clickCheckoutButton();
        swagLabs.checkCheckoutButton();}

//Test to enter valid data in the payment information fields.
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Bill payment information")
    @Test
    public void enterPaymentInformation() {
        swagLabs.clickHomePageCart();
        swagLabs.clickCheckoutButton();
        swagLabs.enterFirstName("Nume");
        swagLabs.enterLastName("Prenume");
        swagLabs.enterZipCodeName("Cod Postal");
        swagLabs.clickContinuePaymentButton();
        swagLabs.checkContinuePaymentButton();}

//Test to enter null First Name in the payment information fields.
    @Test
    public void enterNullFirstName() {
        swagLabs.clickHomePageCart();
        swagLabs.clickCheckoutButton();
        swagLabs.enterFirstName("");
        swagLabs.enterLastName("Prenume");
        swagLabs.enterZipCodeName("Cod Postal");
        swagLabs.clickContinuePaymentButton();
        swagLabs.nullFirstNamePaymentInformationErrorMessage();}

//Test to enter null Last Name in the payment information fields.
    @Test
    public void enterNullLastName() {
        swagLabs.clickHomePageCart();
        swagLabs.clickCheckoutButton();
        swagLabs.enterFirstName("Nume");
        swagLabs.enterLastName("");
        swagLabs.enterZipCodeName("Cod Postal");
        swagLabs.clickContinuePaymentButton();
        swagLabs.nullLastNamePaymentInformationErrorMessage();}

//Test to enter null ZipCode Name in the payment information fields.
    @Test
    public void enterNullZipCodeName() {
        swagLabs.clickHomePageCart();
        swagLabs.clickCheckoutButton();
        swagLabs.enterFirstName("Nume");
        swagLabs.enterLastName("Prenume");
        swagLabs.enterZipCodeName("");
        swagLabs.clickContinuePaymentButton();
        swagLabs.nullZipCodeNamePaymentInformationErrorMessage();}

//Test to add up and verify the prices of the items in the cart.
    @Severity(SeverityLevel.MINOR)
    @Story("View total price accurately")
    @Test
    public void sumUpAndVerifyPrices() {
        swagLabs.clickAddRedTShirt();
        swagLabs.clickAddFleeceJacket();
        swagLabs.clickAddBoltTShirt();
        swagLabs.clickHomePageCart();
        swagLabs.clickCheckoutButton();
        swagLabs.enterFirstName("Nume");
        swagLabs.enterLastName("Prenume");
        swagLabs.enterZipCodeName("Cod Postal");
        swagLabs.clickContinuePaymentButton();
        swagLabs.sumPricesAndVerifyTotalWithoutTAX();}

//Test to check the presence and functionality of the "Cancel" checkout button.
    @Test
    public void checkCancelButtonFunctionality() {
        swagLabs.clickHomePageCart();
        swagLabs.clickCheckoutButton();
        swagLabs.enterFirstName("Nume");
        swagLabs.enterLastName("Prenume");
        swagLabs.enterZipCodeName("Cod Postal");
        swagLabs.clickContinuePaymentButton();
        swagLabs.clickAndCheckCancelCheckoutButton();}

//Test to check the presence and functionality of the "Finish" checkout button.
    @Severity(SeverityLevel.BLOCKER)
    @Story("End payment button")
    @Test
    public void checkFinishButtonFunctionality() {
        swagLabs.clickHomePageCart();
        swagLabs.clickCheckoutButton();
        swagLabs.enterFirstName("Nume");
        swagLabs.enterLastName("Prenume");
        swagLabs.enterZipCodeName("Cod Postal");
        swagLabs.clickContinuePaymentButton();
        swagLabs.clickAndCheckFinishCheckoutButton();}

//Test to check the presence and functionality of the "Back Home" checkout button.
    @Test
    public void checkBackHomeButtonFunctionality() {
        swagLabs.clickHomePageCart();
        swagLabs.clickCheckoutButton();
        swagLabs.enterFirstName("Nume");
        swagLabs.enterLastName("Prenume");
        swagLabs.enterZipCodeName("Cod Postal");
        swagLabs.clickContinuePaymentButton();
        swagLabs.clickFinishCheckoutButton();
        swagLabs.clickAndCheckBackHomeButton();}
}