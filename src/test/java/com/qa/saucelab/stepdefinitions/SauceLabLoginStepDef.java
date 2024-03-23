package com.qa.saucelab.stepdefinitions;

import com.qa.saucelab.pages.SauceLabLoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class SauceLabLoginStepDef {
    WebDriver driver = DriverHelper.getDriver();
    SauceLabLoginPage sauceLabLoginPage = new SauceLabLoginPage(driver);

    @When("User provides {string} and {string} for SauceLab")
    public void user_provides_and_for_sauce_lab(String username, String password) throws InterruptedException {
        sauceLabLoginPage.login(username, password);
    }

    @Then("User validates {string} from SauceLab")
    public void user_validates_from_sauce_lab(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
        driver.quit();
    }

    @Then("User validates the {string} from LoginPage")
    public void user_validates_the_from_login_page(String expectedMessage) {
        Assert.assertEquals(expectedMessage,sauceLabLoginPage.errorMessage());
    }

    @When("User provides username and password for SauceLab")
    public void user_provides_username_and_password_for_sauce_lab(DataTable dataTable) throws InterruptedException {
      Map<String,String> loginData=dataTable.asMap();
        System.out.println(loginData);
        sauceLabLoginPage.login(loginData.get("username"),loginData.get("password"));
    }
    @Then("User validates title from SauceLab")
    public void user_validates_title_from_sauce_lab(DataTable dataTable) {
        Map<String,String> expectedTitle=dataTable.asMap();
        Assert.assertEquals(expectedTitle.get("title"),driver.getTitle().trim());
    }
    @When("User provides username and password for SauceLab as List")
    public void user_provides_username_and_password_for_sauce_lab_as_list(DataTable dataTable) throws InterruptedException {
      List<String> loginData=dataTable.asList();
        System.out.println(loginData.get(0));
        System.out.println(loginData.get(1));
        sauceLabLoginPage.login(loginData.get(0),loginData.get(1));
    }
    @Then("User validates title from SauceLab as List")
    public void user_validates_title_from_sauce_lab_as_list(DataTable dataTable) {
        List<String> expectedTitle=dataTable.asList();
        Assert.assertEquals(expectedTitle.get(0),driver.getTitle().trim());
    }
}
