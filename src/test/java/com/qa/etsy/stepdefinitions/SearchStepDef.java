package com.qa.etsy.stepdefinitions;

import com.qa.etsy.pages.EtsyMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepDef {
    WebDriver driver= DriverHelper.getDriver();

    EtsyMainPage etsyMainPage=new EtsyMainPage(driver);
    @Given("User navigates to the {string}")
    public void user_navigates_to_the(String url) {
       driver.get(url);
    }
    @When("User search {string} from searchBar")
    public void user_search_from_search_bar(String searchItem) {
        etsyMainPage.searchItem(searchItem);
    }
    @Then("User validates {string} as title")
    public void user_validates_as_title(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
        driver.quit();
    }
}
