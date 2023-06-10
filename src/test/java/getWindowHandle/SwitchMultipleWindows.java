package getWindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchMultipleWindows {
    @Test
    public void practiceMultipleWindows(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        String mainPage= driver.getWindowHandle();
        Set<String> allPages = driver.getWindowHandles();
        for(String id : allPages){
            if(!id.equals(mainPage)){
                driver.switchTo().window(id);
                break;
            }
        }
        BrowserUtils.switchByTitle(driver,"Contact");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        BrowserUtils.switchByTitle(driver,"Kickstart");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        BrowserUtils.switchByTitle(driver,"Courses");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    public void realTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");


                       /*
        1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
        2-Click open multiple tabs under Button 4
        3-the Basic Control and fill all the blanks
        4-Click Register button and validate the message "Registration is Successful"
        5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
        6- go to the alertsDemo page and click  the "Click Me" button under prompt box
        7-quit all the pages.
        8-Proud of yourself

        */
        WebElement button4= driver.findElement(By.cssSelector("#newTabsBtn"));
        button4.click();
        BrowserUtils.switchByTitle(driver,"Basic");
        WebElement firstName=driver.findElement(By.cssSelector("#firstName"));
        firstName.sendKeys("Edward");
        WebElement lastName=driver.findElement(By.cssSelector("#lastName"));
        lastName.sendKeys("Canga");
        WebElement gender=driver.findElement(By.cssSelector("#malerb"));
        gender.click();
        WebElement languages=driver.findElement(By.cssSelector("#englishchbx"));
        languages.click();
        WebElement email= driver.findElement(By.cssSelector("#email"));
        email.sendKeys("eddiec730@gmail.com");
        WebElement password=driver.findElement(By.cssSelector("#password"));
        password.sendKeys("1234");
        WebElement registerButton=driver.findElement(By.cssSelector("#registerbtn"));
        registerButton.click();
        Thread.sleep(1000);
        WebElement message = driver.findElement(By.cssSelector("#msg"));
        String actualMessage = BrowserUtils.getText(message);
        Assert.assertEquals(actualMessage, "Registration is Successful");
        BrowserUtils.switchByTitle(driver, "Window");
        WebElement header= driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        String actualHeader=BrowserUtils.getText(header);
        Assert.assertEquals(actualHeader, "Window Handles Practice");
        BrowserUtils.switchByTitle(driver, "AlertsDemo");
        WebElement promptButton = driver.findElement(By.cssSelector("#promptBox"));
        promptButton.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
