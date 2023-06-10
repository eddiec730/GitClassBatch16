package alertInterface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void AlertAcceptAndGetText(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert= driver.findElement(By.xpath("/button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();
        Alert alert=driver.switchTo().alert();
        String actualText= alert.getText().trim();//will get the text from pop-up that i cannot inspect
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement message= driver.findElement(By.cssSelector("#result"));
        String actualMessage= BrowserUtils.getText(message);
        String expectedMessage="You successfully clicked an alert";
        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void AlertDismiss() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm= driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsConfirm.click();
        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        alert.dismiss();
        WebElement message=driver.findElement(By.xpath("//p[contains(@id,'result')]"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="You clicked: Cancel";
        Assert.assertEquals(actualMessage,expectedMessage);

    }
    @Test
    public void AlertSendKeys() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPrompt= driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Homework is Important");
        alert.accept();
        WebElement message=driver.findElement(By.cssSelector("#result"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="You entered: Homework is Important";
        Assert.assertEquals(actualMessage,expectedMessage);

    }
}
