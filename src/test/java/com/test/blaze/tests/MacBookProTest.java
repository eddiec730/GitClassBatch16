package com.test.blaze.tests;

import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import com.test.blaze.pages.ProductStore;
import org.testng.annotations.Test;

public class MacBookProTest extends BlazeTestBase{
        /*
    1-Navigate to the website "https://www.demoblaze.com/#"
    2-Click the Laptops by using the logic that if the element text is Laptops then click it.(loop)
    3-Click MacBook Pro from the list with Loop(LaptopPage)
    4-Validate the header="MacBook Pro"(MacBook Pro Page)
    5-Validate the price=$1100 *includes tax(MacBook Pro Page)
    6-Validate the product Descr="Product description(MacBook Pro Page)
Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and
15-inch model with the Touch Bar, a thin, multi-touchstrip display that sits above the MacBook Pro's keyboard."
    7-Click the Add to card Button and validate the alert text="Product added" then click "OK" button(MacBook Pro Page)
     */

    @Test
    public void validateMacBookProInfo() throws InterruptedException {
        ProductStore productStore = new ProductStore(driver);
        LaptopPage laptopPage = new LaptopPage(driver);
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        productStore.LapTopSelect(driver,"Laptops");
        laptopPage.chooseLaptopBrand(driver,"MacBook Pro");
        macBookProPage.MacBookProInformation("MacBook Pro","$1100 *includes tax","Product description\n" +
                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        macBookProPage.clickAddToCartButton(driver,"Product added");

    }



}
