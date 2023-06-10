package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {
    public static String getText(WebElement element){
        return element.getText().trim();
    }

    public static void selectBy(WebElement location, String value, String methodName){

        Select select = new Select(location);

        switch(methodName){
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Your method name is not correct");
                Assert.assertTrue(false);
        }

    }
    public static String getTitleJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString().trim();
    }
    public static void clickWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);

    }
    public static void scrollWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);

    }
    public static void switchByID(WebDriver driver){
        String mainPageID = driver.getWindowHandle();
        Set<String> allPagesID = driver.getWindowHandles();

        for(String id : allPagesID){
            if(!id.equals(mainPageID)){
                driver.switchTo().window(id);
                break;
            }
        }
    }
    public static void switchByTitle(WebDriver driver, String title){
        Set<String> allPagesId=driver.getWindowHandles();
        for(String id:allPagesId){
            driver.switchTo().window(id);
            if(driver.getTitle().contains(title)){
                break;
            }
        }
    }
}
