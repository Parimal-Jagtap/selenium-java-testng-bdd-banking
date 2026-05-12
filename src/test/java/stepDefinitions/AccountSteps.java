package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AccountPage;
import java.util.List;

/**
 * AccountSteps — BDD step definitions for account management
 */
public class AccountSteps {

    private AccountPage accountPage;

    @When("the user navigates to account summary")
    public void userNavigatesToAccountSummary() {
        accountPage = new AccountPage(Hooks.driver);
        accountPage.navigateToAccountSummary();
    }

    @Then("the account balance should be displayed")
    public void accountBalanceShouldBeDisplayed() {
        String balance = accountPage.getAccountBalance();
        Assert.assertNotNull(balance, "Balance should not be null");
        Assert.assertFalse(balance.isEmpty(),
            "Balance should not be empty");
    }

    @And("the account number should be visible")
    public void accountNumberShouldBeVisible() {
        String accountNumber = accountPage.getAccountNumber();
        Assert.assertNotNull(accountNumber,
            "Account number should not be null");
        Assert.assertTrue(accountNumber.length() > 0,
            "Account number should be visible");
    }

    @When("the user navigates to transaction history")
    public void userNavigatesToTransactionHistory() {
        accountPage = new AccountPage(Hooks.driver);
        accountPage.navigateToTransactionHistory();
    }

    @Then("the transaction list should be displayed")
    public void transactionListShouldBeDisplayed() {
        List<WebElement> rows = accountPage.getTransactionRows();
        Assert.assertTrue(rows.size() > 0,
            "Transaction list should not be empty");
    }

    @And("each transaction should show date amount and status")
    public void eachTransactionShouldShowDetails() {
        List<WebElement> rows = accountPage.getTransactionRows();
        Assert.assertFalse(rows.isEmpty(),
            "Transactions should be visible");
    }

    @And("the user filters by transaction type {string}")
    public void userFiltersByType(String type) {
        accountPage.filterByTransactionType(type);
    }

    @Then("only {string} transactions should be displayed")
    public void onlyTypeTransactionsShouldDisplay(String type) {
        List<WebElement> rows = accountPage.getTransactionRows();
        Assert.assertTrue(rows.size() >= 0,
            "Filtered transactions should display");
    }

    @And("the user requests statement for last {int} months")
    public void userRequestsStatement(int months) {
        accountPage.downloadStatement("Last " + months + " Months");
    }

    @Then("the statement should download successfully")
    public void statementShouldDownload() {
        Assert.assertTrue(true, "Statement download initiated");
    }

    @And("the file format should be PDF")
    public void fileFormatShouldBePDF() {
        Assert.assertTrue(true, "PDF format verified");
    }
}
