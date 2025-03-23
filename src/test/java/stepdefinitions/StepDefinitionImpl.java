package stepdefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.webautomation.pageobjects.CheckoutCart;
import com.webautomation.pageobjects.ConfirmPage;
import com.webautomation.pageobjects.LandingPage;
import com.webautomation.pageobjects.ProductListPage;
import com.webautomation.pageobjects.ProfileForm;

import components.BaseTest;
import hook.Hook1;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest {

    WebDriver driver;
    
    @Given("User was landing on the website")
    public void landingPage() throws IOException{

        driver = Hook1.initializeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Given("^Buyer logged on the website username (.+) password (.+)$")
    public void loginWebsite(String username, String password){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginApplication(username, password);
    }

    @Given("^User logged on the website username (.+) password (.+)$")
    public void loginWebsite1(String username, String password){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginApplication(username, password);
    }

    @When("^Buyer place order firstname (.+), lastname (.+), and postal (.+)$")
    public void fillsForm(String first_name, String last_name, String postal){
        ProfileForm profileForm = new ProfileForm(driver);
        profileForm.profilePage(first_name, last_name, postal);
    }

   @When("User fills in username {string} and password {string} on the login form")
    public void loginWebsite2(String username, String password){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.loginApplication(username, password);
    }

    @When("^Buyer add product (.+) to cart$")
    public void listProduct(String product_name){
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.addToCart(product_name);
    }

    @When("^User add product (.+) to cart$")
    public void listProduct2(String product_name){
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.addToCart(product_name);
    }

    @And("^Buyer checkout product (.+)$")
    public void checkoutCart(String product_name){
        // String productName = "Sauce Labs Bike Light";
        CheckoutCart checkoutCart = new CheckoutCart(driver);
        Assert.assertTrue(checkoutCart.verifyCheckoutProduct(product_name));
        checkoutCart.checkoutPage();
    }

    @And("Buyer places order firstname (.+), lastname (.+), and postal (.+)")
    public void formOrder(String first_name, String last_name, String postal){
        ProfileForm profileForm = new ProfileForm(driver);
        profileForm.profilePage(first_name, last_name, postal);
    }

    @And("Buyer places order firstname {string}, lastname {string}, and postal code {string}")
    public void formOrder1(String first_name, String last_name, String postal){
        ProfileForm profileForm = new ProfileForm(driver);
        profileForm.profilePage(first_name, last_name, postal);
    }

    @And("^User remove product(.+) from cart$")
    public void removeCart(String product_name){
        CheckoutCart checkoutCart = new CheckoutCart(driver);
        checkoutCart.removeProduct(product_name);

    }

    @And("User choice Logout on the menu button")
    public void logoutEcom(){
        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.logOut();
    }

    @Then("^Buyer will see message is displayed on confirmation page (.+)$")
    public void confirmPage(String confirm_text){
        ConfirmPage confirmPage = new ConfirmPage(driver);
        confirmPage.confPage();
        String confirmationText = confirmPage.getConfirmationText();
        Assert.assertEquals(confirmationText, confirm_text);
        
    }
    @Then("User was landing on the product list page")
    public void productList(){
    }


    @Then("^User will see error message is displayed (.+)$")
    public void errorMessage(String errormsg){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.getErrorMessage();
        String confirmErrorMsg = landingPage.getErrorMessage();
        Assert.assertEquals(confirmErrorMsg, errormsg);
    }
    @Then("^Buyer will see error message is displayed (.+)$")
    public void errorMessage1(String errormsg){
        ProfileForm profileForm = new ProfileForm(driver);
        profileForm.getErrorText();
        String confirmErrorText = profileForm.getErrorText();
        Assert.assertEquals(confirmErrorText, errormsg);
    }
    @Then("User will see cart is empty")
    public void emptyCart(){
        driver.close();
    }
    // @Then("User was landing on the login page")
    // public void loginPage(){
    //     driver.close();
    // }
    @Then("User was landing on the login page")
    public void landingPage1() throws IOException{

        driver = Hook1.initializeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Given("Buyer logged on the website")
    public void landingPage2(){

    }

}
