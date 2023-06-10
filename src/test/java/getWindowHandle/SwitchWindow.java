package getWindowHandle;

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
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickHere= driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();
        Thread.sleep(2000);
        WebElement header= driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header)); //Open a new Window
        System.out.println(driver.getWindowHandle()); //main pageId-->The internet
        //9738E4FBC85F3C3D53310B439E5038FE -->mainPageID
        String mainPageId=driver.getWindowHandle();
        Set<String> allPagesID=driver.getWindowHandles();
        for(String id: allPagesID){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id); // driver.switchTo()
                break;
            }
            header= driver.findElement(By.tagName("h3"));
            System.out.println(BrowserUtils.getText(header));
        }

        System.out.println(allPagesID);

    }
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button2 = driver.findElement(By.cssSelector("#newTabBtn"));
        BrowserUtils.scrollWithJS(driver, button2);
        button2.click();
        String mainPageID = driver.getWindowHandle();
        Set<String> allPagesID = driver.getWindowHandles();

        for(String id : allPagesID){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        WebElement header = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        Assert.assertEquals(BrowserUtils.getText(header), "AlertsDemo");
        Assert.assertEquals(driver.getTitle(), "AlertsDemo - H Y R Tutorials");

        WebElement box = driver.findElement(By.xpath("//button[@id='alertBox']"));
        box.click();


    }
}
