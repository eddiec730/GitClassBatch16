package com.test.openchart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OpenChartLoginPage {
    public OpenChartLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#input-username")
    WebElement userName;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement loginButton;

    @FindBy(css = "#alert")
    WebElement errorMessage;

    public void loginFunctionality(String username,String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
    public String errorMessage(){
        return BrowserUtils.getText(errorMessage);
    }
}
