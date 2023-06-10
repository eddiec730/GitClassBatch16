package softAssertClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {
    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");
        WebElement clickMe1 = driver.findElement(By.cssSelector("#alertBox"));
        clickMe1.click();
        Alert alert=driver.switchTo().alert();
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(alert.getText().trim(),"I am an alert box!");
        alert.accept();

        WebElement message= driver.findElement(By.xpath("//div[@id='output']"));
        Assert.assertEquals(BrowserUtils.getText(message),"You selected alert popup");

        WebElement clickMe2= driver.findElement(By.cssSelector("#confirmBox"));
        clickMe2.click();

        Alert alert1=driver.switchTo().alert();
        alert1.dismiss();

        softAssert.assertEquals(BrowserUtils.getText(message),"You pressed Cancel in confirmation popup"); // same message from output

        WebElement clickMe3= driver.findElement(By.cssSelector("#promptBox"));
        clickMe3.click();
        Alert alert2=driver.switchTo().alert();
        alert2.sendKeys("Edward");
        alert2.accept();
        Assert.assertEquals(BrowserUtils.getText(message),"You entered text Edward in prompt popup");
        softAssert.assertAll();

        //Don't create a ticket for the developer because of the typo, just call him and notify of the bug (propmt)

    }
}
