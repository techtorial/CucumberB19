package com.qa.techtorialwork.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class TechtorialHook {

    public WebDriver driver;

    @Before
    public void setup(){
    driver= DriverHelper.getDriver();
    driver.get(ConfigReader.readProperty("workurl"));
    }

    @After
    public void tearDown(){
//        driver.quit();
    }
}
