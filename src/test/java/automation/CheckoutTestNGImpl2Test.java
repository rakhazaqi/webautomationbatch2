package automation;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckoutTestNGImpl2Test {

    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
            
        driver = new ChromeDriver();    
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Test(dataProvider = "dataTestMapping")
    public void createOrder(HashMap<String, String>input) throws InterruptedException {
        

        Actions action = new Actions(driver);
        action.sendKeys(driver.findElement(By.id("user-name")),input.get("username")).build().perform();

        action.sendKeys(driver.findElement(By.id("password")),input.get("pw")).build().perform();

        action.click(driver.findElement(By.className("submit-button"))).build().perform();

        List<WebElement> listProduct = driver.findElements(By.className("inventory_item"));

        System.out.println("Products" + listProduct);

        WebElement product = listProduct.stream().filter(prod -> prod.findElement(By.cssSelector("div[class='inventory_item_name ']")).getText().equalsIgnoreCase(input.get("productName"))).findFirst().orElse(null);
        System.out.println("Hasil Stream: " + product.getText());

        product.findElement(By.className("btn_inventory")).click();

        action.click(driver.findElement(By.className("shopping_cart_link"))).build().perform();
        Thread.sleep(3000);

        action.click(driver.findElement(By.className("checkout_button"))).build().perform();
        Thread.sleep(3000);

        action.sendKeys(driver.findElement(By.id("first-name")),"lazar").build().perform();

        action.sendKeys(driver.findElement(By.id("last-name")),"szamardzic").build().perform();

        action.sendKeys(driver.findElement(By.id("postal-code")),"123345").build().perform();

        action.click(driver.findElement(By.id("continue"))).build().perform();

        Thread.sleep(3000);

        action.click(driver.findElement(By.id("finish"))).build().perform();
        Thread.sleep(3000);

        String confirmPage = driver.findElement(By.className("complete-header")).getText();

        System.out.println("Order Status: " + confirmPage);

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

        return new Object[][] {{map}};

    }


}
