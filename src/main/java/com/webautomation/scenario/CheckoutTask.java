package com.webautomation.scenario;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CheckoutTask {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
            
        WebDriver driver = new ChromeDriver();    
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Actions action = new Actions(driver);
        action.sendKeys(driver.findElement(By.id("user-name")),"standard_user").build().perform();

        action.sendKeys(driver.findElement(By.id("password")),"secret_sauce").build().perform();

        action.click(driver.findElement(By.className("submit-button"))).build().perform();

        List<WebElement> listProduct = driver.findElements(By.className("inventory_item"));

        System.out.println("Products" + listProduct);

        String name = "Sauce Labs Bike Light";

        WebElement product = listProduct.stream().filter(prod -> prod.findElement(By.cssSelector("div[class='inventory_item_name ']")).getText().equalsIgnoreCase(name)).findFirst().orElse(null);
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

        driver.quit();
    }

}
