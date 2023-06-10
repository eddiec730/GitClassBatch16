package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName=driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.sendKeys("Edward");

        WebElement lastName=driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.sendKeys("Canga");

        WebElement email=driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("eddiec730@gmail.com");

        WebElement telephone=driver.findElement(By.xpath("//input[@id='input-telephone']"));
        telephone.sendKeys("(123)456-7891");

        WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("loginplease");

        WebElement confirmPassword=driver.findElement(By.xpath("//input[@id='input-confirm']"));
        confirmPassword.sendKeys("loginplease");

        WebElement privacyPolicy=driver.findElement(By.xpath("//input[@name='agree']"));
        privacyPolicy.click();

        WebElement continueButton=driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        WebElement header=driver.findElement(By.xpath("//h1[.='Your Account Has Been Created!']")); //contains would've been a better choice
        String actualHeader=header.getText();
        String expectedHeader="Your Account Has Been Created!";
        System.out.println(actualHeader.equals(expectedHeader)?"Header is validated":"Header is not validated");

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://tutorialsninja.com/demo/index.php?route=account/success";
        System.out.println(actualUrl.equals(expectedUrl)?"URL is validate":"Url is NOT validated");

        driver.quit();


    }
}
