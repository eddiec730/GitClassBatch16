package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class OpenChartTestNGPractice {

    @Test
    public void successfulLogin() throws InterruptedException {

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

        String title = driver.getTitle();
        String expectedlUrl = "Dashboard";
        Assert.assertEquals(title, expectedlUrl);

    }

    @Test
    public void negativeTest() throws InterruptedException {
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
        password.sendKeys("Demo");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement negative = driver.findElement(By.xpath("//div[@id='alert']"));
        String negativeActual = negative.getText().trim();
        String negativeExpected = "No match for Username and/or Password.";
        Assert.assertEquals(negativeActual, negativeExpected);

    }

    @Test
    public void validateProductButton() throws InterruptedException {
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
        Assert.assertTrue(product.isDisplayed());
        Assert.assertTrue(product.isEnabled());


    }

    public void validateBoxesFunctionality() throws InterruptedException {
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
        Thread.sleep(2000);


        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (int i = 1; i < allBoxes.size(); i++) {
            Thread.sleep(1000);
            Assert.assertTrue(allBoxes.get(i).isDisplayed());
            Assert.assertTrue(allBoxes.get(i).isEnabled());
            Assert.assertFalse(allBoxes.get(i).isSelected());//as default it shouldn't be selected
            allBoxes.get(i).click();
            Assert.assertTrue(allBoxes.get(i).isSelected());//this one should be selected
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);

        }

    }

    @Test
    public void validateProductNameFunctionalityAscending() throws InterruptedException {
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
        WebElement productListButton = driver.findElement(By.xpath("//a[.='Product Name']"));
        productListButton.click();
        Thread.sleep(2000);

        List<WebElement> productName = driver.findElements(By.xpath("//td[@class='text-start']"));
        ArrayList<String> actualOrder = new ArrayList<>(); // always do this with ascending/descending comparisons
        ArrayList<String> expectedOrder = new ArrayList<>();
        for (int i = 1; i < productName.size(); i++) {
            actualOrder.add(productName.get(i).getText().toLowerCase().trim());//because of ASCII table (lower comes first)
            expectedOrder.add(productName.get(i).getText().toLowerCase().trim());//same order, same item
        }// this test will never fail because it hasn't been reversed yet

        Collections.sort(expectedOrder);//only touch expected, don't touch actual order
        System.out.println(actualOrder);// print out just to double check
        System.out.println(expectedOrder);
        Collections.reverse(expectedOrder);
        Assert.assertEquals(actualOrder,expectedOrder);




    }
    //Replay video to see how to handle the exceptions
    @Test
    public void validateDescendingOrder() throws InterruptedException {
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

        WebElement productListButton = driver.findElement(By.xpath("//a[.='Product Name']"));
        productListButton.click();
        Thread.sleep(2000);


        List<WebElement> productName = driver.findElements(By.xpath("//td[@class='text-start']"));
        ArrayList<String> actualOrder = new ArrayList<>(); // always do this with ascending/descending comparisons
        ArrayList<String> expectedOrder = new ArrayList<>();
        for (int i = 1; i < productName.size(); i++) {
            actualOrder.add(productName.get(i).getText().toLowerCase().trim());//because of ASCII table (lower comes first)
            expectedOrder.add(productName.get(i).getText().toLowerCase().trim());//same order, same item
        }// this test will never fail because it hasn't been reversed yet

        Collections.sort(expectedOrder);//only touch expected, don't touch actual order
        System.out.println(actualOrder);// print out just to double check
        System.out.println(expectedOrder);
        Collections.reverse(expectedOrder);
        Assert.assertEquals(actualOrder,expectedOrder);



    }

}

