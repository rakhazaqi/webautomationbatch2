package com.webautomation.locator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntroduction {
    public static void main(String[] args) throws InterruptedException {
        // loginScenario();
        // incorrectPw();
        // blank();
        forgotPw();


    }

    // Positive Case
    public static void loginScenario() throws InterruptedException{
        
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();    
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(4000);
       

        driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("lazar@gmail.com");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
        Thread.sleep(4000);

        driver.findElement(By.className("signInBtn")).click();

        String name = driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText();

        System.out.println("Username= "+name);

        Thread.sleep(4000);

        driver.quit();
    }

    // Negative Case

    public static void incorrectPw() throws InterruptedException {
        
            System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
            
            WebDriver driver = new ChromeDriver();    
            driver.get("https://rahulshettyacademy.com/locatorspractice/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    
            Thread.sleep(4000);
           
    
            driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("lazar@gmail.com");
    
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("bbbbbbb");
            Thread.sleep(4000);
    
            driver.findElement(By.className("signInBtn")).click();
            
            String incr = driver.findElement(By.cssSelector("p.error")).getText();

            System.out.println("Hasil Output: "+incr);
            Thread.sleep(4000);

            driver.quit();
    }

    public static void blank() throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
            
            WebDriver driver = new ChromeDriver();    
            driver.get("https://rahulshettyacademy.com/locatorspractice/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    
            Thread.sleep(4000);

            String username = driver.findElement(By.xpath("//input[@id='inputUsername']")).getText();
            String pw = driver.findElement(By.xpath("//input[@placeholder='Password']")).getText();

            System.out.println("Username:" + username);
            System.out.println("Password: " + pw);

            if(username == "" || pw == ""){
                System.out.println("Form kosong");
            }

            driver.quit();   
    }

    public static void forgotPw() throws InterruptedException{

            System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
            
            WebDriver driver = new ChromeDriver();    
            driver.get("https://rahulshettyacademy.com/locatorspractice/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    
            Thread.sleep(4000);

            driver.findElement(By.cssSelector("div.forgot-pwd-container")).click();

            Thread.sleep(4000);

            driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Lookman");
            driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("lookman@gmail.com");

            Thread.sleep(4000);
            driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//button[normalize-space()='Go to Login']")).click();
            

            Thread.sleep(4000);
            driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("lookman@gmail.com");
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");

            Thread.sleep(4000);

            driver.findElement(By.id("chkboxOne")).click();
            driver.findElement(By.id("chkboxTwo")).click();
            Thread.sleep(3000);

            driver.findElement(By.className("signInBtn")).click();
            
            Thread.sleep(3000);
            driver.quit();

    }

}
