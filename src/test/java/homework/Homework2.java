package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework2 {
    public static void main(String[] args) throws InterruptedException {
        //CASE 1
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        driver.get("https://demoqa.com/text-box");

        WebElement name=driver.findElement(By.xpath("//input[@id='userName']"));
        name.sendKeys("Edward Canga");

        WebElement email=driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("eddiec730@gmail.com");

        WebElement address= driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        address.sendKeys("1350 W Hood Ave");

        WebElement permAddress=driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permAddress.sendKeys("7924 Babb Ave");
        Thread.sleep(2000);
        WebElement button=driver.findElement(By.id("submit"));
        button.click();
        Thread.sleep(2000);

        //WebElement expectedName=driver.findElement(By.xpath("//p[@id='name']"));

        Thread.sleep(2000);
        String actualName = driver.findElement(By.xpath("//p[@id='name']")).getText();
        String expectedName = "Name:Edward Canga";
        System.out.println(actualName.equals(expectedName) ? "Name is Valid" : "Name is not valid");

        Thread.sleep(2000);
        String actualEmail= driver.findElement(By.xpath("//p[@id='email']")).getText();
        String expectedEmail="Email:eddiec730@gmail.com";
        System.out.println(actualEmail.equals(expectedEmail)?"Email is Valid":"Email is not");

        String actualAddress=driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();
        String expectedAddress="Current Address :1350 W Hood Ave";
        System.out.println(actualAddress.equals(expectedAddress) ?"Address is Valid":"Address is not valid");

        String actualPermAddress=driver.findElement(By.xpath("//p[@id='permanentAddress']")).getText();
        String expectedPermAddress="Permananet Address :7924 Babb Ave"; //spelling bug
        System.out.println(actualPermAddress.equals(expectedPermAddress) ?"Permanent Address is Valid":"Permanent is not valid");


    }
}
