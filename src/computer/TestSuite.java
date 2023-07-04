package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUpBrowser() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {

        //Find 'Computers' element on menu bar and click on 'Computers' link
        clickOnElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text() = 'Computers ']"));
        //Find 'Desktop' element and click on 'Desktop' link
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        // Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //Verify products arranged in descending order
        String expectedText = "Name: Z to A";
        String actualText = getTextFromElement(By.xpath("//select[@id='products-orderby']//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("Unable to verify descending order", expectedText, actualText);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {

        //Find 'Computers' element on menu bar and click on 'Computers' link
        clickOnElement(By.xpath("//ul[@class = 'top-menu notmobile']//a[text() = 'Computers ']"));
        //Find 'Desktop' element and click on 'Desktop' link
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        //Find 'ADD TO CART' button element and click on 'ADD TO CART' button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        // Verify the Text "Build your own computer
        String expectedText = "Build your own computer";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Unable to verify text.", expectedText, actualText);
        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //Select "8GB [+$60.00]" using Select class.
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");
        // Find and Select HDD radio "400 GB [+$100.00]" element
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_3_7"));
        //  Find and Select OS radio "Vista Premium [+$60.00]" element
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_4_9"));
        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        Thread.sleep(1000);
        clickOnElement(By.id("product_attribute_5_12"));
        // Verify the price "$1,475.00"
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.xpath("//span[text() = '$1,475.00']"));
        Assert.assertEquals("Unable to match price.", expectedPrice, actualPrice);
        // Click on "ADD TO CARD" Button.
        Thread.sleep(1000);
        clickOnElement(By.id("add-to-cart-button-1"));
        // Verify the Message "The product has been added to your shopping cart" on Top green Bar.
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Unable to verify message.", expectedMessage, actualMessage);
        //After that close the bar clicking on the cross button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[@class = 'close']"));
        // MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath("//span[@class = 'cart-label']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCart).click().build().perform();
        // Verify the message "Shopping cart"
        String expectedCartMessage = "Shopping cart";
        String actualCartMessage = getTextFromElement(By.xpath("//h1[(text() = 'Shopping cart')]"));
        Assert.assertEquals("Unable to verify message.", expectedCartMessage, actualCartMessage);
        // Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@class = 'qty-input']")).clear();
        sendTextToElement(By.xpath("//input[@class = 'qty-input']"), "2");
        clickOnElement(By.id("updatecart"));
        //Verify the Total"$2,950.00"
        String expectedTotalPrice = "$2,950.00";
        String actualTotalPrice = getTextFromElement(By.xpath("//span[text() = '$2,950.00']"));
        Assert.assertEquals("Unable to match price.", expectedTotalPrice, actualTotalPrice);
        //Click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnElement(By.id("termsofservice"));
        //Click on “CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.id("checkout"));
        // Verify the Text “Welcome, Please Sign In!”
        String expectedSigninText = "Welcome, Please Sign In!";
        String actualSigninText = getTextFromElement(By.xpath("//h1[(text() = 'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Unable to match text.", expectedSigninText, actualSigninText);
        //Click on “CHECKOUT AS GUEST” Tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[(@class = 'button-1 checkout-as-guest-button')]"));
        // Fill all the mandatory field
        Thread.sleep(1000);
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Mukz");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Shah");
        sendTextToElement(By.id("BillingNewAddress_Email"), "mukz123@gmail.com");
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "233");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "123 The Best Street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "AB1 2CD");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "11223344556");
        // Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@id = 'billing-buttons-container']//button[@class = 'button-1 new-address-next-step-button']"));
        //Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(1000);
        clickOnElement(By.id("shippingoption_1"));
        // Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class = 'button-1 shipping-method-next-step-button']"));
        //Select Radio Button “Credit Card”
        Thread.sleep(1000);
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class = 'button-1 payment-method-next-step-button']"));
        //Select “Master card” From Select credit card dropdown
        Thread.sleep(1000);
        selectByValueFromDropDown(By.id("CreditCardType"), "MasterCard");
        //Fill all the details
        Thread.sleep(1000);
        sendTextToElement(By.id("CardholderName"), "Mr.M.Shah");
        sendTextToElement(By.id("CardNumber"), "5534 5678 1234 5678");
        selectByValueFromDropDown(By.id("ExpireMonth"), "5");
        selectByValueFromDropDown(By.id("ExpireYear"), "2027");
        sendTextToElement(By.id("CardCode"), "587");
        // Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@id = 'payment-info-buttons-container']//button[@class = 'button-1 payment-info-next-step-button']"));
        //Verify “Payment Method” is “Credit Card”
        String expectedPaymentMethod = "Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Unable to verify payment method.", expectedPaymentMethod, actualPaymentMethod);
        // Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod = "Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//span[normalize-space() = 'Next Day Air']"));
        Assert.assertEquals("Unable to verify shipping method.", expectedShippingMethod, actualShippingMethod);
        // Verify Total is “$2,950.00”
        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//span[1]/strong[1]"));
        Assert.assertEquals("Unable to match total.", expectedTotal, actualTotal);
        // Click on “CONFIRM”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        // Verify the Text “Thank you”
        String expectedThankYouText = "Thank you";
        String actualThankYouText = getTextFromElement(By.xpath("//h1[(text() = 'Thank you')]"));
        Assert.assertEquals("Unable to verify Thank You text.", expectedThankYouText, actualThankYouText);
        // Verify the message “Your order has been successfully processed!”
        String expectedSuccessfulText = "Your order has been successfully processed!";
        String actualSuccessfulText = getTextFromElement(By.xpath("//strong[(text() = 'Your order has been successfully processed!')]"));
        Assert.assertEquals("Unable to verify successful text.", expectedSuccessfulText, actualSuccessfulText);
        //Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[(text() = 'Continue')]"));
        // Verify the text “Welcome to our store”
        String expectedWelcomeText = "Welcome to our store";
        String actualWelcomeText = getTextFromElement(By.xpath("//h2[(text() = 'Welcome to our store')]"));
        Assert.assertEquals("Unable to verify welcome text", expectedWelcomeText, actualWelcomeText);
    }

    @After
    public void tearDown() {

        closeBrowser();
    }
}
