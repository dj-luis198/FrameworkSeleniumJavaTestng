package com.store.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.store.base.Base;

public class Login extends Base {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationURL("chrome");
        driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyLoginWithValidCredentials() {
        driver.findElement(By.id("email")).sendKeys("testmail@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("test1");
        driver.findElement(By.id("SubmitLogin")).click();
        String actualTitle = driver.getTitle();
        String expectedTitle = "My account - My Shop";
        Assert.assertEquals(actualTitle, expectedTitle);
        String actualText = driver.findElement(By.cssSelector("#center_column>h1")).getText();
        String expectedText = "MY ACCOUNT";
        Assert.assertEquals(actualText, expectedText);
        driver.findElement(By.className("logout")).click();
    }

    @Test
    public void verifyLoginWithoutCredentials() {
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed(),
                "Error message is not displayed");
        String actualTitleAlert = driver.findElement(By.cssSelector("#center_column>.alert-danger>p")).getText();
        String expectedTitleAlert = "There is 1 error";
        Assert.assertEquals(actualTitleAlert, expectedTitleAlert);
        String actualItemAlert = driver.findElement(By.cssSelector("#center_column>.alert-danger>ol>li")).getText();
        String expectedItemAlert = "An email address required.";
        Assert.assertEquals(actualItemAlert, expectedItemAlert);
    }

    @Test
    public void verifyLoginWithoutCredentialPassword() {
        driver.findElement(By.id("email")).sendKeys("testmail@gmail.com");
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed(),
                "Error message is not displayed");
        String actualTitleAlert = driver.findElement(By.cssSelector("#center_column>.alert-danger>p")).getText();
        String expectedTitleAlert = "There is 1 error";
        Assert.assertEquals(actualTitleAlert, expectedTitleAlert);
        String actualItemAlert = driver.findElement(By.cssSelector("#center_column>.alert-danger>ol>li")).getText();
        String expectedItemAlert = "Password is required.";
        Assert.assertEquals(actualItemAlert, expectedItemAlert);
    }

    @Test
    public void verifyLoginWithInvalidCredentialPassword() {
        driver.findElement(By.id("email")).sendKeys("testmail@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("1234");
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed(),
                "Error message is not displayed");
        String actualTitleAlert = driver.findElement(By.cssSelector("#center_column>.alert-danger>p")).getText();
        String expectedTitleAlert = "There is 1 error";
        Assert.assertEquals(actualTitleAlert, expectedTitleAlert);
        String actualItemAlert = driver.findElement(By.cssSelector("#center_column>.alert-danger>ol>li")).getText();
        String expectedItemAlert = "Invalid password.";
        Assert.assertEquals(actualItemAlert, expectedItemAlert);
    }

    @Test
    public void verifyLoginWithInvalidCredentialEmail() {
        driver.findElement(By.id("email")).sendKeys("testmail@gmail");
        driver.findElement(By.id("passwd")).sendKeys("1234");
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed(),
                "Error message is not displayed");
        String actualTitleAlert = driver.findElement(By.cssSelector("#center_column>.alert-danger>p")).getText();
        String expectedTitleAlert = "There is 1 error";
        Assert.assertEquals(actualTitleAlert, expectedTitleAlert);
        String actualItemAlert = driver.findElement(By.cssSelector("#center_column>.alert-danger>ol>li")).getText();
        String expectedItemAlert = "Invalid email address.";
        Assert.assertEquals(actualItemAlert, expectedItemAlert);
    }

    @Test
    public void verifyLoginWhithIncorrectPassword() {
        driver.findElement(By.id("email")).sendKeys("testmail@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("test2");
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed(),
                "Error message is not displayed");
        String actualTitleAlert = driver.findElement(By.cssSelector("#center_column>.alert-danger>p")).getText();
        String expectedTitleAlert = "There is 1 error";
        Assert.assertEquals(actualTitleAlert, expectedTitleAlert);
        String actualItemAlert = driver.findElement(By.cssSelector("#center_column>.alert-danger>ol>li")).getText();
        String expectedItemAlert = "Authentication failed.";
        Assert.assertEquals(actualItemAlert, expectedItemAlert);
    }

    @Test
    public void verifyLoginWhithIncorrectEmail() {
        driver.findElement(By.id("email")).sendKeys("testmail1@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("test1");
        driver.findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed(),
                "Error message is not displayed");
        String actualTitleAlert = driver.findElement(By.cssSelector("#center_column>.alert-danger>p")).getText();
        String expectedTitleAlert = "There is 1 error";
        Assert.assertEquals(actualTitleAlert, expectedTitleAlert);
        String actualItemAlert = driver.findElement(By.cssSelector("#center_column>.alert-danger>ol>li")).getText();
        String expectedItemAlert = "Authentication failed.";
        Assert.assertEquals(actualItemAlert, expectedItemAlert);
    }
}
