package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class ProductStore {
    public ProductStore(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//a[@id='itemc']")
    List<WebElement> allOptions;

    @FindBy(css = "#cartur")
    WebElement cartButton;

    public void LapTopSelect(WebDriver driver, String laptops) throws InterruptedException {

       for (WebElement laptopOption: allOptions){
           Thread.sleep(1000);
           if (BrowserUtils.getText(laptopOption).equals(laptops)){
               Thread.sleep(1000);
               laptopOption.click();
           }
       }
    }

    public void clickCartButton(){
        cartButton.click();
    }

}
