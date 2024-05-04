package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);}

//Locators for the "enter username & password" text fields.
    @FindBy(id="user-name")
    private WebElement usernameField;
    public void enterUsername(String text){usernameField.sendKeys(text);}
    @FindBy(id="password")
    private WebElement passwordField;
    public void enterPassword(String text){passwordField.sendKeys(text);}

//Locator for the login button.
    @FindBy(id="login-button")
    private WebElement loginButton;
    public void clickLoginButton(){loginButton.click();}

//Locator for the login error message.
    @FindBy(css="#login_button_container > div > form > div.error-message-container.error > h3")
    private WebElement loginErrorMessage;
    public void loginErrorMessageDisplayed(){String ActualResult=loginErrorMessage.getText();
        Assert.assertTrue(ActualResult.contains("Epic sadface: Username and password do not match any user in this service"));}
}