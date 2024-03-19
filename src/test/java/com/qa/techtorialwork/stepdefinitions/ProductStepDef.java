package com.qa.techtorialwork.stepdefinitions;

import com.qa.techtorialwork.pages.LoginPage;
import com.qa.techtorialwork.pages.MainPage;
import com.qa.techtorialwork.pages.ProductPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class ProductStepDef {
    WebDriver driver= DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);
    MainPage mainPage=new MainPage(driver);
    ProductPage productPage=new ProductPage(driver);
    @Given("User provides username and password to the loginPage")
    public void user_provides_username_and_password_to_the_login_page() {
    loginPage.login(ConfigReader.readProperty("qa_username"),ConfigReader.readProperty("qa_password"));
    }
    @When("User clicks Products Button and addProductButton from Products Page")
    public void user_clicks_products_button_and_add_product_button_from_products_page() {
    mainPage.clickProductButton();
    productPage.clickAddProductButton();
    }
    @When("User provides {string} and {string} to the product details")
    public void user_provides_and_to_the_product_details(String productName, String productPrice) throws InterruptedException {
    productPage.productNameAndPrice(productName,productPrice);
    }
    @When("User selects {string},{string} and {string} from drop-downs")
    public void user_selects_and_from_drop_downs(String category, String subCategory, String tax) {
    productPage.provideDropDownInformation(category,subCategory,tax);
    }
    @When("User clicks purchase check box,add {string} into the description and save button")
    public void user_clicks_purchase_check_box_add_into_the_description_and_save_button(String description) throws InterruptedException {
    productPage.purchaseConfirmation(description);
    }
    @Then("User validates product details {string},{string},{string} from table")
    public void user_validates_product_details_from_table(String string, String string2, String string3) {

    }

}
