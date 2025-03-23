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
    WebElement product;

    public CheckoutCart(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingcart;

    @FindBy(className = "checkout_button")
    WebElement cobtn;

    @FindBy(className = "inventory_item_name") //BoxItem
    List<WebElement> listProducts;

    @FindBy(className = "cart_item") //Text
    List<WebElement> listCart;

    public List<WebElement> getProductList(){
        return listProducts;
    }

    By cartList = By.className("shopping_cart_link");
    By productCart = By.className("cart_item");
    By brandCart = By.className("inventory_item_name");
    By btnRemove = By.className("btn_small");

    public Boolean verifyCheckoutProduct(String productName){
        visibilityOfElementLocated(cartList);
        Boolean match = listProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }
    public WebElement getProductByName(String productName){
        WebElement product = getProductList().stream().filter(prod -> prod.findElement(brandCart).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        return product;
    }

    public void checkoutPage(){
        visibilityOfElementLocated(cartList);
        shoppingcart.click();
        cobtn.click();
    }
    public void removeProduct(String productName){
        visibilityOfElementLocated(cartList);
        product = getProductByName(productName);
        System.out.println("Hasil: " + product.getText());
        product.findElement(btnRemove).click();
    }

}

