package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BlazeTestBase {
    @Test
    public void validateOrderFunctionality() throws InterruptedException {
        ProductStore productStore = new ProductStore(driver);
        LaptopPage laptopPage = new LaptopPage(driver);
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        productStore.LapTopSelect(driver,"Laptops");
        laptopPage.chooseLaptopBrand(driver,"MacBook Pro");
        macBookProPage.clickAddToCartButton(driver,"Product added");
        CartPage cartPage = new CartPage(driver);
        cartPage.clickPlaceOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.orderFunctionality("Ahmet","Turkey","Ankara","123123",
                "05","2023","Thank you for your purchase!");
        Assert.assertEquals(driver.getCurrentUrl().trim(),"https://www.demoblaze.com/index.html");



    }

}
