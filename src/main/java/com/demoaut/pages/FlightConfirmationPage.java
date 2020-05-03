package com.demoaut.pages;

import java.security.Principal;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),'Flight')]")
    private WebElement confirmationTxt;

    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> totalPrice;

    @FindBy(xpath = "//a[contains(text(),'SIGN-OFF')]")
    private WebElement signOffLink;

    public FlightConfirmationPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void getConfirmationTxt()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.confirmationTxt));
        System.out.println(this.confirmationTxt.getText());
    }

    public String getTotalPrice()
    {
        System.out.println(this.totalPrice.get(1).getText());
        String actualPrice=this.totalPrice.get(1).getText();
        return actualPrice;
    }

    public void sigOff()
    {
        this.signOffLink.click();
    }
}
