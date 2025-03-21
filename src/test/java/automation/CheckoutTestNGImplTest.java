package automation;

import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.webautomation.pageobjects.CheckoutCart;
import com.webautomation.pageobjects.ConfirmPage;
import com.webautomation.pageobjects.LandingPage;
import com.webautomation.pageobjects.ProductListPage;
import com.webautomation.pageobjects.ProfileForm;

public class CheckoutTestNGImplTest {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/TestingDriver/chromedriver/chromedriver.exe");
            
        driver = new ChromeDriver();    
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Test(dataProvider = "dataTestMapping")
    public void createOrder(HashMap<String, String>input) throws InterruptedException {
        Thread.sleep(2000);
        

        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginApplication(input.get("username"), input.get("pw"));

        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.addToCart(input.get("productName"));

        String productName = "Sauce Labs Bike Light";
        CheckoutCart checkoutCart = new CheckoutCart(driver);
        Assert.assertTrue(checkoutCart.verifyCheckoutProduct(productName));
        checkoutCart.checkoutPage();
        
        ProfileForm profileForm = new ProfileForm(driver);
        profileForm.profilePage(input.get("firstname"),input.get("lastname"), input.get("postal"));

        ConfirmPage confirmPage = new ConfirmPage(driver);
        confirmPage.confPage();
        String confirmationText = confirmPage.getConfirmationText();
        Assert.assertEquals(confirmationText, "Thank you for your order!");

    }
    @AfterMethod
    public void tearsDown(){
        driver.close();
    }
    @DataProvider
    public Object [][] dataTest(){
        return new Object [][] {
            {"standard_user", "secret_sauce", "Sauce Labs Bike Light" },
        };
    }
    //Mapping
    @DataProvider
    public Object [][] dataTestMapping(){
        HashMap <String, String> map = new HashMap<String, String>();
        map.put("username", "standard_user");
        map.put("pw", "secret_sauce");
        map.put("productName", "Sauce Labs Bike Light");
        map.put("firstname","Lazar");
        map.put("lastname", "Samardzic");
        map.put("postal", "123456");

        return new Object[][] {{map}};

    }


}
