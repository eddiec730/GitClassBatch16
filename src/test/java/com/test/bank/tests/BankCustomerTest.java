package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import com.test.bank.pages.CustomerLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankCustomerTest extends BankTestBase {

    @Test
    public void validateCustomerLoginTransactions() throws InterruptedException {
        BankLoginPage loginPage = new BankLoginPage(driver);
        loginPage.clickManagerButton();
        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.addCustomerFunctionality(driver, "Ahmet", "Baldir", "60123",
                "Customer added successfully with customer id");
        bankManagerPage.OpenAccountFunctionality(driver, "Ahmet Baldir", "Dollar",
                "Account created successfully with account Number");
        bankManagerPage.customerFunctionality("Ahmet", "Baldir", "60123");
        bankManagerPage.clickHomeButton();
        loginPage.clickCustomerLogin();
        CustomerLoginPage customerLoginPage=new CustomerLoginPage(driver);
        customerLoginPage.loginFunctionality("Ahmet Baldir","Welcome Ahmet Baldir !!");
        customerLoginPage.depositFunctionality("500","Deposit Successful");
        customerLoginPage.withDrawFunctionality("300","Transaction successful");
        customerLoginPage.transactionFunctionality();



    }

}


