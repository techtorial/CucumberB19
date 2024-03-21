package com.qa.saucelab.stepdefinitions;

import com.qa.saucelab.pages.SauceLabLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SauceLabLoginStepDef {
   WebDriver driver= DriverHelper.getDriver();
   SauceLabLoginPage sauceLabLoginPage=new SauceLabLoginPage(driver);
    @When("User provides {string} and {string} for SauceLab")
    public void user_provides_and_for_sauce_lab(String username, String password) throws InterruptedException {
    sauceLabLoginPage.login(username,password);
    }
    @Then("User validates {string} from SauceLab")
    public void user_validates_from_sauce_lab(String expectedTitle) {
     Assert.assertEquals(expectedTitle,driver.getTitle().trim());
     driver.quit();
    }
}
