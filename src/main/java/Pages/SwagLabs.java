package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

public class SwagLabs extends BasePage
{
    public SwagLabs(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);}

//Prices for item that can be changed anytime.
    String backpackPrice="$29.99";
    String bikeLightPrice="$9.99";
    String boltTShirtPrice="$15.99";
    String fleeceJacketPrice="$49.99";
    String onesiePrice="$7.99";
    String redTShirtPrice="$15.99";

//Descriptions for item that can be changed anytime.
    String backpackDescription="carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
    String bikeLightDescription="A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
    String boltTShirtDescription="Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.";
    String fleeceJacketDescription="It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
    String onesieDescription="Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.";
    String redTShirtDescription="This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.";

//Locators and methods for the "Add to cart" buttons on every item present on the Home Page.
    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement addBackpack;
    public void clickAddBackpack(){addBackpack.click();}
    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    private WebElement addBikeLight;
    public void clickAddBikeLight(){addBikeLight.click();}
    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addBoltTShirt;
    public void clickAddBoltTShirt(){addBoltTShirt.click();}
    @FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addFleeceJacket;
    public void clickAddFleeceJacket(){addFleeceJacket.click();}
    @FindBy(id="add-to-cart-sauce-labs-onesie")
    private WebElement addOnesie;
    public void clickAddOnesie(){addOnesie.click();}
    @FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
    private WebElement addRedTShirt;
    public void clickAddRedTShirt(){addRedTShirt.click();}

//Locator, method and validation regarding the presence of the "Remove" item from cart button.
    @FindBy(xpath = "//button[contains(text(), 'Remove')]")
    private WebElement removeButton;
    public void removeButtonPresence(){String ActualResult=removeButton.getText();
        Assert.assertTrue(ActualResult.contains("Remove"));}
    public void clickRemoveButton(){removeButton.click();}

//Method that checks if the "Remove" button is clickable and clicks it until is not.
    public boolean isRemoveButtonClickable() {
        try {return removeButton.isEnabled() && removeButton.isDisplayed();}
        catch (NoSuchElementException | StaleElementReferenceException e) {return false;}}
    public void clickRemoveButtonUntilNotClickable() {
        while (isRemoveButtonClickable()) {clickRemoveButton();}}

//Locator and method for the "Your Cart" button present on the Home Page.
    @FindBy(id="shopping_cart_container")
    private WebElement homePageCart;
    public void clickHomePageCart(){homePageCart.click();}

//Locators, methods and validations regarding the presence of items in the cart after adding.
    @FindBy(id="item_4_title_link")
    private WebElement backpackInCart;
    public void checkBackpackInCartTrue(){String ActualResult=backpackInCart.getText();
        Assert.assertTrue(ActualResult.contains("Backpack"));}
    @FindBy(id="item_0_title_link")
    private WebElement bikeLightInCart;
    public void checkBikeLightInCartTrue(){String ActualResult=bikeLightInCart.getText();
        Assert.assertTrue(ActualResult.contains("Bike Light"));}
    @FindBy(id="item_1_title_link")
    private WebElement boltTShirtInCart;
    public void checkBoltTShirtInCartTrue(){String ActualResult=boltTShirtInCart.getText();
        Assert.assertTrue(ActualResult.contains("Bolt T-Shirt"));}
    @FindBy(id="item_5_title_link")
    private WebElement fleeceJacketInCart;
    public void checkFleeceJacketInCartTrue(){String ActualResult=fleeceJacketInCart.getText();
        Assert.assertTrue(ActualResult.contains("Fleece Jacket"));}
    @FindBy(id="item_2_title_link")
    private WebElement onesieInCart;
    public void checkOnesieInCartTrue(){String ActualResult=onesieInCart.getText();
        Assert.assertTrue(ActualResult.contains("Onesie"));}
    @FindBy(id="item_3_title_link")
    private WebElement redTShirtInCart;
    public void checkRedTShirtInCartTrue(){String ActualResult=redTShirtInCart.getText();
        Assert.assertTrue(ActualResult.contains("T-Shirt (Red)"));}

