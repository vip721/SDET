package Pages;

import Common.BaseTest;
import Common.TestDataReader;
import org.testng.Assert;
import org.openqa.selenium.By;

public class LoginPage  {


     TestDataReader testDataReader = new TestDataReader();
    String usernameInput="user-name";
    String passwordInput="password";

    String btnLogin="input[id='login-button']";
    String errorMessage="h3[data-test='error']";




    public void  loginWithValidCredentials(String validUser,String validPass){

        String validUsername = TestDataReader.readData(validUser, 1);
        String validPassword = TestDataReader.readData(validPass, 1);
        BaseTest.getDriver().findElement(By.id(usernameInput)).sendKeys(validUsername);
        BaseTest.getDriver().findElement(By.id(passwordInput)).sendKeys(validPassword);
        BaseTest.getDriver().findElement(By.cssSelector(btnLogin)).click();

    }

    public void  loginWithInValidCredentials(String invalidUser,String invalidPass){

        String invalidUsername = TestDataReader.readData(invalidUser, 2);
        String invalidPassword = TestDataReader.readData(invalidPass, 2);
        BaseTest.getDriver().findElement(By.id(usernameInput)).sendKeys(invalidUsername);
        BaseTest.getDriver().findElement(By.id(passwordInput)).sendKeys(invalidPassword);
        BaseTest.getDriver().findElement(By.cssSelector(btnLogin)).click();

    }

    public  void  verifyUserLoggedInSuccessFully(){
        String expectedTitle = "Swag Labs";
        String expectedUrl="https://www.saucedemo.com/inventory.html";
        String actualTitle = BaseTest.getDriver().getTitle();
        String actualUrl= BaseTest.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertEquals(expectedUrl, actualUrl);

    }

    public void verifyErrorMessages(){
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = BaseTest.getDriver().findElement(By.cssSelector(errorMessage)).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }



}
