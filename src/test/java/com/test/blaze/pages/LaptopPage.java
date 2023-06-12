package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopPage {

    public LaptopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h4[@class='card-title']//a")
    List<WebElement> allLaptops;

    public void chooseLaptopBrand(WebDriver driver, String brand) throws InterruptedException {

      for(WebElement laptop:allLaptops){

          Thread.sleep(1000);

          if(BrowserUtils.getText(laptop).equals(brand)){

              BrowserUtils.scrollWithJS(driver,laptop);
              BrowserUtils.clickWithJS(driver,laptop);
              break;
          }
      }
    }
}
