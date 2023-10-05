package com.tech.selenium.stepdefinitions;

import com.tech.selenium.driverutil.DriverFactory;
import com.tech.selenium.pageobjects.GoogleSearchPage;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import org.junit.Assert;

import static com.tech.selenium.driverutil.DriverFactory._driver;

public class GoogleSteps implements En {
    GoogleSearchPage googleSearchPage;

    public GoogleSteps() {

        Before((Scenario scenario) -> {
            googleSearchPage = new GoogleSearchPage();
        });

        Given("^Chrome browser is used$", () -> {
            DriverFactory.getBrowser("CHROME");
        });

        Given("^Firefox browser is used$", () -> {
            DriverFactory.getBrowser("FIREFOX");
        });

        Given("^Opera browser is used$", () -> {
            DriverFactory.getBrowser("OPERA");
        });

        Given("^Edge browser is used$", () -> {
            DriverFactory.getBrowser("EDGE");
        });

        Given("^Internet Explorer browser is used$", () -> {
            DriverFactory.getBrowser("IE");
        });

        Given("^\"([^\"]*)\" browser is used$", (String browserName) -> {
            DriverFactory.getBrowser(browserName);
        });

        Given("^User is on Google search page$", () -> {
            googleSearchPage.openURL();
        });

        After((Scenario scenario) -> {
            _driver.quit();
        });
        When("^User searches \"([^\"]*)\" on Google page$", (String word) -> {
            googleSearchPage.searchFor(word);
        });
        Then("^verify search results appeared on the page$", () -> {
            Assert.assertTrue(googleSearchPage.searchResultsAppearOnChrome());
        });
        When("^click first real \\(non-Ad\\) result$", () -> {
            googleSearchPage.clickNonAdResult();
        });
        Then("^page was opened$", () -> {
            Assert.assertTrue(googleSearchPage.pageOpened());
        });
        And("^page contains \"([^\"]*)\"$", (String word) -> {
            Assert.assertTrue(googleSearchPage.searcWordOnPage(word));
        });
    }
}
