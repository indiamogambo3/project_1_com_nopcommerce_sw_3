package browserfactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl) {

        //Open the browser
        driver = new ChromeDriver();
        //Open URL in the browser
        driver.get(baseUrl);
        //Maximise browser
        driver.manage().window().maximize();
        //set Implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void closeBrowser() {

        driver.quit();
    }
}
