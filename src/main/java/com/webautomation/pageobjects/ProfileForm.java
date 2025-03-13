package com.webautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webautomation.abstractcomponents.AbstractComponent;

public class ProfileForm extends AbstractComponent {
    WebDriver driver;

    public ProfileForm(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement firstname;

    @FindBy(id = "last-name")
    WebElement lastname;

    @FindBy(id = "postal-code")
    WebElement postal;

    @FindBy(id = "continue")
    WebElement continuebtn;

    By formElement = By.id("first-name");

    public void profilePage(String frstname, String lstname, String postal1){
        visibilityOfElementLocated(formElement);
        firstname.sendKeys(frstname);
        lastname.sendKeys(lstname);
        postal.sendKeys(postal1);
        continuebtn.click();
    }
    // action.sendKeys(driver.findElement(By.id("first-name")),"lazar").build().perform();

    //     action.sendKeys(driver.findElement(By.id("last-name")),"szamardzic").build().perform();

    //     action.sendKeys(driver.findElement(By.id("postal-code")),"123345").build().perform();

    //     action.click(driver.findElement(By.id("continue"))).build().perform();

}
