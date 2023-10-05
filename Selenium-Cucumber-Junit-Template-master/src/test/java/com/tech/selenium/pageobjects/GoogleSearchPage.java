package com.tech.selenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.tech.selenium.driverutil.DriverFactory._driver;

public class GoogleSearchPage {

    private final String searchBoxName ="q";
    private final String searchNullID="rso";
    private final String nonAdResultXpath="//*[@id=\"rso\"]/div[1]";
    private final String adResultXpath="(//*[@class=\"uEierd\"])[1]";

    public GoogleSearchPage() {
        PageFactory.initElements(_driver, this);
    }

    public void openURL(){
        try {
            _driver.get("https://www.google.com/");
        } catch (Exception e) {
            Assert.fail("\n FAIL: Test does not continue because of browser,internet based problem");
        }
    }

    public void searchFor(String _searchTerm) throws InterruptedException {
        try {
            _driver.findElement(By.name(searchBoxName)).sendKeys(_searchTerm +Keys.ENTER);
        } catch (Exception e) {
            Assert.fail("\n FAIL: Test does not continue because of browser,internet based problem");
        }
    }

    public boolean searchResultsAppearOnChrome() {
        try {
            return _driver.findElement(By.id(searchNullID)).isDisplayed();
        } catch (NoSuchElementException e) {
           return false;
        }
    }

    public void clickNonAdResult() {
        try {
            _driver.findElement(By.xpath(nonAdResultXpath)).click();
        } catch (Exception e) {
            Assert.fail("\n FAIL: Test does not continue");
        }
    }

    public boolean pageOpened(){
        String pageTitle = _driver.getTitle();
        return !pageTitle.isEmpty();
    }

    public boolean searcWordOnPage(String word){
        String pageSource = _driver.getPageSource();
        if(pageSource.contains(word))
            return true;
        else {
            Assert.fail("\n FAIL: Page does not contain initial search phrase");
            return false;
        }
    }
}
