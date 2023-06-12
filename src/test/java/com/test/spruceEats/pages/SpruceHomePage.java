package com.test.spruceEats.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class SpruceHomePage {
    public SpruceHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//span[.='Ingredients']")
    WebElement indgredients;

    @FindBy(xpath = "//li[@class='global-nav__list-item js-global-nav-item'][3]//li")
    List<WebElement> allOptions;

    public void chooseRecipe(WebDriver driver, String choice) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(indgredients).perform();

        for(int i = 0;i <allOptions.size();i++){
            if(BrowserUtils.getText(allOptions.get(i)).equals(choice.toUpperCase())){
                Thread.sleep(3000);
                actions.click(allOptions.get(i)).perform();

                break;
            }
        }
    }


}
