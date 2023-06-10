package seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/ ");

        WebElement appointmentButton=driver.findElement(By.cssSelector("#btn-make-appointment"));
        appointmentButton.click();

        WebElement demoName=driver.findElement(By.cssSelector(".form-control"));
        //System.out.println(demoName.getText()); // text won't work because no attribute (black text)
        WebElement demoName1=driver.findElement(By.xpath("//input[@value='John Doe']"));
        System.out.println(demoName.getAttribute("value"));//John Doe
        System.out.println(demoName.getAttribute("type"));//text




    }
}
