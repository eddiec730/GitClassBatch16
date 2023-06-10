package seleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.operator.bc.BcSignerOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathRealHealthProject {
    /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.

1-9=USE XPATH
10 AND BEYOND SHOULD BE CONTAINS OR .EQUALS
 */
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://katalon-demo-cura.herokuapp.com/ ");
        Thread.sleep(2000);

        //CSS selector
        WebElement makeAppointment=driver.findElement(By.cssSelector("#btn-make-appointment"));
        //WebElement makeAppointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointment.click();
        Thread.sleep(2000);

        WebElement userName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        userName.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();

        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Tokyo");

        WebElement apply = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (apply.isDisplayed() && !apply.isSelected()) {
            apply.click();
        }

        WebElement medicaid = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        medicaid.click();

        WebElement visitDate = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        visitDate.sendKeys("12/13/2000");

        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("I want to complete this task");
        Thread.sleep(2000);

        WebElement bookAppt = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppt.click();

        WebElement printFacility=driver.findElement(By.xpath("//p[contains(text(),'CURA')]"));
        System.out.println(printFacility.getText());

        WebElement applyReadmission=driver.findElement(By.xpath("//p[.='Yes']"));
        System.out.println(applyReadmission.getText());

        WebElement printMedicaid=driver.findElement(By.xpath("//p[.='Medicaid']"));
        System.out.println(printMedicaid.getText());

        WebElement printVisitDate=driver.findElement(By.xpath("//p[@id='visit_date']"));
        System.out.println(printVisitDate.getText());

        WebElement printComment=driver.findElement(By.xpath("//p[@id='comment']"));
        System.out.println(printComment.getText());


        WebElement header = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Appointment Confirmation";
        System.out.println(actualHeader.equals(expectedHeader) ? "header is validated" : "header is not");
        System.out.println(header.getText());

        Thread.sleep(2000);


        WebElement goToHomeP=driver.findElement(By.xpath("//a[.='Go to Homepage']"));
        goToHomeP.click();

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://katalon-demo-cura.herokuapp.com/";
        System.out.println(expectedUrl);

        //driver.quit();


    }

}
