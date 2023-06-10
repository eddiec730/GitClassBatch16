package atHomePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Blank {
    @Test
    public void blank(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.atptour.com/en/news");

        WebElement scoreButton= driver.findElement(By.xpath("//li[@id='railScoresTab']"));
        String actualBackGroundColor=scoreButton.getCssValue("background-color");
        String expectedBackGroundColor="rgba(248, 248, 248, 1)";
        Assert.assertEquals(actualBackGroundColor,expectedBackGroundColor);
    }
}
