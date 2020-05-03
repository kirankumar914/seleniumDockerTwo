package com.demoaut.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightFinderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//select[@name='passCount']")
    private WebElement passengersDropDown;

    @FindBy(name="findFlights")
    private WebElement continueBtn;

    public FlightFinderPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void selectNumberOFPax(String countTobeSelected)
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.passengersDropDown));
        Select select=new Select(this.passengersDropDown);
        select.selectByValue(countTobeSelected);
    }

    public void goToSelectFlightPage()
    {
        this.continueBtn.click();
    }
}
