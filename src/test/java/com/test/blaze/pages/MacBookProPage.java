package com.test.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MacBookProPage {

    public MacBookProPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(tagName = "h2")
    WebElement header;

    @FindBy(xpath = "//h3")
    WebElement price;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement description;

    @FindBy(linkText = "Add to cart")
    WebElement addToCartButton;


    public void MacBookProInformation(String expectedHeader, String expectedPrice, String expectedDescripton) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        Assert.assertEquals(BrowserUtils.getText(price), expectedPrice);
        Assert.assertEquals(BrowserUtils.getText(description), expectedDescripton);
        Thread.sleep(1000);
    }

    public void clickAddToCartButton(WebDriver driver, String alertMessage) throws InterruptedException {
        addToCartButton.click();

        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        Assert.assertEquals(alert.getText(), alertMessage);
        Thread.sleep(1000);
        alert.accept();
    }
}

