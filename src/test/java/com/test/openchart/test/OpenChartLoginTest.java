package com.test.openchart.test;

import com.test.openchart.page.OpenChartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends OpenChartTestBase {
    @Test
    public void happyPathLogin() throws InterruptedException {
        OpenChartLoginPage openChartLoginPage = new OpenChartLoginPage(driver);
        openChartLoginPage.loginFunctionality("demo","demo");
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");

    }
    @Test
    public void validateNegativeLogin(){
        OpenChartLoginPage openChartLoginPage=new OpenChartLoginPage(driver);
        openChartLoginPage.loginFunctionality("wrongUserName","wrongPassword");
        Assert.assertEquals(openChartLoginPage.errorMessage(),"No match for Username and/or Password.");
    }

}
