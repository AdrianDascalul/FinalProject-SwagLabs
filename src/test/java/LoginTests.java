import pages.BasePage;
import pages.LoginPage;
import io.qameta.allure.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BasePage
{
    private LoginPage loginPage;

    @BeforeMethod
        public void setUp(){
            super.setUp();
            loginPage=new LoginPage(driver);}

//Login with valid credentials.
    @Test
    public void login() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        String ActualResult = driver.getCurrentUrl();
        Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/inventory.html"));}

//Login and use "Enter" button on the keyboard for validation.
    @Epic("Implement Login functionality")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginKeyboard() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        String ActualResult = driver.getCurrentUrl();
        Assert.assertTrue(ActualResult.contains("https://www.saucedemo.com/inventory.html"));}

//Login with invalid credentials and verify the presence of an error message.
    @Story("Verify login with wrong username")
    @Test
    public void loginWrongUsername() {
        loginPage.enterUsername("wrong username");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        loginPage.loginErrorMessageDisplayed();}
    @Story("Verify login with wrong password")
    @Test
    public void loginWrongPassword() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("wrong password");
        loginPage.clickLoginButton();
        loginPage.loginErrorMessageDisplayed();}
    @Story("Verify login with wrong username and password")
    @Test
    public void loginWrongBoth() {
        loginPage.enterUsername("wrong username");
        loginPage.enterPassword("wrong password");
        loginPage.clickLoginButton();
        loginPage.loginErrorMessageDisplayed();}
}