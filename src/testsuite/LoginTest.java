package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Enter username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); //Enter password
        driver.findElement(By.id("login-button")).click(); //click on login button
        //Verify the text 'PRODUCTS'
        String expectedMessage = "Products";
        //Xpath for “Products”
        WebElement actualTextElements = driver.findElement(By.xpath("//span[text() = 'Products']"));

        String actualMessage = actualTextElements.getText();
        //comparing actualMessage with expectedMessage
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //Enter username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); //Enter password
        driver.findElement(By.id("login-button")).click(); //click on login button
        List<WebElement> sliderElementList = driver.findElements(By.className("inventory_item"));
        System.out.println("Total slide is : " + sliderElementList.size());
    }

    @After
    public void testDown() {
        closeBrowser();
    }

}
