package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option){
      clickOnElement(By.xpath("//a[normalize-space()='"+ option +"]"));

   }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        //1.1 Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));



        // 1.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        clickOnElement(By.xpath("//a[normalize-space()='Register']"));


        // 1.3 Verify the text “Register Account”.
        String registerAccountText =getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
        verifyText("Invalid Text Display", "Register Account", registerAccountText);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){


        //2.1 Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));


        //2.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Login”

        selectMyAccountOptions("Login");




        // 2.3 Verify the text “Returning Customer”.
        String returningCustomerText =getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']"));
        verifyText("invalid display Text:", "Returning Customer", returningCustomerText);



    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){


        //3.1 Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));

        // 3.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        clickOnElement(By.xpath("//a[normalize-space()='Register']"));

        //3.3 Enter the First Name
        sendTextElement(By.id("input-firstname"),"Alex");

        //3.4 Enter the Last Name
        sendTextElement(By.id("input-lastname"),"Patel");

        //3.5 Enter the Email
        sendTextElement(By.id("input-email"),"Alex127@gamil.com");

        //3.6 Enter the Telephone
        sendTextElement(By.id("input-telephone"),"+447876676895");


        // 3.7 Enter the Password
        sendTextElement(By.id("input-password"),"Alex0000");

        //3.8 Enter the Password Confirm
        sendTextElement(By.id("input-confirm"),"Alex0000");


        // 3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));


        //3.10 Click on the Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));


        //3.11 Click on the Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));


        // 3.12 Verify the message “Your Account Has Been Created!”
        String accountCreated = getTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        verifyText("Invalid Heading", "Your Account Has Been Created!", accountCreated);



        // 3.13 Click on the Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));



        //3.14 Click on the My Account Link.
        clickOnElement(By.xpath("//a[normalize-space()='Account']"));




        //3.15 Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
//        selectMyAccountOptions("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']");



        // 3.16 Verify the text “Account Logout”
//
       String accountLogoutText =getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        verifyText("Invalid Account Logout", "Account Logout", accountLogoutText);



        //3.17 Click on the Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));


    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){  // done


        // 4.1 Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));


        // 4.2 Call the method “selectMyAccountOptions()” method and pass the  parameter “Login”
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));

        //4.3 Enter the Email address
        sendTextElement(By.id("input-email"),"Alex@gamil.com");



        // 4.5 Enter the Password
        sendTextElement(By.id("input-password"),"Alex0000");

        //4.6 Click on the Login button
        clickOnElement(By.xpath("//input[@value='Login']"));



        // 4.7 Verify text “My Account”
        String myAccountText=getTextFromElement(By.xpath("//h2[normalize-space()='My Account']"));
        verifyText("Invalid text:", "My Account", myAccountText);


        // 4.8 Click on the My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));



        //4.9 Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”

        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));



        // 4.10 Verify the text “Account Logout”

        String accountLogOutText =getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        verifyText("invalid text:","Account Logout",accountLogOutText);



        //4.11 Click on the Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));



    }
    @After
    public void tearDown() {
        closeBrowser();
    }





}





