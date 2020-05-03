package com.demoaut.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistartionPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath="//a[contains(text(),'REGISTER')]")
    private WebElement registerLink;

    @FindBy(name="firstName")
    private WebElement firstNameTxt;

    @FindBy(name="lastName")
    private WebElement lastNameTxt;

    @FindBy(id="email")
    private WebElement userNameTxt;

    @FindBy(name="password")
    private WebElement passwordTxt;

    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "register")
    private WebElement submitButton;

    public RegistartionPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goToRegistartionPage()
    {
        this.driver.get("http://demoaut.com/");
//        this.driver.manage().window().maximize();
        this.wait.until(ExpectedConditions.visibilityOf(registerLink));
        this.registerLink.click();
        this.wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
    }

    public void fillContactInformation(String firstName,String lastName)
    {
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
    }

    public void fillUserInformation(String userName, String password)
    {
        this.userNameTxt.sendKeys(userName);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(password);
    }

    public void clickOnSubmitButton()
    {
        this.submitButton.click();
    }
}
