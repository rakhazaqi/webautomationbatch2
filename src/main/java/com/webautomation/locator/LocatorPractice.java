package com.webautomation.locator;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {

        // locator1();
        // locator2();
        // orderLocator();
        searchCountry();

        
    }
    public static void locator1() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
            
            WebDriver driver = new ChromeDriver();    
            driver.get("https://rahulshettyacademy.com/dropdownsPractise");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            Thread.sleep(3000);

            WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); 

            Select dropdown = new Select(staticDropdown);

            System.out.println("All Option " + dropdown.getAllSelectedOptions().size());
            System.out.println("First option " + dropdown.getFirstSelectedOption().getText());

            //First way dropdown w/select option
            dropdown.selectByContainsVisibleText("AED");
            System.out.println("AED" + dropdown.getFirstSelectedOption().getText());

            Thread.sleep(3000);
            //Second way
            dropdown.selectByValue("USD");

            Thread.sleep(3000);
            //Third way
            dropdown.selectByIndex(1);

            Thread.sleep(3000);
            driver.quit();

    }


    public static void locator2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
            
        WebDriver driver = new ChromeDriver();    
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(3000);

            
            //Handle dynamic dropdown
            driver.findElement(By.id("divpaxinfo")).click();

            //Add passenger
            for (int i = 0; i < 5; i++){
                driver.findElement(By.id("hrefIncAdt")).click();
            }
            Thread.sleep(2000);

            //Add child
            for (int i = 0; i < 3; i++){
                driver.findElement(By.id("hrefIncChd")).click();
            }
            Thread.sleep(2000);

            //Decrease child
            for (int i = 0; i < 3; i++){
                driver.findElement(By.id("hrefDecChd")).click();
            }
            Thread.sleep(2000);

            driver.findElement(By.id("btnclosepaxoption")).click();
            Thread.sleep(3000);

            driver.quit();
    }

    public static void orderLocator() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
            
        WebDriver driver = new ChromeDriver();    
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
        Thread.sleep(3000);

        List<WebElement> options = driver.findElements(By.xpath("//div[@id='dropdownGroup1']//child::div[@class='dropdownDiv']//child::ul[1]//child::li"));
        System.out.println("Destination options: " + options);

        for (WebElement element : options){
            // System.out.println("Countrylist: "+ element.getText());
            if(element.getText().equals("Bengaluru (BLR)")){
                element.click();
                break;
            }
        }
        Thread.sleep(3000);

        List<WebElement> options2 = driver.findElements(By.xpath("(//div[@id='dropdownGroup1']//child::div[@class='dropdownDiv']//child::ul[1])[2]//child::li"));
        // System.out.println("Arrivals options: " + options2);

        for (WebElement element : options2){
            System.out.println("Arrival country list: "+ element.getText());
            if(element.getText().equals("Dehradun (DED)")){
                element.click();
                break;
            }
        }
        Thread.sleep(3000);
        driver.quit();
    }
    public static void searchCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
            
        WebDriver driver = new ChromeDriver();    
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);

        List<WebElement> search = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement webelement : search){
            System.out.println("List of Country: "+ webelement.getText());
            if (webelement.getText().equals("Indonesia")){
                webelement.click();
                break;
            }
        }
        Thread.sleep(3000);

        driver.quit();

    }
}

