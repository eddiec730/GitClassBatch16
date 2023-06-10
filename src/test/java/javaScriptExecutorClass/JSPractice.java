package javaScriptExecutorClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class JSPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/radio-button");

        WebElement radio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        radio.click();

        WebElement yes = driver.findElement(By.xpath("//span[@class='text-success']"));
        Assert.assertEquals(yes.getText(),"Yes");
        Thread.sleep(1000);

        WebElement impressive = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressive.click();
        Thread.sleep(1000);

        WebElement text = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        Assert.assertEquals(text.getText(),"Impressive");
        Thread.sleep(1000);

    }
    @Test
    public void practice2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        WebElement copyright= driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
        BrowserUtils.scrollWithJS(driver,copyright);
        String actualText=BrowserUtils.getText(copyright);
        String expectedText="Copyright © 2023";
        Assert.assertEquals(actualText,expectedText);
        WebElement applyNow= driver.findElement(By.xpath("//span[contains(text(),'Apply')]"));
        //rewatch
        Thread.sleep(2000);
        BrowserUtils.scrollWithJS(driver,applyNow);
        Thread.sleep(2000);
        String actualTitle=BrowserUtils.getTitleJS(driver);
        String expectedTitle="Apply Now";
        Assert.assertEquals(actualTitle,expectedTitle);
        Thread.sleep(1000);
        List<WebElement> allInfo=driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> expectedInfo= Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

        for(int i = 0; i<allInfo.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInfo.get(i)),expectedInfo.get(i));
        }

    }
}
