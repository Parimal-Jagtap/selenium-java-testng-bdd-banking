package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.TransferPage;

/**
 * TransferSteps — Step definitions for fund transfer feature
 */
public class TransferSteps {

    private TransferPage transferPage;

    @When("the user navigates to fund transfer module")
    public void userNavigatesToFundTransfer() {
        transferPage = new TransferPage(Hooks.driver);
        transferPage.navigateToTransferModule();
    }

    @And("the user selects transfer type {string}")
    public void userSelectsTransferType(String type) {
        transferPage.selectTransferType(type);
    }

    @And("the user enters beneficiary account {string}")
    public void userEntersBeneficiaryAccount(String accountNumber) {
        transferPage.enterBeneficiaryAccount(accountNumber);
    }

    @And("the user enters transfer amount {string}")
    public void userEntersTransferAmount(String amount) {
        transferPage.enterAmount(amount);
    }

    @And("the user enters remarks {string}")
    public void userEntersRemarks(String remarks) {
        transferPage.enterRemarks(remarks);
    }

    @And("the user submits the transfer")
    public void userSubmitsTransfer() {
        transferPage.submitTransfer();
    }

    @Then("the transfer should be successful")
    public void transferShouldBeSuccessful() {
        Assert.assertTrue(transferPage.isTransferSuccessful(),
                "Fund transfer was not successful");
        System.out.println("Transaction ID: " + transferPage.getTransactionId());
    }
}
