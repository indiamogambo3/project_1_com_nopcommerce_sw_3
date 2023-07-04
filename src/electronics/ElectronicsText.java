package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsText extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUpBrowser() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {

        //Mouse Hover on “Electronics” Tab
        WebElement electronics = driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text() = 'Electronics ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).build().perform();
        // Mouse Hover on “Cell phones” and click
        WebElement cellPhones = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(cellPhones).click().build().perform();
        //Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[(text() = 'Cell phones')]"));
        Assert.assertEquals("Unable to verify text.", expectedText, actualText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {

        //Mouse Hover on “Electronics” Tab
        WebElement electronics = driver.findElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text() = 'Electronics ']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).build().perform();
        // Mouse Hover on “Cell phones” and click
        WebElement cellPhones = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(cellPhones).click().build().perform();
        //Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[(text() = 'Cell phones')]"));
        Assert.assertEquals("Unable to verify text.", expectedText, actualText);
        //Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        // Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[(text() = 'Nokia Lumia 1020')]"));
        //Verify the text “Nokia Lumia 1020”
        String expectedNokia = "Nokia Lumia 1020";
        String actualNokia = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("Unable to verify text.", expectedNokia, actualNokia);
        // Verify the price “$349.00”
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.id("price-value-20"));
        Assert.assertEquals("Unable to verify price.", expectedPrice, actualPrice);
        // Change quantity to 2
        Thread.sleep(1000);
        driver.findElement(By.id("product_enteredQuantity_20")).clear();
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");
        //Click on “ADD TO CART” tab
        Thread.sleep(1000);
        clickOnElement(By.id("add-to-cart-button-20"));
        // Verify the Message "The product has been added to your shopping cart" on Top green Bar.
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//div[@class = 'bar-notification success']//p[@class = 'content']"));
        Assert.assertEquals("Unable to verify message.", expectedMessage, actualMessage);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//div[@class = 'bar-notification success']//span[@class = 'close']"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        WebElement shoppingCart = driver.findElement(By.xpath("//span[@class = 'cart-label']"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(shoppingCart).build().perform();
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        // Verify the message "Shopping cart"
        String expectedShoppingCartText = "Shopping cart";
        String actualShoppingCartText = getTextFromElement(By.xpath("//h1[(text() = 'Shopping cart')]"));
        Assert.assertEquals("Unable to verify text.", expectedShoppingCartText, actualShoppingCartText);
        // Verify the quantity is 2
        String expectedQuantity = "2";
        String actualQuantity = driver.findElement(By.xpath("//input[@class='qty-input']")).getAttribute("value");
        Assert.assertEquals("Unable to verify quantity.", expectedQuantity, actualQuantity);
        //Verify the Total $698.00
        String expectedTotal = "$698.00";
        String actualTotal = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals("Unable to match total.", expectedTotal, actualTotal);
        // Click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        // Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        // Verify the Text “Welcome, Please Sign In!”
        String expectedWelcomeText = "Welcome, Please Sign In!";
        String actualWelcomeText = getTextFromElement(By.xpath("//h1[(text() = 'Welcome, Please Sign In!')]"));
        // Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[@class = 'button-1 register-button']"));
        //Verify the text "Register"
        String expectedRegisterText = "Register";
        String actualRegisterText = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Unable to verify text", expectedRegisterText, actualRegisterText);
        // Fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "Mukz");
        sendTextToElement(By.id("LastName"), "Shah");
        sendTextToElement(By.id("Email"), "kkkk1234@gmail.com");
        sendTextToElement(By.id("Password"), "mukz123");
        sendTextToElement(By.id("ConfirmPassword"), "mukz123");
        // Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));
        // Verify the message “Your registration completed”
        String expectRegistrationMessage = "Your registration completed";
        String actualRegistrationMessage = getTextFromElement(By.xpath("//div[(text() = 'Your registration completed')]"));
        Assert.assertEquals("Unable to verify registration message.", expectRegistrationMessage, actualRegistrationMessage);
        //Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class  = 'button-1 register-continue-button']"));
        //Verify the text “Shopping cart”
        String expectedShoppingText = "Shopping cart";
        String actualShoppingText = getTextFromElement(By.xpath("//h1[(text() = 'Shopping cart')]"));
        Assert.assertEquals("Unable to verify text.", expectedShoppingText, actualShoppingText);
        //Click on login
        Thread.sleep(2000);
        clickOnElement(By.linkText("Log in"));
        //Enter email
        sendTextToElement(By.id("Email"), "kkkk1234@gmail.com");
        //Enter password
        sendTextToElement(By.id("Password"), "mukz123");
        //click on login
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        //click on checkbox “I agree with the terms of service
        Thread.sleep(2000);
        clickOnElement(By.id("termsofservice"));
        // Click on “CHECKOUT”
        Thread.sleep(2000);
        clickOnElement(By.id("checkout"));
        //Fill the Mandatory fields
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "123 Street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "LN1 1LN");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "12345678952");
        //Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        // Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(2000);
        clickOnElement(By.id("shippingoption_2"));
        //Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        //Select Radio Button “Credit Card”
        Thread.sleep(2000);
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //Select “Visa” From Select credit card dropdown
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Visa");
        //Fill all the details
        Thread.sleep(2000);
        sendTextToElement(By.id("CardholderName"), "Mukz");
        sendTextToElement(By.id("CardNumber"), "1254658974125698");
        sendTextToElement(By.id("ExpireMonth"), "9");
        sendTextToElement(By.id("ExpireYear"), "2024");
        sendTextToElement(By.id("CardCode"), "222");
        //Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        // Verify “Payment Method” is “Credit Card”
        String expectedPaymentMethod = "Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Unable to verify payment method.", expectedPaymentMethod, actualPaymentMethod);
        // Verify “Shipping Method” is “2nd Day Air”
        String expectedShippingMethod = "2nd Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class = 'shipping-method']//span[@class = 'value']"));
        Assert.assertEquals("Unable to verify shipping method.", expectedShippingMethod, actualShippingMethod);
        ;
        // Verify Total is “$698.00”
        String expectedItemsTotal = "$698.00";
        String actualItemsTotal = getTextFromElement(By.xpath("//span[@class = 'product-subtotal']"));
        Assert.assertEquals("Unable to verify items total.", expectedItemsTotal, actualItemsTotal);
        ;
        //lick on “CONFIRM”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        // Verify the Text “Thank You”
        String expectedThankYou = "Thank you";
        String actualThankYou = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Unable to verify Thank You.", expectedThankYou, actualThankYou);
        // Verify the message “Your order has been successfully processed!”
        String expectedOrderMessage = "Your order has been successfully processed!";
        String actualOrderMessage = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Unable to verify order message.", expectedOrderMessage, actualOrderMessage);
        //Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        // Verify the text “Welcome to our store”
        String expectedWelcomeMessage = "Welcome to our store";
        String actualWelcomeMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Unable to verify welcome message.", expectedWelcomeMessage, actualWelcomeMessage);
        //Click on “Logout” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        // Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Unable to verify URL.", expectedUrl, actualUrl);
    }


    @After
    public void tearDown() {

        closeBrowser();
    }

}
