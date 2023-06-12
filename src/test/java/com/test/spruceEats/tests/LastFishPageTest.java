package com.test.spruceEats.tests;

import com.test.spruceEats.pages.FishAndSeafoodPage;
import com.test.spruceEats.pages.LastFishPage;
import com.test.spruceEats.pages.SpruceHomePage;
import org.testng.annotations.Test;

public class LastFishPageTest extends SpruceEatsTestBase{
    @Test
    public void LastFishPageTestValidation() throws InterruptedException {
        SpruceHomePage spruceHomePage = new SpruceHomePage(driver);
        spruceHomePage.chooseRecipe(driver,"Fish & Seafood");
        FishAndSeafoodPage fishAndSeafoodPage = new FishAndSeafoodPage(driver);
        fishAndSeafoodPage.fishForDinnerInput(driver,"Fish for dinner");
        LastFishPage lastFishPage = new LastFishPage(driver);
        lastFishPage.selectTwoButtons(driver,"6-Ingredient Roasted Salmon Fillets");
    }
}
