package framesAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.nio.file.WatchEvent;
import java.time.Duration;
import java.util.List;

public class FramePractice {
    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement header = driver.findElement(By.xpath("//h3"));
        System.out.println(BrowserUtils.getText(header));
        driver.switchTo().frame("mce_0_ifr");
        WebElement phraseBox = driver.findElement(By.cssSelector("#tinymce"));
        phraseBox.clear();
        phraseBox.sendKeys("I love Selenium");
        driver.switchTo().parentFrame();
        header = driver.findElement(By.xpath("//h3"));
        System.out.println(BrowserUtils.getText(header));

    }

    @Test
    public void Practice1() throws InterruptedException {
        /*
        TASK 1:
        1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
        2-Click pavilion (new tab will be opened, consider switch window)
        3-Choose "Selenium-Python" from Selenium button (Action class is suggested)
        4-Validate the Header "Selenium-Java Tutorial – Basic to Advance"
        5-Print out(NO validation) Table of Content options on console(loop and getText())
        6-Wait for Second task
 */
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        WebElement pavilionButton = driver.findElement(By.xpath("//a[.='Pavilion']"));
        pavilionButton.click();
        Thread.sleep(2000);
        BrowserUtils.switchByTitle(driver, "Home");

        WebElement seleniumDropDown = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(seleniumDropDown).perform();
        WebElement seleniumPython = driver.findElement(By.linkText("Selenium-Python"));
        actions.click(seleniumPython).perform();
        Thread.sleep(2000);

        WebElement header = driver.findElement(By.xpath("//p//a"));
        String actual = BrowserUtils.getText(header);
        String expect = "VIEW FULL PLAYLIST";
        Assert.assertEquals(actual, expect);

        List<WebElement> allLinks = driver.findElements(By.xpath("//p//a"));
        for (WebElement link : allLinks) {
            System.out.println(BrowserUtils.getText(link));
        }

            /*
            TASK 2:
            1-Go back to the main page "iframe"
            2-click category 1
            3-Validate the header "Category Archives: SeleniumTesting"
            4-Print out all the headers of the contents(I will show you)
            */

            BrowserUtils.switchByTitle(driver, "iframes");
            Thread.sleep(1000);
            driver.switchTo().frame("Frame1");
            WebElement category1 = driver.findElement(By.linkText("Category1"));
            category1.click();
            Thread.sleep(3000);
            BrowserUtils.switchByTitle(driver, "SeleniumTesting Archives");
            WebElement header2 = driver.findElement(By.tagName("h1"));
            Assert.assertEquals(BrowserUtils.getText(header2), "Category Archives: SeleniumTesting");
            Thread.sleep(3000);
            List<WebElement> contentHeaders = driver.findElements(By.xpath("//h3[@class='entry-title']"));
            for (WebElement link2 : contentHeaders) {
                System.out.println(BrowserUtils.getText(link2));
            }

            /*
            TASK 3:
            1-Go back mainPage
            2-Click Category3
            3-Validate the header "Category Archives: SoftwareTesting"

 */
        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame2");
        WebElement category3= driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();

        driver.switchTo().parentFrame();
        BrowserUtils.switchByTitle(driver,"SoftwareTesting Archives - qavalidation");

        WebElement header3= driver.findElement(By.xpath("//h1"));
        System.out.println(header3.getText());



        }

    }

