package framesAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NestedFrame {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        WebElement iframeLeft=driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(iframeLeft);
        WebElement left= driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(left));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middle=driver.findElement(By.xpath("//div[contains(text(),'MIDDLE')]"));
        System.out.println(BrowserUtils.getText(middle));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(right));
        //Can you print out bottom
//        driver.switchTo().parentFrame();//top frame
//        driver.switchTo().parentFrame();//main html
        driver.switchTo().defaultContent(); //this is an interview question, this will go to main html no matter what
        //switching frame with indexing
        driver.switchTo().frame(1);//Bottom
        WebElement bottom=driver.findElement(By.xpath("//body[contains(text(),'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottom));


    }
}
