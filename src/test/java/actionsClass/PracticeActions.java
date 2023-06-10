package actionsClass;

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

import java.time.Duration;

public class PracticeActions {
    @Test
    public void practiceDragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement dropHere= driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@class='drop-box ui-droppable']"));
        String actualMessage= BrowserUtils.getText(dropHere);
        String expectedMessage="Drop here";
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement dragMe= driver.findElement(By.xpath("//div[@id='draggable']"));
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragMe,dropHere);
        dropHere= driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@class='drop-box ui-droppable']"));
        String afterDragAndDrop=BrowserUtils.getText(dropHere);
        String expectedAfterDragAndDrop="Dropped!";
        Assert.assertEquals(afterDragAndDrop,expectedAfterDragAndDrop);
        Thread.sleep(2000);
        String actualBackgroundColor=dropHere.getCssValue("background-color");
        String expectedBackground="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualBackgroundColor, expectedBackground);


    }
    @Test
    public void practiceClickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        WebElement ClickAccept = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        ClickAccept.click();
        Thread.sleep(2000);
        WebElement notAccept=driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        String actualNotAccept = BrowserUtils.getText(notAccept);
        String expectedNotAccept = "Not Acceptable";
        Assert.assertEquals(actualNotAccept,expectedNotAccept);
        Thread.sleep(2000);
        WebElement DropBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualDropHere = BrowserUtils.getText(DropBox);
        String expectedDropHere = "Drop here";
        Assert.assertEquals(actualDropHere,expectedDropHere);
        Actions actions = new Actions(driver);
        actions.clickAndHold(notAccept).moveToElement(DropBox).release().perform();
        WebElement afterDrop = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//p"));
        String actualAfterDropMsg = BrowserUtils.getText(afterDrop);
        String expectedAfterDropMsg = "Drop here";
        Assert.assertEquals(actualAfterDropMsg,expectedAfterDropMsg);



    }
}
