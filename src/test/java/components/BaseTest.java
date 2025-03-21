package components;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    public WebDriver driver;

    public WebDriver initializDriver() throws IOException{
    /*
         * Check global.properties and get brower
         * if (browser == "chrome"){
         *      driver = chrome;
         * }else if(browser == "firefox") {
         *      driver = firefox;
         * }else{
         *      driver = edge
         * }
         */

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:/Users/rakha/OneDrive/Desktop/QAautomation/webautomationbatch2/src/main/java/com/webautomation/resources/GlobalData.properties");
         
        properties.load(fileInputStream);
        String browserName = properties.getProperty("browser");

        System.out.println("Browser Name: " + browserName);

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:/TestingDriver/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
        }

            else if(browserName.equals("firefox")){
                System.setProperty("webdriver.firefox.driver", "C:/TestingDriver/geckodriver/geckodriver.exe");
                driver = new FirefoxDriver();
            }
            else if(browserName.equals("msedge")){
                System.setProperty("webdriver.edge.driver", "C:/TestingDriver/msedgedriver/msedgedriver.exe");
                driver = new EdgeDriver();
            }
             else{
                System.out.println("Browser tidak terdeteksi");
            }
            driver.get("https://www.saucedemo.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            return driver;
    }

}
