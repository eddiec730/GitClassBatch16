package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework3 {
    public static void main(String[] args) throws InterruptedException {
        //CASE 2
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");

        WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();
        Thread.sleep(2000);

        WebElement epicSadFace=driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]"));
        String actualEpicSadFace=epicSadFace.getText().trim();
        String expectedEpicSadFace="Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualEpicSadFace.equals(expectedEpicSadFace)?"Message is Validated":"Message validation failed");


    }
}
