package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Homework1 {
    /*
    TASK:
1-Create a homework package and class
2-Under 1 main method--> go to 3 different websites and validate the title, and URL of the page with Ternary Operator.
(It can be any website you decide)
SIDE NOTE: You do not need to create 3 different web drivers. One will be enough.
     */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);

        // Website 1
        driver.get("https://www.rottentomatoes.com/");
        String actualTitle=driver.getTitle();
        String expectedTitle="Rotten Tomatoes: Movies | TV Shows | Movie Trailers | Reviews - Rotten Tomatoes";
        String title =actualTitle.equals(expectedTitle) ? "Rotten Tomatoes title has passed" :"Rotten Tomatoes title has failed";
        System.out.println(title);

        String actualURL=driver.getCurrentUrl();
        String expectedURL="https://www.rottentomatoes.com/";
        String url=actualURL.equals(expectedURL) ? "Rotten Tomatoes URL has passed": "Rotten Tomatoes URL has failed";
        System.out.println(url);

        //Website 2
        driver.get("https://www.criterion.com/");
        String actualTitle2=driver.getTitle();
        String expectedTitle2="The Criterion Collection";
        String title2=actualTitle2.equals(expectedTitle2) ? "Criterion title has passed" : "Criterion title has failed";
        System.out.println(title2);

        String actualURL2=driver.getCurrentUrl();
        String expectedURL2="https://www.criterion.com/";
        String url2=actualURL2.equals(expectedURL2) ? "Criterion URL has passed": "Criterion URL has failed";
        System.out.println(url2);

        //Website 3
        driver.get("https://www.boxofficemojo.com/");
        String actualTitle3=driver.getTitle();
        String expectedTitle3="Home - Box Office Mojo";
        String title3=actualTitle3.equals(expectedTitle3) ? "Box Office Mojo title has passed" : "Box Office Mojo title has failed";
        System.out.println(title3);

        String actualURL3= driver.getCurrentUrl();
        String expectedURL3="https://www.boxofficemojo.com/";
        String url3=actualURL3.equals(expectedURL3) ? "Box Office Mojo URL has passed" : "Box Office Mojo URL has failed";
        System.out.println(url3);
        driver.close();

    }
}
