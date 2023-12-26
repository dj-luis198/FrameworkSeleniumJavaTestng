package com.store.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.Base;

public class Login extends Base {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= initializeBrowserAndOpenApplicationURL("chrome");
        driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyLoginWithValidCredentials() {
       String actualTitleBox= driver.findElement(By.xpath("//h3[normalize-space()='Already registered?']")).getText();
       String expectedTitleBox= "ALREADY REGISTERED?";
       Assert.assertEquals(actualTitleBox, expectedTitleBox);
    }


    
}
