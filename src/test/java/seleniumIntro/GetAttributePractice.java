package seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class GetAttributePractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");

        WebElement collapseButton=driver.findElement(By.xpath("//button"));
        collapseButton.click();
        Thread.sleep(2000);

        List<WebElement> condiments=driver.findElements(By.xpath("//div[@role='checkbox']"));

        for(WebElement condiment: condiments){
            if(condiment.getAttribute("aria-checked").equals("false")){
                condiment.click();
            }
        }
    }
}
