package seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementsPractice {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //wait times
        driver.navigate().to("https://the-internet.herokuapp.com/"); //url

        List<WebElement> allLinks=driver.findElements(By.xpath("//li"));
        int count=0;
        for(WebElement links:allLinks){
            System.out.println(links.getText());
            count++;
        }
        System.out.println(count);

        //TASK2
        //Print it if length is equal and more than 12 and count how many
        int count2=0;
        for(WebElement link:allLinks){
            if(link.getText().length()>=12){
                System.out.println(link.getText().trim());
                count2++;
            }
        }
        System.out.println(count2);

    }
}
