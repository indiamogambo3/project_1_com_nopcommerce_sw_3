package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUpBrowser() {

        openBrowser(baseUrl);
    }

    //create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {

        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text() = '" + menu + " ']"));
    }

    /**
     * create the @Test method name verifyPageNavigation.use selectMenu method to
     * select the Menu and click on it and verify the page navigation.
     */

    @Test
    public void verifyPageNavigation() throws InterruptedException {
        Thread.sleep(2000);
        selectMenu("Computers");
        String expectedText = "Computers";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Computers')]"));
        Assert.assertEquals("Unable to verify text.", expectedText, actualText);
    }


    @After
    public void tearDown() {

        closeBrowser();
    }


}
