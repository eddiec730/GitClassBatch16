package com.test.openchart.test;

import com.test.openchart.page.CustomerPage;
import com.test.openchart.page.MainPage;
import com.test.openchart.page.OpenChartLoginPage;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

public class CustomerTest extends OpenChartTestBase {
    @Test
    public void addFunctionality() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage = new OpenChartLoginPage(driver);
        openChartLoginPage.loginFunctionality("demo","demo");
        CustomerPage customerPage = new CustomerPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.getCustomerPage();
        customerPage.addCustomer();
        customerPage.provideCustomerInfo(driver,"Edward","Canga","eddiec@gmail.com",
                "1234","1234");

    }

}
