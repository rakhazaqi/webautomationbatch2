package com.webautomation.scenario;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {
          /*
         * 1. Implement e2e test for checkout
         * 2. Wait != Thread
         * 3. Stream
         */

        /*
         * Scenario automation
         * 1. Buyer Login
         * 2. Buyer checkout product
         * 3. Verifikasi thanks page
         */
        System.setProperty("webdriver.chrome.driver", "C:/TestingDriver/chromedriver/chromedriver.exe");
            
        WebDriver driver = new ChromeDriver();    
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        /*
         * Email: lazar@gmail.com
         * pw: Lazarlazar11#
         */

        driver.findElement(By.id("userEmail")).sendKeys("lazar@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Lazarlazar11#");
        // Thread.sleep(3000);

        driver.findElement(By.className("login-btn")).click();
        // Thread.sleep(3000);

        List<WebElement> ListProduct = driver.findElements(By.className("mb-3"));
        
        String productName = "ZARA COAT 3";

        // ListProduct.forEach(prod -> System.out.println(prod.getText()));

        WebElement product = ListProduct.stream().filter(prod -> prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        System.out.println("Hasil Stream: "+ product.getText());
        Thread.sleep(3000);

        // product.findElement(By.xpath("//div[@class='card-body']//child::button//child::i[@class='fa fa-shopping-cart']")).click();
        product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        // product.findElement(By.xpath("//div[@class='card-body']//child::button//child::i[@class='fa fa-shopping-cart']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@class='btn btn-custom']//child::i[@class='fa fa-shopping-cart']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//li[@class='totalRow'])[3]//child::button")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("div[class='form-group'] input")).sendKeys("ind");
        List<WebElement> listCountry = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
       

        Thread.sleep(3000);

        String countryName = "Indonesia";

        WebElement country = listCountry.stream().filter(count -> count.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null);
        System.out.println("Hasil list country" + country.getText());
        Thread.sleep(2000);

        country.click();

        driver.findElement(By.className("action__submit")).click();
        Thread.sleep(2000);

        String confirmPage = driver.findElement(By.className("hero-primary")).getText();
        System.out.println("Order Status: " + confirmPage);

        

        driver.quit();
    }
    

}
