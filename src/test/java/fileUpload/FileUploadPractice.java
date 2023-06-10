package fileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        //WebDriver driver=new Chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile= driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/edwardcanga/Desktop/usa.png");
        WebElement uploadButton= driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit();
        //uploadButton.click
        WebElement validateFileName= driver.findElement(By.cssSelector("#uploaded-files"));
        String actualName=BrowserUtils.getText(validateFileName);
        String expectedName="usa.png";
        Assert.assertEquals(actualName,expectedName);
    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/upload/");
        WebElement chooseFile= driver.findElement(By.cssSelector("#uploadfile_0"));
        chooseFile.sendKeys("/Users/edwardcanga/Desktop/usa.png");
        WebElement text= driver.findElement(By.xpath("//b[contains(text(),'Select file')]"));
        String actualText=BrowserUtils.getText(text);
        String expectedText="Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualText,expectedText);
        WebElement termsOf= driver.findElement(By.cssSelector("#terms"));
        if(termsOf.isDisplayed()&&!termsOf.isSelected()&& termsOf.isEnabled()){
            termsOf.click();
        }
        WebElement uploadButton= driver.findElement(By.xpath("//button[@id='submitbutton']"));
        uploadButton.click();
        Thread.sleep(2000);
        WebElement message= driver.findElement(By.tagName("//h3"));
        String actualMessage=BrowserUtils.getText(message);
        String expectedMessage="1 file\n" +
                "has been successfully uploaded.";
       Assert.assertEquals(actualMessage,expectedMessage);

    }
}
