package selectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCar {
    @Test
    public void headerOfTheCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com");

            /*
        NOTE: Please use browser utils for the select classes if it is needed or getText.
        1-Navigate to the website
        2-Choose the "New" from the New/used option
        3-Choose "Lexus" for Make part
        4-Choose "RX-350"
        5-Validate the Price is selected "No max price"-->getFirstSelectedOption
        6-Choose the distance 40 mil
        7-Put your Zip code-->Before that Clear it.60056 element.clear()
        8-Click Search Button
        9-Validate the header "New Lexus RX 350 for sale"
        10-Click Sort by and choose the Lowest Price
        11-Validate the all titles has Lexus RX 350
     */

        WebElement newUsed = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowserUtils.selectBy(newUsed, "new", "value");
        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowserUtils.selectBy(make, "Lexus", "text");
        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowserUtils.selectBy(model, "lexus-rx_350", "value");
        WebElement priceDefault = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select carPriceDrop = new Select(priceDefault);
        String expectedDefaultPrice = "No max price";
        Assert.assertEquals(expectedDefaultPrice, BrowserUtils.getText(carPriceDrop.getFirstSelectedOption()));
        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowserUtils.selectBy(distance, "40", "value");
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60056");
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchButton.click();
        WebElement header = driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader, expectedHeader); //useful application
        WebElement sortByDropDown = driver.findElement(By.xpath("//select[@id='sort-dropdown']"));
        Thread.sleep(2000);
        BrowserUtils.selectBy(sortByDropDown, "Lowest price", "text");
        List<WebElement> carList = driver.findElements(By.xpath("//h2[@class='title']"));
        String allCars = "Lexus RX 350";
        for (WebElement carName : carList) {
            Assert.assertTrue(BrowserUtils.getText(carName).contains(allCars));
            System.out.println(BrowserUtils.getText(carName));
        }
        List<WebElement> allPrice = driver.findElements(By.cssSelector(".primary-price"));
        List<Integer> actualPrice = new ArrayList<>(); //Using integer to compare the numbers
        List<Integer> expectedPrice = new ArrayList<>(); // always sort the expected, never change the actual

        for (int i = 0; i < allPrice.size(); i++) {
            actualPrice.add(Integer.parseInt(BrowserUtils.getText(allPrice.get(i)).replace("$","").replace(",","")));
            expectedPrice.add(Integer.parseInt(BrowserUtils.getText(allPrice.get(i)).replace("$", "").replace(",", "")));


        }
        Collections.sort(expectedPrice);
        Thread.sleep(2000);
        Assert.assertEquals(actualPrice, expectedPrice);
        System.out.println(actualPrice); // In real life you wouldn't send the sout, this is just to show
        System.out.println(expectedPrice);

    }


}





