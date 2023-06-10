package atHomePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice1 {
    public static void main(String[] args) {


        // Locators
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver =new ChromeDriver(options);

       driver.navigate().to("file:///Users/edwardcanga/Desktop/Techtorial.html"); //url you are getting the data from

        WebElement firstName=driver.findElement(By.name("firstName"));
        firstName.sendKeys("Edward"); // adding data (.sendKeys)

        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("Canga");

        WebElement phoneNumber=driver.findElement(By.name("phone"));
        phoneNumber.sendKeys("(773)757-8346");

        WebElement email=driver.findElement(By.id("userName"));
        email.sendKeys("eddiec730@gmail.com");

        WebElement address=driver.findElement(By.name("address1"));
        address.sendKeys("333 N Alaska");

        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Chicago");

        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("Illinois");

        WebElement postalCode=driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("60777");

        //Locators by class

        WebElement allTools=driver.findElement(By.className("group_checkbox"));

        WebElement javaBox=driver.findElement(By.id("cond1"));
            if (javaBox.isDisplayed() && !javaBox.isSelected()) {
                javaBox.click();
        }
        System.out.println(javaBox.isSelected()? "Selected":"Is not selected");

        WebElement seleniumBox=driver.findElement(By.id("cond2"));
        if(seleniumBox.isDisplayed() && seleniumBox.isSelected()){
            seleniumBox.click();
        }
        System.out.println(seleniumBox.isSelected()?"Selected":"Is not selected");

        WebElement testNGBox=driver.findElement(By.id("cond3"));
        if(testNGBox.isDisplayed()&& !testNGBox.isSelected()){
            testNGBox.click();
        }
        System.out.println(testNGBox.isSelected()?"Selected":"Is not selected");

        WebElement cucumberBox=driver.findElement(By.id("cond4"));
        if(cucumberBox.isDisplayed() && !cucumberBox.isSelected()){
            cucumberBox.click();
        }
        System.out.println(cucumberBox.isSelected()?"Selected":"Is not selected");

        /*
        1-Click Selenium and validate(ternary) header -->Selenium automates browsers. That's it!
        2-Go back to the main page
        3-Click Cucumber and validate(ternary) header -->Tools & techniques that elevate teams to greatness
        4-Go back to the main page
        5-Click TestNG and validate(ternary) header -->TestNG
        6-Go back to the main page
        7-Validate(ternary) the url is "file:///Users/codefish/Downloads/Techtorial.html"
                */
        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement seleniumHeader=driver.findElement(By.tagName("h1"));
        String actualHeader = seleniumHeader.getText().trim();
        String expectedHeader="Selenium automates browsers. That's it!";
        System.out.println(actualHeader.equals(expectedHeader)?"Correct":"False");
        driver.navigate().back();

        //do the cucumber portion of test when available

        WebElement testNGlink=driver.findElement(By.linkText("TestNG"));
        testNGlink.click();
        WebElement testNGHeader=driver.findElement(By.tagName("h2"));
        String actualHeader2=testNGHeader.getText().trim();
        String expectedHeader2="TestNG";
        System.out.println(actualHeader2.equals(expectedHeader2)?"Correct":"False");
        driver.navigate().back();

        String actualURL= driver.getCurrentUrl();
        String expectedURL="file:///Users/edwardcanga/Desktop/Techtorial.html";
        System.out.println(actualURL.equals(expectedURL)?"Passed URL":"failed URL");






    }
}
