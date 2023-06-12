package com.test.spruceEats.tests;

import com.test.spruceEats.pages.SpruceHomePage;
import org.testng.annotations.Test;

public class SpruceHomeTest extends SpruceEatsTestBase {


    @Test
    public void choosingRecipeFunctionality() throws InterruptedException {
        SpruceHomePage spruceHomePage = new SpruceHomePage(driver);
        spruceHomePage.chooseRecipe(driver,"Fish & Seafood");
    }
}