//Locator for the "Continue Shopping" button present on the Your Cart page
    @FindBy(id="continue-shopping")
    private WebElement continueShopping;
    public void clickContinueShopping(){continueShopping.click();}

//Methods that fails the tests if the item is present and succeeds them if the item is not present, will be used to validate the "Remove" button functionality.
    public void checkBackpackInCartFalse() {
        try {checkBackpackInCartTrue();Assert.fail();
        } catch (NoSuchElementException e){}}
    public void checkBikeLightInCartFalse() {
        try {checkBikeLightInCartTrue();Assert.fail();
        } catch (NoSuchElementException e) {}}
    public void checkBoltTShirtInCartFalse() {
        try {checkBoltTShirtInCartTrue();Assert.fail();
        } catch (NoSuchElementException e) {}}
    public void checkFleeceJacketInCartFalse() {
        try {checkFleeceJacketInCartTrue();Assert.fail();
        } catch (NoSuchElementException e) {}}
    public void checkOnesieInCartFalse() {
        try {checkOnesieInCartTrue();Assert.fail();
        } catch (NoSuchElementException e) {}}
    public void checkRedTShirtInCartFalse() {
        try {checkRedTShirtInCartTrue();Assert.fail();
        } catch (NoSuchElementException e) {}}

//Locators and methods that verify the presence and matching of images with their allocated items, on the Home Page.
    @FindBy(css="#item_4_img_link > img")
    private WebElement backpackImageHomePage;
    public void checkBackpackImageHomePage(){String src = backpackImageHomePage.getAttribute("src");Assert.assertTrue(src.endsWith(".jpg")||src.contains("backpack"));}
    @FindBy(css="#item_0_img_link > img")
    private WebElement bikeLightImageHomePage;
    public void checkBikeLightImageHomePage(){String src = bikeLightImageHomePage.getAttribute("src");Assert.assertTrue(src.endsWith(".jpg")||src.contains("bike-light"));}
    @FindBy(css="#item_1_img_link > img")
    private WebElement boltTShirtImageHomePage;
    public void checkBoltTShirtImageHomePage(){String src = boltTShirtImageHomePage.getAttribute("src");Assert.assertTrue(src.endsWith(".jpg")||src.contains("bolt-shirt"));}
    @FindBy(css="#item_5_img_link > img")
    private WebElement fleeceJacketImageHomePage;
    public void checkFleeceJacketImageHomePage(){String src = fleeceJacketImageHomePage.getAttribute("src");Assert.assertTrue(src.endsWith(".jpg")||src.contains("pullover"));}
    @FindBy(css="#item_2_img_link > img")
    private WebElement onesieImageHomePage;
    public void checkOnesieImageHomePage(){String src = onesieImageHomePage.getAttribute("src");Assert.assertTrue(src.endsWith(".jpg")||src.contains("onesie"));}
    @FindBy(css="#item_3_img_link > img")
    private WebElement redTShirtImageHomePage;
    public void checkRedTShirtImageHomePage(){String src = redTShirtImageHomePage.getAttribute("src");Assert.assertTrue(src.endsWith(".jpg")||src.contains("red-tatt"));}

