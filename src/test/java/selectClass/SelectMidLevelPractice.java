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
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {
    @Test
    public void validateOrderMessage() throws InterruptedException {
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

        WebElement oneWayTrip=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayTrip.click();
        Thread.sleep(2000);
        WebElement passengerNumber=driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passengerScroll= new Select(passengerNumber);
        passengerScroll.selectByIndex(3);
        WebElement city=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingChoice= new Select(city);
        String actualDepartingFromCity= departingChoice.getFirstSelectedOption().getText().trim();
        String expectedDepartingCity="Acapulco";
        Assert.assertEquals(actualDepartingFromCity,expectedDepartingCity);
        Thread.sleep(2000);
        departingChoice.selectByValue("Paris");
        Thread.sleep(1000);
        WebElement onDate=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select month=new Select(onDate);
        month.selectByValue("8");
        WebElement onDateDay=driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select day=new Select(onDateDay);
        day.selectByVisibleText("15");
        Thread.sleep(1000);
        WebElement arriving=driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivingCity=new Select(arriving);
        arrivingCity.selectByValue("San Francisco");
        Thread.sleep(2000);
        WebElement onDateMonth2=driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select arriveMonth=new Select(onDateMonth2);
        arriveMonth.selectByValue("12");
        Thread.sleep(2000);
        WebElement onDateDay2=driver.findElement(By.xpath("//select[@name='toDay']"));
        Select arriveDay=new Select(onDateDay2);
        arriveDay.selectByValue("15");
        Thread.sleep(2000);
        WebElement firstClassBox= driver.findElement(By.xpath("//input[@value='First']"));
        firstClassBox.click();
        Thread.sleep(2000);

        WebElement airline=driver.findElement(By.xpath("//select[@name='airline']"));
        Select aline=new Select(airline);
        List<WebElement> allOptionsFromAline=aline.getOptions();//4 - available options
        List<String> expectedOptionsFromAline= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        //Arrays.asLlist will allow you to copy and paste the different options from the select scroll down list without
        //without having to loop like you would with ArrayList

        for(int i=0; i <allOptionsFromAline.size();i++){
            Assert.assertEquals(allOptionsFromAline.get(i).getText().trim(),expectedOptionsFromAline.get(i));
        }

        WebElement continueButton=driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        Thread.sleep(2000);

        WebElement confirmMessage= driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage=confirmMessage.getText().trim();
        String expectedMessage="After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage,expectedMessage); // it should fail because of the spelling mistake


    }
    @Test
    public void validateOrderMessageShortcut() throws InterruptedException {
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

        WebElement oneWayTrip = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWayTrip.click();
        Thread.sleep(2000);
        WebElement passengerNumber = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengerNumber, "4", "value");

        WebElement city = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingChoice = new Select(city);
//        String actualDepartingFromCity= departingChoice.getFirstSelectedOption().getText().trim();
//        String expectedDepartingCity="Acapulco";
//        Assert.assertEquals(actualDepartingFromCity,expectedDepartingCity);
        Thread.sleep(2000);
        departingChoice.selectByValue("Paris");
        BrowserUtils.selectBy(city, "Paris", "text");
        Thread.sleep(1000);
        WebElement onDate = driver.findElement(By.xpath("//select[@name='fromMonth']"));
//        Select month=new Select(onDate);
//        month.selectByValue("8");
        BrowserUtils.selectBy(onDate, "8", "value");
        WebElement onDateDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
//        Select day=new Select(onDateDay);
//        day.selectByVisibleText("15");
        BrowserUtils.selectBy(onDateDay, "15", "value");
        Thread.sleep(1000);
        WebElement arriving = driver.findElement(By.xpath("//select[@name='toPort']"));
//        Select arrivingCity=new Select(arriving);
//        arrivingCity.selectByValue("San Francisco");
        BrowserUtils.selectBy(arriving, "San Francisco", "text");
        Thread.sleep(2000);
        WebElement onDateMonth2 = driver.findElement(By.xpath("//select[@name='toMonth']"));
//        Select arriveMonth=new Select(onDateMonth2);
//        arriveMonth.selectByValue("12");
        BrowserUtils.selectBy(onDateMonth2, "12", "value");
        Thread.sleep(2000);
        WebElement onDateDay2 = driver.findElement(By.xpath("//select[@name='toDay']"));
//        Select arriveDay=new Select(onDateDay2);
//        arriveDay.selectByValue("15");
        BrowserUtils.selectBy(onDateDay2, "15", "value");
        Thread.sleep(2000);
        WebElement firstClassBox = driver.findElement(By.xpath("//input[@value='First']"));
        firstClassBox.click();
        Thread.sleep(2000);

        WebElement airline = driver.findElement(By.xpath("//select[@name='airline']"));
        Select aline = new Select(airline);
        List<WebElement> allOptionsFromAline = aline.getOptions(); //4
        List<String> expectedOptionsFromAline = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i = 0; i < allOptionsFromAline.size(); i++) {
            Assert.assertEquals(allOptionsFromAline.get(i).getText().trim(), expectedOptionsFromAline.get(i));
        }

        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();
        Thread.sleep(2000);

        WebElement confirmMessage = driver.findElement(By.xpath("//font[@size='4']"));
        String actualMessage = confirmMessage.getText().trim();
        String expectedMessage = "After flight finder - No Seats Available";
        Assert.assertEquals(actualMessage, expectedMessage); // it should fail because of the spelling mistake
    }
}
