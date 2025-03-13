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

    By submitBtn = By.id("user-name");

    
    public void loginApplication(String usrname, String password){
        visibilityOfElementLocated(submitBtn);
        username.sendKeys(usrname);
        pw.sendKeys(password);
        submitbtn.click();
    }

}
