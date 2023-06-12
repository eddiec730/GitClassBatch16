package com.test.spruceEats.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class LastFishPage {
    public LastFishPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#starRating_score_4Star")
    WebElement fourStarRating;

    @FindBy(css = "#pop_search_editor")
    WebElement editorsChoice;

    @FindBy(xpath = "//span[.='6-Ingredient Roasted Salmon Fillets']")
    WebElement salmonRecipe;

    public void selectTwoButtons(WebDriver driver,String expectedName) throws InterruptedException {
        BrowserUtils.clickWithJS(driver, fourStarRating);
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver,editorsChoice);
        Thread.sleep(2000);

        Assert.assertEquals(BrowserUtils.getText(salmonRecipe),expectedName);
    }

}

