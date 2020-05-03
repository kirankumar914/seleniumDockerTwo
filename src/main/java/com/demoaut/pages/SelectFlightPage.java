package com.demoaut.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectFlightPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement selectFlightSubmitBtn;

    @FindBy(name = "buyFlights")
    private WebElement bookFlightSubmitBtn;

    public SelectFlightPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goToBookFlightPage()
    {
        this.wait.until(ExpectedConditions.visibilityOf(selectFlightSubmitBtn));
        this.selectFlightSubmitBtn.click();
    }

    public void goToFlightConfirmationPage()
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(bookFlightSubmitBtn));
                this.bookFlightSubmitBtn.click();
    }
}
