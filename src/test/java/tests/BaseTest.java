package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUpDriver() throws MalformedURLException {
        //localhost
        //browsername
        String host="localhost";
        DesiredCapabilities desiredCapabilities;

        if(System.getProperty("BROWSER")!=null && System.getProperty("BROWSER").equalsIgnoreCase("firefox"))
        {
            desiredCapabilities=DesiredCapabilities.firefox();
        }
        else {
            desiredCapabilities=DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST")!=null)
        {
            host=System.getProperty("HUB_HOST");
        }

        String completeURL="http://"+host+":4444/wd/hub";
        this.driver=new RemoteWebDriver(new URL(completeURL),desiredCapabilities);

// New way of assigning a chrome browser.
//        WebDriverManager.chromedriver().setup();
//        this.driver=new ChromeDriver();
    }

    @AfterTest
    public void quitBrowser(){
        this.driver.quit();
    }
}
