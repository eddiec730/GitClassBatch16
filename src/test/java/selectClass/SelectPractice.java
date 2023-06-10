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

import java.time.Duration;
import java.util.List;

public class SelectPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/edwardcanga/Desktop/Techtorial.html");


        //TASK 1= Validate the default option is selected UNITED STATES
        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        Select choice = new Select(country);
        String actualDefaultCountry = choice.getFirstSelectedOption().getText().trim();
        String expectedDefaultCountry ="UNITED STATES";
        Assert.assertEquals(actualDefaultCountry,expectedDefaultCountry);
        Thread.sleep(2000);

        //TASK 2: Print out all the options
        List<WebElement> allCountries = choice.getOptions();
        int counter=0;
        for(WebElement cntry:allCountries){
            System.out.println(cntry.getText().trim());
            counter++;
        }
        System.out.println(counter);
        //TASK: Choose your own country with Visible TextMethod
        //:Choose Favorite country with Value
        //:Choose Travel Country with index
        //NOTE:Put Thread.sleep() between them to see how they are changing

       choice.selectByVisibleText("TURKEY ");
       Thread.sleep(2000);
       choice.selectByValue("123");
       Thread.sleep(2000);
       choice.selectByIndex(9);
    }
}
