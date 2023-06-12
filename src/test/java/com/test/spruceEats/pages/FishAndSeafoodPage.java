package com.test.spruceEats.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class FishAndSeafoodPage {
    public FishAndSeafoodPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#search-form-input")
    WebElement searchBar;

    @FindBy(css = "#button_1-0")
    WebElement searchButton;

    public void fishForDinnerInput(WebDriver driver, String name) throws InterruptedException {
        BrowserUtils.scrollWithJS(driver,searchBar);
        Thread.sleep(3000);
        searchBar.sendKeys(name);
        Thread.sleep(1000);
        searchButton.click();



    }
}
