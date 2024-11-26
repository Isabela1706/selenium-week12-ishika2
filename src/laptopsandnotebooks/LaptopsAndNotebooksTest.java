package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        //Mouse hover on the Laptops & Notebooks Tab. and click
        mouseHoverAndClickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

        //Click on “Show AllLaptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));

        //Select the Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");

        //Verify the Product price will be arranged in High to Low orders.


    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully(){
        //Mouse hover on the Laptops & Notebooks Tab and click
        mouseHoverAndClickOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

        //Click on the “Show AllLaptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));

        //Select the Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");

        //Select Product “MacBook”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/h4[1]/a[1]"));

        //Verify the text “MacBook”
        String textMacBook = getTextFromElement(By.xpath("//h1[normalize-space()='MacBook']"));
        verifyText("Invalid Text", "MacBook", textMacBook);

        //Click on the ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //Verify the message “Success: You have added MacBook to your shopping cart!”
        String successMessage = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).trim().split("\n ")[0];
        verifyText("Unsuccessful Message", "Success: You have added MacBook to your shopping cart!", successMessage);

        //Click on the link “shopping cart” display into the success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //Verify the text "Shopping Cart"
        String cartText = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).trim().split(" ")[0];
        verifyText("Invalid text", "Shopping Cart", cartText);

        //Verify the Product name "MacBook"
        String productName = getTextFromElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")).trim().split("\n ")[0];
        verifyText("Invalid Product", "MacBook", productName);

        //Change the Quantity "2"
        driver.findElement(By.name("quantity[205620]")).click();
        sendTextElement(By.name("quantity[205620]"), "2");

        //This product is not available

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
