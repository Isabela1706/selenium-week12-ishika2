package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        //Mouse hover on the Desktops Tab. and click
        mouseHoverAndClickOnElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
        //Click on “Show AllDesktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        //Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");

        //Verify the Product will be arranged in Descending order.
        List<String> listOfProducts = new ArrayList<>();
        List<WebElement> productsDisplay = driver.findElements(By.xpath("//div [@class = 'col-md-4 col-xs-6']/div/select/option[3]"));


        for(WebElement element : productsDisplay){
            listOfProducts.add(element.getText());
        }

        List<String> listsNumber = new ArrayList<>();

        Collections.sort(listsNumber, Collections.reverseOrder(String::compareToIgnoreCase));
        Assert.assertEquals(listOfProducts, listsNumber);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){




        //Mouse hover on the Currency Dropdown and click
        mouseHoverAndClickOnElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']"));

        //Mouse hover on the £Pound Sterling and click
        mouseHoverAndClickOnElement(By.xpath("//button[normalize-space()='£Pound Sterling']"));

        //Mouse hover on the Desktops Tab.
        mouseHoverToElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));

        //Click on the “Show AllDesktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));

        //Select the Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (A - Z)");

        //Select product “HP LP3065”
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));

        //Verify
        String productName = getTextFromElement(By.xpath("//h1[normalize-space()='HP LP3065']"));
        verifyText("Invalid Display", "HP LP3065", productName);

        //Select Delivery Date "2024-11-27"

        String year = "2024";
        String month = "11";
        String day = "27";
        clickOnElement(By.xpath("//div[@class='input-group date']//button[@type='button']"));
        while (true) {
            String monthYear = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='picker-switch']")).getText(); //of Date and year element title in calender
            String[] a = monthYear.split(" "); //Splitting month and year
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));
            }
        }
        //Select date
        List<WebElement> dates =driver.findElements(By.xpath("//div[@class='datepicker-days']//tbody//tr//td"));
        for (WebElement date : dates) {
            System.out.println(date.getText());
            if (date.getText().equals(day)) {
                date.click();
                break;
            }
}

        //I can not figure out why loop is not stopping


        //2.9.Enter Qty "1” using Select class.
        driver.findElement(By.id("input-quantity")).click();
        sendTextElement(By.id("input-quantity"),"1");

        //Click on the “Add to Cart” button
        clickOnElement(By.id("button-cart"));

        //Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String messageSuccessfullyAddedToCart = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).trim().split(" \n  ")[0];
        verifyText("Invalid Message Display", "Success: You have added HP LP3065 to your shopping cart!", messageSuccessfullyAddedToCart);

        //click on link
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //Verify the text "Shopping Cart"
        String shoppingCartText = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).trim().split(" ")[0];
        verifyText("Invalid Text Display", "Shopping Cart", shoppingCartText);

        //Verify the Product name "HP LP3065"
        String productNameHp = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        verifyText("Invalid Product Name ", "HP LP3065", productNameHp);

        //Verify the Delivery Date "2024-11-27"
        String deliveryDate = getTextFromElement(By.xpath("//small[normalize-space()='Delivery Date:2024-11-27']"));
        verifyText("Invalid Date display", "2024-11-27", deliveryDate);

        //Verify the Model "Product21"
        String modelProduct = getTextFromElement(By.xpath("//td[normalize-space()='Product 21']"));
        verifyText("Invalid Model", "Product 21", modelProduct);

        //Verify the Todat "£122.00"
        String totalPrice = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        verifyText("Invalid Total At the end", "$122.00", totalPrice);







    }
    @After
    public void tearDown() {
         closeBrowser();
    }

}
