package com.test.spruceEats.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.DriverHelper;

public class SpruceEatsTestBase {
    public WebDriver driver;

    /*
    1-Navigate to the website "https://www.thespruceeats.com/"
    2-Under Ingredients tab --> choose Fish&SeaFood option
    3-ScrollDown to the search bar (Use JS Method)
    4-Send the data: "Fish for dinner"
    5-On the left side choose 4 star up option
    6-From popular: Choose the Editor's choice option
    7-Validate the name of product is "6-Ingredient Roasted Salmon Fillets"
    8-Quit or close your driver

PURPOSE: *Apply Action class method
         *Apply How to find the unique element for real website
         *Apply JS scroll Method
         *Apply TestNG Assertion(validation)
         *Getting used to UI real interview question types
 */
    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.get("https://www.thespruceeats.com/");

    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            BrowserUtils.getScreenShot(driver, "SprucePictures");
        }
        driver.quit();
    }
}
