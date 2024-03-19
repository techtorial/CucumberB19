package com.qa.techtorialwork.stepdefinitions;

import com.qa.techtorialwork.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class LoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);
    @Given("User validates the title is {string}")
    public void user_validates_the_title_is(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle());
    }
    @Given("User validates log_in is visible")
    public void user_validates_log_in_is_visible() {
        Assert.assertTrue(loginPage.loginHeaderDisplayed());
    }
    @When("User provides {string} and {string} to the loginPage")
    public void user_provides_and_to_the_login_page(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("User validates the title {string} from MainPage")
    public void user_validates_the_title_from_main_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle());
    }

    @Then("User validates the {string} message and {string} color")
    public void user_validates_the_message_and_color(String expectedMessage, String expectedColor) {
        loginPage.validateMessageAndColor(expectedMessage,expectedColor);
    }

}
