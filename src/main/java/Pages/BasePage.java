package Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage
{
//Choosing and initializing the Web Driver before every test.
    public static WebDriver driver;
    private static final String BASE_URL="https://www.saucedemo.com/";
    public BasePage(){}
    public BasePage(WebDriver driver){
        BasePage.driver=driver;}

    @BeforeMethod
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);}

//An AfterMethod that closes the window after every test.
    @AfterMethod
    public void tearDown(){if(driver!=null){driver.quit();}}
}