package com.searchModule.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageTest {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @FindBy(xpath = "//input[@id='search_form_input_homepage']")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@id='search_button_homepage']")
    private WebElement searchBtn;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;


    public SearchPageTest(WebDriver driver)
    {
        this.driver=driver;
        this.webDriverWait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goTo()
    {
        this.driver.get("https://duckduckgo.com/");
    }

    public void searchWord(String word)
    {
       this.webDriverWait.until(ExpectedConditions.visibilityOf(searchBox));
       this.searchBox.sendKeys(word);
       this.searchBtn.click();
    }

    public void goToVideos()
    {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(videosLink));
        this.videosLink.click();
    }

    public int getAllVideos()
    {
        By by= By.className("tile--vid");
        this.webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println(this.allVideos.size());
        return this.allVideos.size();
    }



}
