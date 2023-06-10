package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

            /*
        1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
        2-Enter first and last name (textbox).
        3-Select gender (radio button).
        4-Select years of experience (radio button).
        5-Enter date.(send keys)
        6-Select Profession (Checkbox). -->choose Both
        7-Select Automation tools you are familiar with (multiple checkboxes). --> Choose Selenium
        8-Select Continent(Send Keys).
        9-Click on Submit button.
        10-Validate the url https://www.techlistic.com/p/selenium-practice-form.html
        10-Close the webpage
        Try your own logic and automate it without any help.
     */
        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Edward");

        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Canga");

        WebElement genderButton=driver.findElement(By.id("sex-0"));
        genderButton.click();

       WebElement experience=driver.findElement(By.id("exp-4"));
        experience.click();

       WebElement date=driver.findElement(By.id("datepicker"));
       date.sendKeys("5/16/23");

       WebElement profession=driver.findElement(By.id("profession-1"));
       if(profession.isDisplayed() && !profession.isSelected()){
           profession.click();
       }

       WebElement automation=driver.findElement(By.id("tool-2"));
       if(automation.isDisplayed() && !automation.isSelected()){
           automation.click();
       }

       WebElement continent=driver.findElement(By.id("continents"));
       continent.sendKeys("North America");

       WebElement button=driver.findElement(By.id("submit"));
       button.click();

       String url= driver.getCurrentUrl();
       String expectedURl="https://www.techlistic.com/p/selenium-practice-form.html";
        System.out.println(url.equals(expectedURl)?"Passed URL":"failed URL");











    }
}
