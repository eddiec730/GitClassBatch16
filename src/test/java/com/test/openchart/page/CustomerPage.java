package com.test.openchart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class CustomerPage {
    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addCustomer;

    @FindBy(css ="#input-firstname")
    WebElement firstName;

    @FindBy(css = "#input-lastname")
    WebElement lastName;

    @FindBy(css = "#input-email")
    WebElement email;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(css = "#input-confirm")
    WebElement confirmPassword;

    @FindBy(css = "#input-newsletter")
    WebElement newsLetterSlider;

    @FindBy(css="#input-safe")
    WebElement safeSlider;

    @FindBy(xpath = "//button[@aria-label='Save']")
    WebElement saveButton;

    @FindBy(css =".alert")
    WebElement alertMessage;

    public void addCustomer(){
        addCustomer.click();
    }

    public void provideCustomerInfo(WebDriver driver,String firstName,String lastName,String email,String password,String confirmPassword) throws InterruptedException {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        BrowserUtils.scrollWithJS(driver,newsLetterSlider);
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver,newsLetterSlider);
        BrowserUtils.clickWithJS(driver,safeSlider);
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver,saveButton);
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(alertMessage),"Warning: You do not have permission to modify customers!");

    }
}
