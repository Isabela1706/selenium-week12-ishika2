package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        String menuName = "//a[normalize-space()='" + menu + "]";
        WebElement menuElement = driver.findElement(By.xpath(menuName));
        menuElement.click();

    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){

        String nameMenu = "Books";
        selectMenu(nameMenu);
        //Mouse hover on the “Desktops” Tab and click
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Desktops']"));
        //call the selectMenu() method and pass the menu = “Show AllDesktops”
        selectMenu("Show AllDesktops");
        //Verify the text ‘Desktops’
        String desktopHeading = getTextFromElement(By.xpath("//ul [@class ='nav navbar-nav']/li[1]/a"));
        verifyText("Invalid desktop heading", "Desktops", desktopHeading);


    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        //Mouse hover on the “Laptops & Notebooks” Tab and click
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //call selectMenu() method and pass the menu = “Show AllLaptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
        //Verify the text ‘Laptops & Notebooks’
        String laptopsAndNotebooksHeading = getTextFromElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"));
        verifyText("Invalid Laptop & Notebook heading", "Laptops & Notebooks", laptopsAndNotebooksHeading);

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        //Mouse hover on the “Components” Tab and click
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Components']"));
        //call the selectMenu() method and pass the menu = “Show AllComponents”
        selectMenu("Show AllComponents");
        //Verify the text ‘Components’
        String componentsTextDisplay = getTextFromElement(By.xpath("//a[normalize-space()='Components']"));
        verifyText("Invalid Components Heading", "Components", componentsTextDisplay);


    }
    @After
    public void tearDown() {
      closeBrowser();
    }


}
