package com.webautomation.locator;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;

public class TaskLocator {

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver","C:/chromedriver/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
    
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");

            radioButton(driver);
            suggesionCountry(driver);
            dropdownEx(driver);
            checkboxEx(driver);
            switchWindow(driver);
            switchTab(driver);
            switchAlert(driver);
            confirmAlert(driver);
            webTable(driver);
            elementDisplay(driver);
            mouseHover(driver);

            driver.quit();
        }
        public static void radioButton(WebDriver driver) throws InterruptedException{
            driver.findElement(By.xpath("//input[@value='radio1']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='radio2']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='radio3']")).click();
            Thread.sleep(2000);
        }

        public static void suggesionCountry(WebDriver driver) throws InterruptedException{

            driver.findElement(By.id("autocomplete")).sendKeys("fr");
            Thread.sleep(3000);

            List<WebElement> country = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));

            for (WebElement webelement : country){
                System.out.println("Country list: "+webelement.getText());
                if (webelement.getText().equals("France")){
                    webelement.click();
                    break;
                }

            }
        }
        
        public static void dropdownEx(WebDriver driver) throws InterruptedException{

            WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
            Select dropdown = new Select(staticDropdown);

            System.out.println("All Option: " + dropdown.getAllSelectedOptions().size());
            System.out.println("First Option: " + dropdown.getFirstSelectedOption().getText());

            dropdown.selectByContainsVisibleText("Option1");
            Thread.sleep(3000);

            dropdown.selectByIndex(2);
            Thread.sleep(3000);

            dropdown.selectByValue("option3");
            Thread.sleep(3000);
        }
        public static void checkboxEx(WebDriver driver) throws InterruptedException{
            driver.findElement(By.id("checkBoxOption1")).click();
            Thread.sleep(1500);
            driver.findElement(By.id("checkBoxOption2")).click();
            Thread.sleep(1500);
            driver.findElement(By.id("checkBoxOption3")).click();
            Thread.sleep(1500);
            driver.findElement(By.id("checkBoxOption2")).click();
            Thread.sleep(1500);
            driver.findElement(By.id("checkBoxOption1")).click();
            Thread.sleep(1500);            
            driver.findElement(By.id("checkBoxOption1")).click();

        }

        public static void switchWindow(WebDriver driver) throws InterruptedException{
            Thread.sleep(2000);
            driver.findElement(By.id("openwindow")).click();
            Set<String> windows = driver.getWindowHandles();

            System.out.println("ID: " + windows);
            
            /*
             * ID: [EB56AA3F946F7C1D453D642A3F2BD66F, CB244CC14AFBEAC27EE3BBC9606056BA]
             */
            Iterator<String> iterator = windows.iterator();
            String parentId = iterator.next();
            String childId = iterator.next();

            driver.switchTo().window(childId);
            Thread.sleep(4000);

            driver.switchTo().window(parentId);
            Thread.sleep(3000);
        }
        public static void switchTab(WebDriver driver) throws InterruptedException{

            driver.findElement(By.id("opentab")).click();
            Thread.sleep(3000);

            Set<String> windows = driver.getWindowHandles();

            System.out.println("ID: " + windows);

            /*
             * [DCC9B4F1B78E0886FADA7EB4E2823B12, 5737164DA8FB0602765CAB422A63DA6E]
             */

             Iterator<String> iterator = windows.iterator();
             String parentId = iterator.next();
             String childId = iterator.next();
 
             driver.switchTo().window(childId);
             Thread.sleep(4000);
 
             driver.switchTo().window(parentId);
             Thread.sleep(3000);
        }

        public static void switchAlert(WebDriver driver) throws InterruptedException{
            driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys("lazar");
            Thread.sleep(3000);

            driver.findElement(By.id("alertbtn")).click();
            Thread.sleep(3000);

            // Beralih ke alert
            Alert alert = driver.switchTo().alert();
            // Klik tombol oke
            alert.accept();
        }
        public static void confirmAlert(WebDriver driver) throws InterruptedException{
            driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys("Lookman");
            Thread.sleep(3000);
            driver.findElement(By.id("confirmbtn")).click();
            Thread.sleep(3000);

            // Beralih ke alert
            Alert alert = driver.switchTo().alert();
            // Klik tombol oke
            alert.accept();
        }
        public static void webTable(WebDriver driver) throws InterruptedException{
            //table[id='product'] tbody tr td
            List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']//child::tbody//child::tr[4]"));

            for (WebElement webelement : rows){
                System.out.println("Rows: "+ webelement.getText());
                if (webelement.getText().equals("Appium (Selenium) - Mobile Automation Testing from Scratch")){
                    webelement.click();
                    break;
                }
            }
        }
        public static void elementDisplay(WebDriver driver) throws InterruptedException{
            driver.findElement(By.className("displayed-class")).sendKeys("Setty");
            Thread.sleep(2000);

            driver.findElement(By.id("hide-textbox")).click();
            Thread.sleep(3000);

            driver.findElement(By.id("show-textbox")).click();
            Thread.sleep(3000);
        }
        public static void mouseHover(WebDriver driver) throws InterruptedException{
            driver.findElement(By.className("mouse-hover")).click();
            Thread.sleep(2000);

            List<WebElement> hover = driver.findElements(By.cssSelector("div[class='mouse-hover-content'] a"));

            for (WebElement webelement : hover){
                System.out.println("List: " + webelement.getText());
                if(webelement.getText().equals("Reload")){
                    webelement.click();
                    break;
                }
            }
            Thread.sleep(3000);
        }
}
