package seleniumHW2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumHW2.webdriver.Web;

public class TestCases {

    /**
     * Testcase-1:
     *
     *
     * Verify "Keep me signed in" is NOT selected for messenger login page
     *
     * Click "Log in" button
     *
     * Verify "Incorrect email or phone number" is displayed
     *
     * Verify "Continue" button is enabled
     *
     *
     */

    /**
     * Steps:
     * 1. Launch https://www.facebook.com/
     * 2. Click messenger link
     * 3. Verify 'keep me signed in' checkbox is not selected
     *
     */
    @Test
    public static void isSignedInSelected (){
        Web.launchUrlOnNewWindow("https://www.facebook.com/");
        By messangerLocator = By.xpath("//a[@ href='https://messenger.com/']");
        WebElement messengerElement = Web.getDriver().findElement(messangerLocator);
        messengerElement.click();
        By checkBox = By.xpath("//span[@class='_2qcu']");
        WebElement checkBoxElement = Web.getDriver().findElement(checkBox);
        Assert.assertFalse(checkBoxElement.isSelected(),"Checkbox is selected");

    }


    /**
     * Testcase-2:
     * On Create new account page:
     *
     * Verify the "Sign Up" button is enabled when user lands on the form
     *
     * Enter the below details in Sign Up form EXCEPT DOB
     * First name
     * Last name
     * email
     * re-enter email
     * new password
     * click Sign Up
     *
     * Verify "Please choose a gender. You can change who can see this later." is displayed
     *
     */

}
