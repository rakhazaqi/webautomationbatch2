package com.webautomation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponent;

public class CheckoutCart extends AbstractComponent {
    WebDriver driver;

    public CheckoutCart(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingcart;

    @FindBy(className = "checkout_button")
    WebElement cobtn;

    @FindBy(className = "inventory_item_name")
    List<WebElement> listProducts;

    By cartList = By.className("shopping_cart_link");

    public Boolean verifyCheckoutProduct(String productName){
        visibilityOfElementLocated(cartList);
        Boolean match = listProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public void checkoutPage(){
        visibilityOfElementLocated(cartList);
        shoppingcart.click();
        cobtn.click();
    }


        //  action.click(driver.findElement(By.className("shopping_cart_link"))).build().perform();
        // Thread.sleep(3000);

        // action.click(driver.findElement(By.className("checkout_button"))).build().perform();
        // Thread.sleep(3000);
    

}

