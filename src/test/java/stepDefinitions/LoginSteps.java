package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;

/**
 * LoginSteps — Step definitions for login feature
 */
public class LoginSteps {

    private LoginPage loginPage;

    @Given("the user is on the banking login page")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(Hooks.driver);
        loginPage.navigateToLoginPage();
    }

    @When("the user enters valid username {string} and password {string}")
    public void userEntersValidCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @When("the user enters invalid username {string} and password {string}")
    public void userEntersInvalidCredentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("the user should be redirected to the dashboard")
    public void userShouldSeeTheDashboard() {
        Assert.assertTrue(loginPage.isDashboardDisplayed(),
                "Dashboard not displayed after login");
    }

    @Then("the user should see error message {string}")
    public void userShouldSeeErrorMessage(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage,
                "Error message mismatch");
    }
}
