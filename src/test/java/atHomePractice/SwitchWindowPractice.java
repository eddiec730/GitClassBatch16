package atHomePractice;

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

public class SwitchWindowPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button2= driver.findElement(By.cssSelector("#newTabBtn"));
        BrowserUtils.scrollWithJS(driver, button2);
        button2.click();
        Thread.sleep(1000);

        String mainPageID=driver.getWindowHandle();
        Set<String> allPagesID=driver.getWindowHandles();
        for(String id: allPagesID){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
        WebElement header= driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));
        Assert.assertEquals(BrowserUtils.getText(header),"AlertsDemo");
        Assert.assertEquals(driver.getTitle(),"AlertsDemo - H Y R Tutorials");

        WebElement box = driver.findElement(By.xpath("//button[@id='alertBox']"));
        box.click();

    }
}
