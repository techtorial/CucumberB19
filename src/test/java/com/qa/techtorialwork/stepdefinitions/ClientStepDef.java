package com.qa.techtorialwork.stepdefinitions;

import com.qa.techtorialwork.pages.ClientPage;
import com.qa.techtorialwork.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class ClientStepDef {
    WebDriver driver= DriverHelper.getDriver();
    MainPage mainPage=new MainPage(driver);
    ClientPage clientPage=new ClientPage(driver);
    @When("User clicks Clients button")
    public void user_clicks_clients_button() {
    mainPage.clickClientsButton();
    }
    @When("User clicks add client and provides account information {string},{string},{string}")
    public void user_clicks_add_client_and_provides_account_information(String name, String country, String mobile) throws InterruptedException {
    clientPage.clientInformation(name,country,mobile);
    }
    @When("User provides company information {string},{string},{string}")
    public void user_provides_company_information(String companyName, String companyWebsite, String companyPhone) throws InterruptedException {
    clientPage.companyInformation(companyName,companyWebsite,companyPhone);
    }
    @When("User provides address information {string},{string}")
    public void user_provides_address_information(String address, String shippingAddress) throws InterruptedException {
    clientPage.addressInformation(address,shippingAddress);
    }
    @Then("User clicks save button and validates {string},{string}")
    public void user_clicks_save_button_and_validates(String name, String companyName) throws InterruptedException {
    clientPage.saveAndValidate(name,companyName);
    }
}
