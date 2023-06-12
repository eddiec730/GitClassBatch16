package com.test.spruceEats.tests;

import com.test.spruceEats.pages.FishAndSeafoodPage;
import com.test.spruceEats.pages.SpruceHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

public class FishSeaFoodTest extends SpruceEatsTestBase{
@Test
    public void SearchBarAndButtonFunctionality() throws InterruptedException {
    SpruceHomePage spruceHomePage = new SpruceHomePage(driver);
    spruceHomePage.chooseRecipe(driver,"Fish & Seafood");
    FishAndSeafoodPage fishAndSeafoodPage = new FishAndSeafoodPage(driver);
    fishAndSeafoodPage.fishForDinnerInput(driver,"Fish for dinner");
}
}


