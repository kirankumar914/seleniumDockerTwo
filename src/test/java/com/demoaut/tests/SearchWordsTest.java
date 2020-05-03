package com.demoaut.tests;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.searchModule.pages.SearchPageTest;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import tests.BaseTest;

public class SearchWordsTest extends BaseTest {
    @Test
    @Parameters("keyword")
    public void SearchWordTest(String keyword)
    {
        SearchPageTest searchPageTest=new SearchPageTest(driver);
        searchPageTest.goTo();
        searchPageTest.searchWord(keyword);
        searchPageTest.goToVideos();
        int size=searchPageTest.getAllVideos();
        Assert.assertTrue(size>0);
    }

}
