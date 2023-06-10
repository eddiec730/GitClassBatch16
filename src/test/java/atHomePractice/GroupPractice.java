package atHomePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class GroupPractice {
    @Test
    public void amazonTask() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");

        WebElement tile= driver.findElement(By.xpath("//a[.='Tile']"));
        tile.click();
        Thread.sleep(500);

        List<WebElement> allIcons=driver.findElements(By.xpath("//div[@id='chessboard']//span[@class='icon']"));
        Actions actions=new Actions(driver);

        List<String> expectedText= Arrays.asList("Black King","Black Queen","Black Rook","Black Bishop","Black Knight","Black Pawn");

//        for(int i = 0;i < allIcons.size(); i++){
//            actions.moveToElement(allIcons.)
//        }



    }
}
