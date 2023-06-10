package atHomePractice;

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
import java.util.Arrays;
import java.util.List;

public class AirlineTask {
    @Test
    public void ValidateOrderMessage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
          /*
        1-Navigate to the website
        2-Select one way trip button
        3-Choose 4 passangers(1 wife-1 husband-2 kids)
        4-Validate the depart from is default "Acapulco"
        5-Choose the depart from is Paris
        6-Choose the date August 15th
        7-Choose the arrive in is San Francisco
        8-Choose the date December 15th
        10-Click first class option.
        11-Validate All the options from Airline
        12-Choose the Unified option from airline list
        13-Click Continue
        14-Validate the message at the top.There is a bug here/
        "After flight finder - No Seats Available"

        NOTE:Your test should fail and say available is not matching with Available.
        NOTE2:You can use any select method value,visibleText
         */

        WebElement oneWay=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();
        Thread.sleep(2000);
        WebElement passengersDrop= driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengersDrop,"4","value");
        WebElement departDefaul= driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select choiceDeparting= new Select(departDefaul);
        String actualDeparting=choiceDeparting.getFirstSelectedOption().getText().trim();
        String expectedDeparting="Acapulco";
        Assert.assertEquals(actualDeparting,expectedDeparting);
        WebElement departFrom=driver.findElement(By.xpath("//select[@name='fromPort']"));
        BrowserUtils.selectBy(departFrom,"Paris","value");
        WebElement departDate=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(departDate,"8","value");
        WebElement departDateDay=driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(departDateDay,"15","value");
        WebElement arriveIn= driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arriveIn,"Paris","value");
        WebElement arriveInMonth= driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(arriveInMonth,"12","value");
        WebElement arriveDay= driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(arriveDay,"15","value");
        WebElement firstClassButton= driver.findElement(By.xpath("//input[@name='servClass']"));
        firstClassButton.click();
        Thread.sleep(1000);
        WebElement AirLine=driver.findElement(By.xpath("//select[@name='airline']"));
        Select aline= new Select(AirLine);
        List<WebElement> allAlineOptions= aline.getOptions();
        List<String> expectedAlineOptions= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for(int i = 0; i< allAlineOptions.size();i++){
            Assert.assertEquals(allAlineOptions.get(i).getText().trim(),expectedAlineOptions.get(i).trim());
        }

        WebElement continueButton= driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        Thread.sleep(1000);

        WebElement header=driver.findElement(By.xpath("//font[@size='4']"));
        String actualHeader= header.getText().trim();
        String expectedHeader="After flight finder - No Seats Available";
        Assert.assertEquals(actualHeader,expectedHeader);


    }
}
