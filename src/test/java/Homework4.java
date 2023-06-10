import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Homework4 {
    //CASE 3
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        WebElement username=driver.findElement(By.xpath("//input[@id='user-name']"));
        username.sendKeys("standard_user");

        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton= driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        Thread.sleep(2000);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="https://www.saucedemo.com/inventory.html";
        System.out.println(actualUrl.equals(expectedUrl)?"URL is validated":"Url is not validated");





    }

}
