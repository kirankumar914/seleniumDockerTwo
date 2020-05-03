package com.demoaut.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demoaut.pages.FlightConfirmationPage;
import com.demoaut.pages.FlightFinderPage;
import com.demoaut.pages.RegistartaionConfirmationPage;
import com.demoaut.pages.RegistartionPage;
import com.demoaut.pages.SelectFlightPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import tests.BaseTest;

public class FlightBookingTest extends BaseTest {
    private String numberOffPax;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"numberOffPax","expectedPrice"})
    public void driverInitialization(String numberOffPax, String expectedPrice)
    {
        this.numberOffPax=numberOffPax;
        this.expectedPrice=expectedPrice;
    }

    @Test
    public void registartaionPageTest()
    {
        RegistartionPage registartionPage=new RegistartionPage(driver);
        registartionPage.goToRegistartionPage();
        registartionPage.fillContactInformation("kiran","kumar");
        registartionPage.fillUserInformation("Navya","golu");
        registartionPage.clickOnSubmitButton();
    }

    @Test(dependsOnMethods = "registartaionPageTest")
    public void registartionConfirmationPageTest()
    {
        RegistartaionConfirmationPage registartaionConfirmationPage=new RegistartaionConfirmationPage(driver);
        registartaionConfirmationPage.goToFlightFinderPage();
    }

    @Test(dependsOnMethods = "registartionConfirmationPageTest")
    public void flightFinderPageTest()
    {
        FlightFinderPage flightFinderPage=new FlightFinderPage(driver);
        flightFinderPage.selectNumberOFPax(this.numberOffPax);
        flightFinderPage.goToSelectFlightPage();
    }

    @Test(dependsOnMethods = "flightFinderPageTest")
    public void selectFlightPageTest()
    {
        SelectFlightPage selectFlightPage=new SelectFlightPage(driver);
        selectFlightPage.goToBookFlightPage();
        selectFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "selectFlightPageTest")
    public void flightConfirmationPageTest()
    {
        FlightConfirmationPage flightConfirmationPage=new FlightConfirmationPage(driver);
        flightConfirmationPage.getConfirmationTxt();
        String actualPrice=flightConfirmationPage.getTotalPrice();
        Assert.assertEquals(actualPrice,this.expectedPrice);
        flightConfirmationPage.sigOff();
    }

    @AfterTest
    public void closeBrowser()
    {
        this.driver.quit();
    }
}
