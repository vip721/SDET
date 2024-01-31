package Steps;
import Common.BaseTest;
import Common.TestDataReader;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class LoginStep {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {

        BaseTest.getDriver().get("https://www.saucedemo.com/");
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        loginPage.verifyUserLoggedInSuccessFully();

    }

    @When("User enters invalid username {string} and password {string}")
    public void user_enters_invalid_username_and_password(String validUsername, String validUassword) {
       loginPage.loginWithInValidCredentials(validUsername,validUassword);
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
       loginPage.verifyErrorMessages();
    }

    @When("User enters valid username {string} and password {string}")
    public void userEntersValidUsernameAndPassword(String invalidUsername, String invalidPassword) {
        loginPage.loginWithValidCredentials(invalidUsername,invalidPassword);
    }

}

