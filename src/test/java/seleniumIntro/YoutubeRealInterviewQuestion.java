package seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YoutubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
        //Thread.sleep(2000)
        //song.sendKeys(Keys.ARROW_DOWN) -->put this inside of the loop

        WebElement searchBar=driver.findElement(By.xpath("//input[@id='search']"));
        searchBar.sendKeys("Justin Bieber");
        searchBar.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
//        WebElement searchButton=driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
//        searchButton.click();

        List<WebElement> songs=driver.findElements(By.xpath("//a[@id='video-title']"));
        for(WebElement song: songs){
            if(song.getAttribute("title").equals("Justin Bieber - Ghost")){
                Thread.sleep(500);
                song.sendKeys(Keys.ARROW_DOWN);
                song.click();
                break;
            }
        }



    }
}
