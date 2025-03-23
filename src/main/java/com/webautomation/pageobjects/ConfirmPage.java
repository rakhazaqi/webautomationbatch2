package com.webautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponent;

public class ConfirmPage extends AbstractComponent{
    WebDriver driver;

    public ConfirmPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "complete-header")
    WebElement confirmText;

    @FindBy(id= "finish")
    WebElement finishBtn;

    By confirmFinal = By.className("complete-header");

    public String getConfirmationText(){
        visibilityOfElementLocated(confirmFinal);
        return confirmText.getText();

    }
    public void confPage(){
        
        finishBtn.click();
        confirmText.getText();
        System.out.println("Status Orderan: " + confirmText.getText());
    }


    // action.click(driver.findElement(By.id("finish"))).build().perform();
    //     String confirmPage = driver.findElement(By.className("complete-header")).getText();
    //     System.out.println("Order Status: " + confirmPage);


}
