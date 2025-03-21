package com.webautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement pw;

    @FindBy(className = "submit-button")
    WebElement submitbtn;

    @FindBy(css = "h3[data-test='error']")
    WebElement errormsg;

    By submitBtn = By.id("user-name");
    By confirmErrorMsg = By.cssSelector("h3[data-test='error']");

    
    public void loginApplication(String usrname, String password){
        visibilityOfElementLocated(submitBtn);
        username.sendKeys(usrname);
        pw.sendKeys(password);
        submitbtn.click();
    }
    public String getErrorMessage(){
        visibilityOfElementLocated(confirmErrorMsg);
        System.out.println("error" + errormsg.getText());
        return errormsg.getText();

    }

}
