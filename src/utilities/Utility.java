package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    /**
     * This method will click on the element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();

    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    /**
     * This method will send text to the element
     */
    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }


    //************************ Alert Methods ************************************//
    // 5 methods
    //switch to alert, accept alert, dismiss alert, get text, send text

    /**
     * This method will switch to alert
     */

    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will accept to alert
     */

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss to alert
     */

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get text from alert
     */

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * This method will send text from alert
     */

    public void getTextFromAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }


    //************************ Select Class Methods ************************************//

    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        new Select(driver.findElement(by)).selectByVisibleText(text);
//        WebElement dropDown = driver.findElement(by);
//        Select select = new Select(dropDown);
//        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by visible value
     */
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
//        WebElement dropDown = driver.findElement(by);
//        Select select = new Select(dropDown);
//        select.selectByVisibleText(value);
    }

    //create index method

    /**
     * This method will select the option by index value
     */
    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
//        WebElement dropDown = driver.findElement(by);
//        Select select = new Select(dropDown);
//        select.selectByIndex(index);
    }


}
