package com.webautomation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponent;

public class ProductListPage extends AbstractComponent {

    WebDriver driver;
    WebElement product;

    public ProductListPage (WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item")
    List<WebElement> listProduct;

    
    public List<WebElement> getProductList(){
        return listProduct;
    }

    By btnCart = By.className("btn_inventory");
    By brandName = By.cssSelector("div[class='inventory_item_name ']");
    By listElement = By.className("inventory_item");

    public WebElement getProductByName(String productName){
        WebElement product = getProductList().stream().filter(prod -> prod.findElement(brandName).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);

        return product;
    }

    public void addToCart(String productName){
        visibilityOfElementLocated(listElement);
        product = getProductByName(productName);
        System.out.println("Hasil: "+product.getText());
        product.findElement(btnCart).click();
    }
    //  List<WebElement> listProduct = driver.findElements(By.className("inventory_item"));

    //     System.out.println("Products" + listProduct);

    //     WebElement product = listProduct.stream().filter(prod -> prod.findElement(By.cssSelector("div[class='inventory_item_name ']")).getText().equalsIgnoreCase(input.get("productName"))).findFirst().orElse(null);
    //     System.out.println("Hasil Stream: " + product.getText());

    //     product.findElement(By.className("btn_inventory")).click();

}
