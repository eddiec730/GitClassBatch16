package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {
    //LOCATORS -->is a way to locate(find) element and manipulate on it
    public static void main(String[] args) throws InterruptedException {
        //ID LOCATOR:
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("file:///Users/edwardcanga/Desktop/Techtorial.html");
        driver.manage().window().maximize();
        WebElement header=driver.findElement(By.id("techtorial1")); //****
        String actualHeader=header.getText().trim(); //it gets the text
        String expectedHeader="Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader) ? "CORRECT" : "WRONG");

        WebElement paragraph=driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());

        //NAME LOCATOR (By.name())

        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Ahmet");

        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Teacher");

        WebElement phoneNum=driver.findElement(By.name("phone"));
        phoneNum.sendKeys("777-666-5555");

        WebElement email=driver.findElement(By.name("userName"));
        email.sendKeys("codefish@hotmail.com");

        WebElement address=driver.findElement(By.name("address1"));
        address.sendKeys("123 Codefish Des Plaines");

        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Des Plaines");

        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("IL");

        WebElement postalCode=driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("77777");

        //CLASS LOCATOR (By.className)

        WebElement allTools=driver.findElement((By.className("group_checkbox")));
        System.out.println(allTools.getText());

        WebElement javaBox=driver.findElement(By.id("cond1"));
        if(javaBox.isDisplayed() && !javaBox.isSelected()){
            javaBox.click(); //.click method
        }
        System.out.println(javaBox.isSelected()? "SELECTED":"NOT SELECTED");

        WebElement testNG=driver.findElement(By.id("cond3"));
        if(testNG.isDisplayed() && !testNG.isSelected()){
            testNG.click();
        }
        System.out.println(testNG.isSelected()? "SELECTED":"NOT SELECTED");

        WebElement cucumber=driver.findElement(By.id("cond4"));
        if(cucumber.isDisplayed() && !cucumber.isSelected()){
            cucumber.click();
        }
        System.out.println(cucumber.isSelected()? "SELECTED":"NOT SELECTED");


        //TAG NAME LOCATOR
        WebElement header2=driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText()); //.getText prints out the text

        WebElement useJava=driver.findElement(By.tagName("u"));
        System.out.println(useJava.getText());

        Thread.sleep(2000);

        driver.quit();



    }
}