//Locators and methods that verify the presence and matching of prices with their intended value, on the Home Page.
    @FindBy(css="#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.pricebar > div")
    private WebElement backpackPriceHomePage;
    public void checkBackpackPriceHomePage(){String ActualResult=backpackPriceHomePage.getText();
        Assert.assertEquals(backpackPrice,ActualResult);}
    @FindBy(css="#inventory_container > div > div:nth-child(2) > div.inventory_item_description > div.pricebar > div")
    private WebElement bikeLightPriceHomePage;
    public void checkBikeLightPriceHomePage(){String ActualResult=bikeLightPriceHomePage.getText();
        Assert.assertEquals(bikeLightPrice,ActualResult);}
    @FindBy(css="#inventory_container > div > div:nth-child(3) > div.inventory_item_description > div.pricebar > div")
    private WebElement boltTShirtPriceHomePage;
    public void checkBoltTShirtPriceHomePage(){String ActualResult=boltTShirtPriceHomePage.getText();
        Assert.assertEquals(boltTShirtPrice,ActualResult);}
    @FindBy(css="#inventory_container > div > div:nth-child(4) > div.inventory_item_description > div.pricebar > div")
    private WebElement fleeceJacketPriceHomePage;
    public void checkFleeceJacketPriceHomePage(){String ActualResult=fleeceJacketPriceHomePage.getText();
        Assert.assertEquals(fleeceJacketPrice,ActualResult);}
    @FindBy(css="#inventory_container > div > div:nth-child(5) > div.inventory_item_description > div.pricebar > div")
    private WebElement onesiePriceHomePage;
    public void checkOnesiePriceHomePage(){String ActualResult=onesiePriceHomePage.getText();
        Assert.assertEquals(onesiePrice,ActualResult);}
    @FindBy(css="#inventory_container > div > div:nth-child(6) > div.inventory_item_description > div.pricebar > div")
    private WebElement redTShirtPriceHomePage;
    public void checkRedTShirtPriceHomePage(){String ActualResult=redTShirtPriceHomePage.getText();
        Assert.assertEquals(redTShirtPrice,ActualResult);}

//Locators for descriptions on items present on the Home Page and methods that verify them.
    @FindBy(css="#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.inventory_item_label > div")
    private WebElement backpackDescriptionHomePage;
    public void checkBackpackDescriptionHomePage(){String ActualResult=backpackDescriptionHomePage.getText();
        Assert.assertEquals(backpackDescription,ActualResult);}
    @FindBy(css="#inventory_container > div > div:nth-child(2) > div.inventory_item_description > div.inventory_item_label > div")
    private WebElement bikeLightDescriptionHomePage;
    public void checkBikeLightDescriptionHomePage(){String ActualResult=bikeLightDescriptionHomePage.getText();
        Assert.assertEquals(bikeLightDescription,ActualResult);}
    @FindBy(css="#inventory_container > div > div:nth-child(3) > div.inventory_item_description > div.inventory_item_label > div")
    private WebElement boltTShirtDescriptionHomePage;
    public void checkBoltTShirtDescriptionHomePage(){String ActualResult=boltTShirtDescriptionHomePage.getText();
        Assert.assertEquals(boltTShirtDescription,ActualResult);}
    @FindBy(css="#inventory_container > div > div:nth-child(4) > div.inventory_item_description > div.inventory_item_label > div")
    private WebElement fleeceJacketDescriptionHomePage;
    public void checkFleeceJacketDescriptionHomePage(){String ActualResult=fleeceJacketDescriptionHomePage.getText();
        Assert.assertEquals(fleeceJacketDescription,ActualResult);}
    @FindBy(css="#inventory_container > div > div:nth-child(5) > div.inventory_item_description > div.inventory_item_label > div")
    private WebElement onesieDescriptionHomePage;
    public void checkOnesieDescriptionHomePage(){String ActualResult=onesieDescriptionHomePage.getText();
        Assert.assertEquals(onesieDescription,ActualResult);}
    @FindBy(css="#inventory_container > div > div:nth-child(6) > div.inventory_item_description > div.inventory_item_label > div")
    private WebElement redTShirtDescriptionHomePage;
    public void checkRedTShirtDescriptionHomePage(){String ActualResult=redTShirtDescriptionHomePage.getText();
        Assert.assertEquals(redTShirtDescription,ActualResult);}

