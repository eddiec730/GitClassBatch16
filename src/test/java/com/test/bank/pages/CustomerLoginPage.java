package com.test.bank.pages;

import org.apache.commons.io.input.BrokenInputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class CustomerLoginPage {

    public CustomerLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#userSelect")
    WebElement yourName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement header;

    @FindBy(tagName = "input")
    WebElement amount;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement submitDepositButton;

    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement successMessage;

    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]")
    WebElement withdrawalButton;

    @FindBy(xpath = "//input")
    WebElement withdrawalAmount;

    @FindBy(xpath = "//button[.='Withdraw']")
    WebElement finalWithdrawButton;

    @FindBy(xpath = "//div[@ng-hide='noAccount']//strong[2]")
    WebElement balance;

    @FindBy(xpath = "//button[contains(text(),'Trans')]")
    WebElement transactionButton;

    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement depositCredit;

    @FindBy(xpath = "//tr[@id='anchor1']//td[2]")
    WebElement withdrawDebit;

    @FindBy(xpath = "//button[.='Back']")
    WebElement backButton;


    public void loginFunctionality(String customerName,String expectedMessage) throws InterruptedException {
        BrowserUtils.selectBy(yourName,customerName,"text");
        Thread.sleep(2000);
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(header),expectedMessage);


    }
    public void depositFunctionality(String depositAmount,String expectedMessage) throws InterruptedException {
        depositButton.click();
        Thread.sleep(500);
        amount.sendKeys(depositAmount);
        submitDepositButton.submit();
        Assert.assertEquals(BrowserUtils.getText(successMessage),expectedMessage);

    }
    public void withDrawFunctionality(String withDrawlAmount,String expectedWithdrawMessage) throws InterruptedException {
        withdrawalButton.click();
        Thread.sleep(4000);
        this.withdrawalAmount.sendKeys(withDrawlAmount);
        finalWithdrawButton.click();
        Assert.assertEquals(BrowserUtils.getText(successMessage),expectedWithdrawMessage);

    }
    public void transactionFunctionality() throws InterruptedException {
        int actualBalance=Integer.parseInt(BrowserUtils.getText(balance));//200
        transactionButton.click();
        Thread.sleep(2000);
        backButton.click();
        Thread.sleep(3000);
        transactionButton.click();
        Thread.sleep(2000);
        int expectedBalance=(Integer.parseInt(BrowserUtils.getText(depositCredit))-
                Integer.parseInt(BrowserUtils.getText(withdrawDebit)));
        Assert.assertEquals(actualBalance,expectedBalance);
    }
}
