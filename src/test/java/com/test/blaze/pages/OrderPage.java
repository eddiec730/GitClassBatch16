package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#name")
    WebElement name;

    @FindBy(css="#country")
    WebElement county;

    @FindBy(css="#city")
    WebElement city;

    @FindBy(css="#card")
    WebElement card;

    @FindBy(css="#month")
    WebElement month;

    @FindBy(css="#year")
    WebElement year;

    @FindBy(xpath = "//button[contains(text(),'Purchase')]")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(),'your purchase')]")
    WebElement message;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;


    public void orderFunctionality(String name, String country, String city, String card,
                                   String month,String year,String expectedMessage) throws InterruptedException {
        Thread.sleep(2000);
        this.name.sendKeys(name);
        this.county.sendKeys(country);
        this.city.sendKeys(city);
        this.card.sendKeys(card);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        purchaseButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(message),expectedMessage);
        okButton.click();
        Thread.sleep(2000);
    }

}
