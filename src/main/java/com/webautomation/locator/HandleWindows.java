package com.webautomation.locator;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindows {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Thread.sleep(3000);
       
        driver.findElement(By.className("blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();
        /*
        * Value yg didapat [parentID, childID]
        * [3D8DE969CD7E3CA866EBC6DF89D719F9, C3025CB3098688511A5707E109AA85FB]
        */
        System.out.println("Ini idnya" + windows);

        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();


        driver.switchTo().window(childId);

        Thread.sleep(3000);

        driver.switchTo().window(parentId);

        Thread.sleep(3000);

        driver.quit();
    }
}