//Locators for items title hyperlinks and methods that verify them.
    @FindBy(css="#item_4_title_link > div")
    private WebElement backpackHyperlinkHomePage;
    public void checkBackpackHyperlinkHomePage(){backpackHyperlinkHomePage.click();String ActualResult=driver.getCurrentUrl();
        Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/inventory-item.html?id=4"));}
    public void clickBackpackHyperlinkHomePage(){backpackHyperlinkHomePage.click();}
    @FindBy(css="#item_0_title_link > div")
    private WebElement bikeLightHyperlinkHomePage;
    public void checkBikeLightHyperlinkHomePage(){bikeLightHyperlinkHomePage.click();String ActualResult=driver.getCurrentUrl();
        Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/inventory-item.html?id=0"));}
    public void clickBikeLightHyperlinkHomePage(){bikeLightHyperlinkHomePage.click();}
    @FindBy(css="#item_1_title_link > div")
    private WebElement boltTShirtHyperlinkHomePage;
    public void checkBoltTShirtHyperlinkHomePage(){boltTShirtHyperlinkHomePage.click();String ActualResult=driver.getCurrentUrl();
        Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/inventory-item.html?id=1"));}
    public void clickBoltTShirtHyperlinkHomePage(){boltTShirtHyperlinkHomePage.click();}
    @FindBy(css="#item_5_title_link > div")
    private WebElement fleeceJacketHyperlinkHomePage;
    public void checkFleeceJacketHyperlinkHomePage(){fleeceJacketHyperlinkHomePage.click();String ActualResult=driver.getCurrentUrl();
        Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/inventory-item.html?id=5"));}
    public void clickFleeceJacketHyperlinkHomePage(){fleeceJacketHyperlinkHomePage.click();}
    @FindBy(css="#item_2_title_link > div")
    private WebElement onesieHyperlinkHomePage;
    public void checkOnesieHyperlinkHomePage(){onesieHyperlinkHomePage.click();String ActualResult=driver.getCurrentUrl();
        Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/inventory-item.html?id=2"));}
    public void clickOnesieHyperlinkHomePage(){onesieHyperlinkHomePage.click();}
    @FindBy(css="#item_3_title_link > div")
    private WebElement redTShirtHyperlinkHomePage;
    public void checkRedTShirtHyperlinkHomePage(){redTShirtHyperlinkHomePage.click();String ActualResult=driver.getCurrentUrl();
        Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/inventory-item.html?id=3"));}
    public void clickRedTShirtHyperlinkHomePage(){redTShirtHyperlinkHomePage.click();}

//Locators for items sorting button.
    @FindBy(css="#header_container > div.header_secondary_container > div > span > select")
    private WebElement sortButton;
    @FindBy(css="#header_container > div.header_secondary_container > div > span > select > option:nth-child(1)")
    private WebElement sortButtonAZ;
    @FindBy(css="#header_container > div.header_secondary_container > div > span > select > option:nth-child(2)")
    private WebElement sortButtonZA;
    @FindBy(css="#header_container > div.header_secondary_container > div > span > select > option:nth-child(3)")
    private WebElement sortButtonLH;
    @FindBy(css="#header_container > div.header_secondary_container > div > span > select > option:nth-child(4)")
    private WebElement sortButtonHL;

//Locators for item description on individual item pages and methods that verify them.
    @FindBy(css="#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_desc.large_size")
    private WebElement descriptionItemPage;
    public void checkBackpackDescriptionItemPage(){String ActualResult=descriptionItemPage.getText();
        Assert.assertEquals(backpackDescription,ActualResult);}
    public void checkBikeLightDescriptionItemPage(){String ActualResult=descriptionItemPage.getText();
        Assert.assertEquals(bikeLightDescription,ActualResult);}
    public void checkBoltTShirtDescriptionItemPage(){String ActualResult=descriptionItemPage.getText();
        Assert.assertEquals(boltTShirtDescription,ActualResult);}
    public void checkFleeceJacketDescriptionItemPage(){String ActualResult=descriptionItemPage.getText();
        Assert.assertEquals(fleeceJacketDescription,ActualResult);}
    public void checkOnesieDescriptionItemPage(){String ActualResult=descriptionItemPage.getText();
        Assert.assertEquals(onesieDescription,ActualResult);}
    public void checkRedTShirtDescriptionItemPage(){String ActualResult=descriptionItemPage.getText();
        Assert.assertEquals(redTShirtDescription,ActualResult);}

//Locators for item image on individual item pages and methods that verify them.
    @FindBy(css="#inventory_item_container > div > div > div.inventory_details_img_container > img")
    private WebElement imageItemPage;
    public void checkBackpackImageItemPage(){String src = imageItemPage.getAttribute("src");Assert.assertTrue(src.endsWith(".jpg")||src.contains("backpack"));}
    public void checkBikeLightImageItemPage(){String src = imageItemPage.getAttribute("src");Assert.assertTrue(src.endsWith(".jpg")||src.contains("bike-light"));}
    public void checkBoltTShirtImageItemPage(){String src = imageItemPage.getAttribute("src");Assert.assertTrue(src.endsWith(".jpg")||src.contains("bolt-shirt"));}
    public void checkFleeceJacketItemPage(){String src = imageItemPage.getAttribute("src");Assert.assertTrue(src.endsWith(".jpg")||src.contains("pullover"));}
    public void checkOnesieImageItemPage(){String src = imageItemPage.getAttribute("src");Assert.assertTrue(src.endsWith(".jpg")||src.contains("onesie"));}
    public void checkRedTShirtImageItemPage(){String src = imageItemPage.getAttribute("src");Assert.assertTrue(src.endsWith(".jpg")||src.contains("red-tatt"));}

//Locators for item price on individual item pages and methods that verify them.
    @FindBy(css="#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_price")
    private WebElement priceItemPage;
    public void checkBackpackPriceItemPage(){String ActualResult=priceItemPage.getText();
        Assert.assertEquals(backpackPrice,ActualResult);}
    public void checkBikeLightPriceItemPage(){String ActualResult=priceItemPage.getText();
        Assert.assertEquals(bikeLightPrice,ActualResult);}
    public void checkBoltTShirtPriceItemPage(){String ActualResult=priceItemPage.getText();
        Assert.assertEquals(boltTShirtPrice,ActualResult);}
    public void checkFleeceJacketPriceItemPage(){String ActualResult=priceItemPage.getText();
        Assert.assertEquals(fleeceJacketPrice,ActualResult);}
    public void checkOnesiePriceItemPage(){String ActualResult=priceItemPage.getText();
        Assert.assertEquals(onesiePrice,ActualResult);}
    public void checkRedTShirtPriceItemPage(){String ActualResult=priceItemPage.getText();
        Assert.assertEquals(redTShirtPrice,ActualResult);}

//Locator for "Add to cart" button present on individual item pages.
    @FindBy(css="#add-to-cart")
    private WebElement addToCartItemPage;
    public void clickAddToCartItemPage(){addToCartItemPage.click();}

//Locator for "Remove" button present on individual item pages.
    @FindBy(css="#remove")
    private WebElement removeItemPage;
    public void clickAndCheckRemoveItemPage(){removeItemPage.click();String ActualResult=addToCartItemPage.getText();
        Assert.assertTrue(ActualResult.contains("Add to cart"));}

//Locator for the indicator representing the number of items present in the cart and a method that verifies its accuracy.
    @FindBy(css="#shopping_cart_container > a > span")
    private WebElement numberIndicator;
    public void checkNumberIndicator(){String ActualResult=numberIndicator.getText();
        List<WebElement> removeButtons = driver.findElements(By.xpath("//button[contains(text(), 'Remove')]"));
    int count = removeButtons.size();Assert.assertEquals(Integer.parseInt(ActualResult), count, "Number of items in cart is not equal to number of remove buttons");}

//Locator and method to verify the "Checkout" button.
    @FindBy(css="#checkout")
    private WebElement checkoutPaymentButton;
    public void clickCheckoutButton(){checkoutPaymentButton.click();}
    public void checkCheckoutButton(){String ActualResult=driver.getCurrentUrl();Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/checkout-step-one.html"));}

//Locators for the payment information text fields and methods to enter data.
    @FindBy(css="#first-name")
    private WebElement firstNameTextField;
    @FindBy(css="#last-name")
    private WebElement lastNameTextField;
    @FindBy(css="#postal-code")
    private WebElement zipCodeTextField;
    public void enterFirstName(String text){firstNameTextField.sendKeys(text);}
    public void enterLastName(String text){lastNameTextField.sendKeys(text);}
    public void enterZipCodeName(String text){zipCodeTextField.sendKeys(text);}

//Locator for the "Continue" payment button and a method to verify its functionality.
    @FindBy(css="#continue")
    private WebElement continuePayment;
    public void clickContinuePaymentButton(){continuePayment.click();}
    public void checkContinuePaymentButton(){String ActualResult=driver.getCurrentUrl();Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/checkout-step-two.html"));}

//Locator for the error message regarding the introduction of invalid payment information and methods to verify it.
    @FindBy(css="#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3")
    private WebElement paymentInformationErrorMessage;
    public void nullFirstNamePaymentInformationErrorMessage(){String ActualResult=paymentInformationErrorMessage.getText();Assert.assertTrue(ActualResult.contains("Error: First Name is required"));}
    public void nullLastNamePaymentInformationErrorMessage(){String ActualResult=paymentInformationErrorMessage.getText();Assert.assertTrue(ActualResult.contains("Error: Last Name is required"));}
    public void nullZipCodeNamePaymentInformationErrorMessage(){String ActualResult=paymentInformationErrorMessage.getText();Assert.assertTrue(ActualResult.contains("Error: Postal Code is required"));}

//Locators for the total price and individual prices of items in the cart and method sum up and verify it.
    @FindBy(css="#checkout_summary_container > div > div.summary_info > div.summary_subtotal_label")
    private WebElement totalPriceElement;
    @FindBy(css=".item_pricebar")
    private List<WebElement> individualPricesElement;
    public double sumPricesAndVerifyTotalWithoutTAX(){
        double sum=0.0;
            for (WebElement priceElement:individualPricesElement){
            String priceText=priceElement.getText();
            sum+=Double.parseDouble(priceText.replace("$",""));}
        String totalPriceText=totalPriceElement.getText().trim();
        double totalPrice=Double.parseDouble(totalPriceText.replace("Item total: $",""));
        Assert.assertEquals(totalPrice,sum);return sum;}

//Locator for the "Cancel" checkout button and method to verify it.
    @FindBy(id="cancel")
    private WebElement cancelCheckoutButton;
    public void clickAndCheckCancelCheckoutButton(){cancelCheckoutButton.click();}
    public void clickCancelCheckoutButton(){cancelCheckoutButton.click();String ActualResult=driver.getCurrentUrl();Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/inventory.html"));}

//Locator for the "Finish" button and a method to verify a successful payment.
    @FindBy(id="finish")
    private WebElement finishCheckoutButton;
    public void clickAndCheckFinishCheckoutButton(){finishCheckoutButton.click();String ActualResult= driver.getCurrentUrl();Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/checkout-complete.html"));}
    public void clickFinishCheckoutButton(){finishCheckoutButton.click();}

//Locator for the "Back Home" button and a method to verify its functionality.
    @FindBy(id="back-to-products")
    private WebElement backHomeButton;
    public void clickAndCheckBackHomeButton(){backHomeButton.click();String ActualResult= driver.getCurrentUrl();Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/inventory.html"));}
    public void clickBackHomeButton(){backHomeButton.click();}
}