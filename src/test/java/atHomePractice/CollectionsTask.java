package atHomePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTask {
    @Test
    public void validateProductNameFunctionalityDescending() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement exButton = driver.findElement(By.cssSelector(".btn-close"));
        exButton.click();
        Thread.sleep(2000);

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();
        Thread.sleep(2000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();

        /*
        TEST CASE:
        1-You will click the productName button
        2-You should create 2 arrayList
         *-One of them will be actualData
         *-Another will be expectedData
        3-For(int i = 1)
            *Store all the names for both of the list
        4-For expected List --->you will use Collections.sort(expectedList)
                            --->Collections.reverse(expected)
                            Assert.equals(actualList,expectedList)

         */

        WebElement productNameButton=driver.findElement(By.cssSelector(".asc"));
        productNameButton.click();
        Thread.sleep(2000);

        List<WebElement> products= driver.findElements(By.xpath("//td[@class='text-start']"));
        ArrayList<String> actualProducts= new ArrayList<>();
        ArrayList<String> expectedProducts= new ArrayList<>();

        for(int i =1; i< products.size(); i++){
            actualProducts.add(products.get(i).getText().toLowerCase());
            expectedProducts.add(products.get(i).getText().toLowerCase());
        }

        Collections.sort(expectedProducts);
        Collections.reverse(expectedProducts);
        Assert.assertEquals(actualProducts,expectedProducts);

    }
}