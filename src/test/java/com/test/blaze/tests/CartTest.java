package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CartTest extends BlazeTestBase {
    @Test
    public void validateCartItem() throws InterruptedException {
        ProductStore productStore = new ProductStore(driver);
        LaptopPage laptopPage = new LaptopPage(driver);
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        productStore.LapTopSelect(driver,"Laptops");
        laptopPage.chooseLaptopBrand(driver,"MacBook Pro");
        CartPage cartPage = new CartPage(driver);
        macBookProPage.clickAddToCartButton(driver,"Product added");
        cartPage.getInfoFromCart("MacBook Pro","1100");
        productStore.clickCartButton();




    }

}
