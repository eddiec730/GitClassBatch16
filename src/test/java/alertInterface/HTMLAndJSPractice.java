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

public class HTMLAndJSPractice {
    @Test
    public void practiceBoth() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement previewOnTheLeft = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        previewOnTheLeft.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement previewOnTheRight = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        previewOnTheRight.click();
        Thread.sleep(1000);
        WebElement message = driver.findElement(By.xpath("//div[@class='swal-modal']"));
        String actualMessage = BrowserUtils.getText(message);
        System.out.println(BrowserUtils.getText(message));
        String expectedMessage = "Something went wrong!";
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        WebElement OkButton = driver.findElement(By.xpath("//button[.='OK']"));
        OkButton.click();


    }
}

